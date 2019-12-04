package com.acme.servicegovernanceserver.thriftconfig;

import com.acme.rc.service.TRegistCenter;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author acme
 * @date 2019/12/1 9:10 PM
 */
@Configuration
public class ThriftClientConfig {

    @Value("${RegistCenter.host}")
    private String registCenterHost;
    @Value("${RegistCenter.port}")
    private Integer registCenterPort;

    @Bean
    public TRegistCenter.Client tRegistCenterClient() throws TException {
        TSocket socket = new TSocket(registCenterHost, registCenterPort, 20000);
        TFramedTransport transport = new TFramedTransport(socket);
        TProtocol protocol = new TBinaryProtocol(transport);
        TRegistCenter.Client client = new TRegistCenter.Client(protocol);
        transport.open();
        return client;
    }
}
