package com.demo.orderservice.controller;

import com.demo.orderservice.dto.Stock;
import com.demo.orderservice.feign.WarehouseServiceFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class OrderController {
    @Resource
    private WarehouseServiceFeignClient warehouseServiceFeignClient;

    @GetMapping("/create_order")
    public Map createOrder(Long skuId, Long salesQuantity) {
        Map result = new LinkedHashMap<>();
        Stock stock = warehouseServiceFeignClient.getStock(skuId);
        System.out.println(stock);
        if (salesQuantity <= stock.getQuantity()) {
            result.put("code", "SUCCESS");
            result.put("skuId", skuId);
            result.put("message", "订单创建成功");
        } else {
            result.put("code", "NOT_ENOUGH_STOCK");
            result.put("skuId", skuId);
            result.put("message", "商品库存数量不足");
        }
        return result;
    }
}
