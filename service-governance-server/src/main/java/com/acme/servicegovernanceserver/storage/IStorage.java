package com.acme.servicegovernanceserver.storage;

import com.acme.servicegovernanceserver.storage.domain.MachineDomain;
import com.acme.sg.Exception.ServiceGovernanceException;

import java.util.List;

/**
 * @author acme
 * @date 2019/12/1 8:29 PM
 */
public interface IStorage {
    void save(List<MachineDomain> domains);
    void update(List<MachineDomain> domains) throws ServiceGovernanceException;
    void delete(String appKey) throws ServiceGovernanceException;
    List<MachineDomain> getList(String appKey) throws ServiceGovernanceException;
    List<MachineDomain> getAll() throws ServiceGovernanceException;
}
