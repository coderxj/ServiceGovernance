namespace java com.acme.sg.Dto
include 'Enums.thrift'

struct MachineInfoResult{
    //可用的机器IP and port
    1:list<MachineInfo> machineInfo;
}

struct MachineInfo {
    1:string ip;
    2:i32 port;
}

struct MachineInfoParam {
    1:string appKey
    2:list<MachineInfo> params;
}