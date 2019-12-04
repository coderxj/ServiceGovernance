package com.acme.servicegovernanceserver.thriftservice;

import com.acme.servicegovernanceserver.service.IServiceGovernance;
import com.acme.servicegovernanceserver.service.ServiceGovernanceImpl;
import com.acme.sg.Dto.MachineInfoParam;
import com.acme.sg.Dto.MachineInfoResult;
import com.acme.sg.Exception.ServiceGovernanceException;
import com.acme.sg.service.TServiceGovernance;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author acme
 * @date 2019/12/1 8:31 PM
 */
@Service
public class TServiceGovernanceImpl implements TServiceGovernance.Iface{

    @Autowired
    private ServiceGovernanceImpl serviceGovernance;

    @Override
    public MachineInfoResult getMachineList(String appKey) throws ServiceGovernanceException, TException {
        return serviceGovernance.getMachineList(appKey);
    }

    @Override
    public void start(MachineInfoParam machineInfo) throws ServiceGovernanceException, TException {
        serviceGovernance.start(machineInfo);
    }

    @Override
    public void heartbeat(MachineInfoParam machineInfo) throws ServiceGovernanceException, TException {
        serviceGovernance.heartbeat(machineInfo);
    }
}
