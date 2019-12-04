package com.acme.servicegovernanceserver.thriftconfig;

import com.acme.servicegovernanceserver.thriftservice.TServiceGovernanceImpl;
import com.acme.servicegovernanceserver.util.NetWorkUtil;
import com.acme.sg.service.TServiceGovernance;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author acme
 * @date 2019/12/1 9:17 PM
 */
@Component
public class ThriftServerBean implements FactoryBean<ThriftServerBean>, InitializingBean {

    private TServer tServer;
    @Value("${local.port}")
    private Integer port;
    @Value("${local.appKey}")
    private String appKey;
    @Autowired
    private TServiceGovernanceImpl serviceGovernance;

    @Override
    public ThriftServerBean getObject() throws Exception {
        return new ThriftServerBean();
    }

    @Override
    public Class<?> getObjectType() {
        return ThriftServerBean.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        TProcessor tProcessor = new TServiceGovernance.Processor<TServiceGovernance.Iface>(serviceGovernance);

        TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(port);

        TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();

        TNonblockingServer.Args tArgs = new TNonblockingServer.Args(serverTransport);

        tArgs.processor(tProcessor);
        tArgs.protocolFactory(protocolFactory);

        tServer = new TNonblockingServer(tArgs);
        System.out.println("[info] ServiceGovernance bootup successful -> " + NetWorkUtil.getInet4Address() + ":" + port);
        new Thread(()-> tServer.serve()).start();
    }
}
