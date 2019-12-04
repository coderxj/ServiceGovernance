package com.acme.servicegovernanceserver.storage;

import com.acme.servicegovernanceserver.storage.domain.MachineDomain;
import com.acme.sg.Exception.ServiceGovernanceException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author acme
 * @date 2019/12/1 8:30 PM
 */
@Service
public class MemoryStorageImpl implements IStorage {

    private final Map<String, List<MachineDomain>> domainMap = new ConcurrentHashMap<>();

    @Override
    public void save(MachineDomain domain){
        if(!domainMap.containsKey(domain.getAppKey())){
            domainMap.put(domain.getAppKey(), new ArrayList<>());
            domainMap.get(domain.getAppKey()).add(domain);
        } else {
            add(domain);
        }
    }

    @Override
    public void update(MachineDomain domain) throws ServiceGovernanceException {
        if(!domainMap.containsKey(domain.getAppKey())){
            throw new ServiceGovernanceException(1, "未发现该服务的机器");
        }
        if(StringUtils.isEmpty(domain.getIp()) || StringUtils.isEmpty(domain.getPort())){
            throw new ServiceGovernanceException(2, "IP或PORT不能为空");
        }
        add(domain);
    }

    @Override
    public void delete(String appKey) throws ServiceGovernanceException {
        if(!domainMap.containsKey(appKey)){
            throw new ServiceGovernanceException(1, "未发现该服务的机器");
        }
        domainMap.remove(appKey);
    }

    @Override
    public List<MachineDomain> getList(String appKey) throws ServiceGovernanceException {
        if(!domainMap.containsKey(appKey)){
            throw new ServiceGovernanceException(1, "未发现该服务的机器");
        }
        return domainMap.get(appKey);
    }

    @Override
    public List<MachineDomain> getAll() throws ServiceGovernanceException {
        List<MachineDomain> res = new ArrayList<>();
        for (List<MachineDomain> domains : domainMap.values()){
            res.addAll(domains);
        }
        return res.stream().filter(v -> v.getStatus() == 1).collect(Collectors.toList());
    }

    private void add(MachineDomain domain){
        boolean hasAdd = false;
        for (MachineDomain md : domainMap.get(domain.getAppKey())){
            if(md.getIp().equals(domain.getIp()) && md.getPort().equals(domain.getPort())){
                md.setStatus(domain.getStatus());
                md.setUpdateTime(System.currentTimeMillis());
                hasAdd = true;
                break;
            }
        }
        if(!hasAdd){
            domainMap.get(domain.getAppKey()).add(domain);
        }
    }
}
