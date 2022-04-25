package com.kaykay.dianping.config;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 3:38 下午 2022/4/21.
 * @Modified By:
 */

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * todo
 *
 * @author hk
 * @version Id: ElasticsearchRestClient.java, v 0.1 2022/4/21 3:38 下午 Exp $$
 */
@Configuration
public class ElasticsearchRestConfig {

    @Value("${elasticsearch.ip}")
    String ipAddress;

    @Bean(name="highLevelClient")
    public RestHighLevelClient highLevelClient(){
        String[] address = ipAddress.split(":");
        String  ip = address[0];
        int port = Integer.valueOf(address[1]);
        HttpHost httpHost = new HttpHost(ip,port,"http");
        return new RestHighLevelClient(RestClient.builder(new HttpHost[]{httpHost}));
    }
}