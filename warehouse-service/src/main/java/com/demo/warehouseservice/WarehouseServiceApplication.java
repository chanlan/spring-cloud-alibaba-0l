package com.demo.warehouseservice;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class WarehouseServiceApplication {

    //Spring IOC容器初始化时构建OkHttpClient对象
    @Bean
    public okhttp3.OkHttpClient okHttpClient(){
        return new OkHttpClient.Builder()
                //读取超时时间
                .readTimeout(10, TimeUnit.SECONDS)
                //连接超时时间
                .connectTimeout(10, TimeUnit.SECONDS)
                //写超时时间
                .writeTimeout(10, TimeUnit.SECONDS)
                //设置连接池
                .connectionPool(new ConnectionPool())
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(WarehouseServiceApplication.class, args);
    }

}
