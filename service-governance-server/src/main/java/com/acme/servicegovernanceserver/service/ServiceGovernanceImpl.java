package com.acme.servicegovernanceserver.service;

import com.acme.rc.service.TRegistCenter;
import com.acme.servicegovernanceserver.storage.MemoryStorageImpl;
import com.acme.servicegovernanceserver.storage.domain.MachineDomain;
import com.acme.sg.Dto.MachineInfo;
import com.acme.sg.Dto.MachineInfoParam;
import com.acme.sg.Dto.MachineInfoResult;
import com.acme.sg.Exception.ServiceGovernanceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author acme
 * @date 2019/12/1 8:35 PM
 */
@Slf4j
@Service
public class ServiceGovernanceImpl implements IServiceGovernance {

    private final static int HEARTBEAT_TIME = 15000; // ms

    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    {
        executorService.scheduleWithFixedDelay(this::checkAlive, 10, 10, TimeUnit.SECONDS);
    }
    @Autowired
    private MemoryStorageImpl memoryStorage;
    @Autowired
    private TRegistCenter.Client tRegistCenterClient;

    @Override
    public MachineInfoResult getMachineList(String appKey) throws ServiceGovernanceException, TException {
        return buildMachineInfoResult(memoryStorage.getList(appKey));
    }

    @Override
    public void start(MachineInfoParam machineInfo) throws ServiceGovernanceException, TException {
        if(!tRegistCenterClient.isRegist(machineInfo.getAppKey())){
            throw new ServiceGovernanceException(1, "服务未注册");
        }
        log.info("start, machineInfo:{}", machineInfo);
        memoryStorage.save(buildMachineDomain(machineInfo));
    }

    @Override
    public void heartbeat(MachineInfoParam machineInfo) {
        try {
            List<MachineDomain> machineDomains = memoryStorage.getList(machineInfo.getAppKey());
            machineDomains.forEach(v -> {
                v.setStatus(1);
                v.setUpdateTime(System.currentTimeMillis());
            });
            memoryStorage.update(machineDomains);
        } catch (ServiceGovernanceException e) {
            e.printStackTrace();
        }
    }

    private MachineInfoResult buildMachineInfoResult(List<MachineDomain> domainList) {
        return new MachineInfoResult(domainList.stream().map(v -> new MachineInfo(v.getIp(), v.getPort())).collect(Collectors.toList()));
    }

    private List<MachineDomain> buildMachineDomain(MachineInfoParam param){
        String appKey = param.getAppKey();
        return param.getParams().stream().map(v -> {
            MachineDomain domain = new MachineDomain();
            domain.setAppKey(appKey);
            domain.setIp(v.getIp());
            domain.setPort(v.getPort());
            domain.setCreateTime(System.currentTimeMillis());
            domain.setUpdateTime(System.currentTimeMillis());
            domain.setStatus(1);
            return domain;
        }).collect(Collectors.toList());
    }

    private void checkAlive() {
        try {
            List<MachineDomain> domains = memoryStorage.getAll();
            long curTime = System.currentTimeMillis();
            for (MachineDomain domain : domains){
                if(curTime - domain.getUpdateTime() > HEARTBEAT_TIME){
                    domain.setStatus(0);
                    memoryStorage.update(Collections.singletonList(domain));
                    log.warn("checkAlive -> curTime:{} -> offline:{}", curTime, domain);
                }
            }
        } catch (Throwable e){

        }
    }
}
