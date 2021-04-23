package com.webbdong.springboot.jpa.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author Webb Dong
 * @date 2018-04-23 12:49 AM
 */
@Configuration
public class GsonConfig {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
                .create();
    }

    /**
     * 解决在将 hibernate 对象序列化成 JSON 时，报的
     * java.lang.UnsupportedOperationException: Attempted to serialize java.lang.Class: org.hibernate.proxy.HibernateProxy. Forgot to register a type adapter? 异常
     */
    private static class HibernateProxyTypeAdapter extends TypeAdapter<HibernateProxy> {

        public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
            @SuppressWarnings("unchecked")
            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
                return (HibernateProxy.class.isAssignableFrom(type.getRawType()) ? (TypeAdapter<T>) new HibernateProxyTypeAdapter(gson) : null);
            }
        };

        private final Gson context;

        private HibernateProxyTypeAdapter(Gson context) {
            this.context = context;
        }

        @Override
        public HibernateProxy read(JsonReader in) throws IOException {
            throw new UnsupportedOperationException("Not supported");
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        @Override
        public void write(JsonWriter out, HibernateProxy value) throws IOException {
            if (value == null) {
                out.nullValue();
                return;
            }
            // Retrieve the original (not proxy) class
            Class<?> baseType = Hibernate.getClass(value);
            // Get the TypeAdapter of the original class, to delegate the serialization
            TypeAdapter delegate = context.getAdapter(TypeToken.get(baseType));
            // Get a filled instance of the original class
            Object unproxiedValue = value.getHibernateLazyInitializer()
                    .getImplementation();
            // Serialize the value
            delegate.write(out, unproxiedValue);
        }

    }

}
