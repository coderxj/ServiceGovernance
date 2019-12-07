namespace java com.acme.sg.service

include 'Dto.thrift'
include 'Exception.thrift'

service TServiceGovernance {

    //获取可用机器列表
    Dto.MachineInfoResult getMachineList(1:string appKey) throws (1:Exception.ServiceGovernanceException ex);

    //服务启动，发送机器信息到服务治理中心
    void start(1:Dto.MachineInfoParam machineInfo) throws (1:Exception.ServiceGovernanceException ex);

    //发送心跳信息
    void heartbeat(1:Dto.MachineInfoParam machineInfo) throws (1:Exception.ServiceGovernanceException ex);
}