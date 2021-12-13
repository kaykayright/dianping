package com.kaykay.dianping.common;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:18 下午 2021/12/13.
 * @Modified By:
 */

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;

/**
 * todo
 *
 * @author hk
 * @version Id: JacksonConfig.java, v 0.1 2021/12/13 10:18 下午 Exp $$
 */
@Configuration
public class JacksonConfig {


    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder){

        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

            @Override
            public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeString("");
            }
        });
        return objectMapper;
    }
}