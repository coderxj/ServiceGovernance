package com.acme.servicegovernanceserver.service;

import com.acme.sg.Dto.MachineInfoParam;
import com.acme.sg.Dto.MachineInfoResult;
import com.acme.sg.Exception.ServiceGovernanceException;
import org.apache.thrift.TException;

/**
 * @author acme
 * @date 2019/12/1 8:34 PM
 */
public interface IServiceGovernance {
    MachineInfoResult getMachineList(String appKey) throws ServiceGovernanceException, TException;

    void start(MachineInfoParam machineInfo) throws ServiceGovernanceException, TException;

    void heartbeat(MachineInfoParam machineInfo) throws ServiceGovernanceException, TException;
}
