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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
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
    public void heartbeat(MachineInfoParam machineInfo) throws ServiceGovernanceException, TException {

    }

    private MachineInfoResult buildMachineInfoResult(List<MachineDomain> domainList) {
        return new MachineInfoResult(domainList.stream().map(v -> new MachineInfo(v.getIp(), v.getPort())).collect(Collectors.toList()));
    }

    private MachineDomain buildMachineDomain(MachineInfoParam param){
        MachineDomain domain = new MachineDomain();
        domain.setAppKey(param.getAppKey());
        domain.setIp(param.getIp());
        domain.setPort(param.getPort());
        domain.setCreateTime(System.currentTimeMillis());
        domain.setUpdateTime(System.currentTimeMillis());
        domain.setStatus(1);
        return domain;
    }

    private void checkAlive() {
        try {
            List<MachineDomain> domains = memoryStorage.getAll();
            for (MachineDomain domain : domains){
                Socket socket = new Socket();
                try {
                    socket.connect(new InetSocketAddress(domain.getIp(), domain.getPort()));
                } catch (IOException e) {
                    log.info("checkAlive, offline:{}", domain);
                    domain.setStatus(0);
                    domain.setUpdateTime(System.currentTimeMillis());
                    memoryStorage.update(domain);
                }
            }
        } catch (Throwable e){

        }
    }
}
