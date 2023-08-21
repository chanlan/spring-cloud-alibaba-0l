package com.demo.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//必须配置basePackages = {"com.demo.servieapi.feign"}
//不然会报A component required a bean of type 'com.demo.servieapi.feign.WarehouseServiceFeignClient' that could not be found
@EnableFeignClients(basePackages = {"com.demo.servieapi.feign"})
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
