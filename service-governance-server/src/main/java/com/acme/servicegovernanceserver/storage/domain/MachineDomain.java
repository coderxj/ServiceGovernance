package com.acme.servicegovernanceserver.storage.domain;

import lombok.Data;

/**
 * @author acme
 * @date 2019/12/1 8:25 PM
 */
@Data
public class MachineDomain {
    String appKey;
    String ip;
    Integer port;
    Long createTime;
    Long updateTime;
    Integer status; //1，代表当前机器可用，0代表不可用
}
