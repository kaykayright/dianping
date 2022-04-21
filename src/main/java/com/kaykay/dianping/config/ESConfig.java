package com.kaykay.dianping.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * Created by hzllb on 2019/6/25.
 */
@Configuration
public class ESConfig {


    @Bean
    public TransportClient getClient(){
        TransportClient transportClient = null;
        try {
            //es7 配置文件中的名称
            Settings settings = Settings.builder()
                    .put("cluster.name","myes-service").build();
            transportClient = new PreBuiltTransportClient(settings);
            TransportAddress firstAddress = new TransportAddress(InetAddress.getByName("192.168.199.151"),Integer.parseInt("9300"));
            //TransportAddress secondAddress = new TransportAddress(InetAddress.getByName("127.0.0.1"),Integer.parseInt("9301"));
            //TransportAddress thirdAddress = new TransportAddress(InetAddress.getByName("127.0.0.1"),Integer.parseInt("9302"));
            transportClient.addTransportAddress(firstAddress);
            //transportClient.addTransportAddress(secondAddress);
            //transportClient.addTransportAddress(thirdAddress);

        }catch (Exception e){
            e.printStackTrace();

        }
        return transportClient;
    }
}
