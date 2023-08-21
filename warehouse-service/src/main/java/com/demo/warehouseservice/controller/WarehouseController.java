package com.demo.warehouseservice.controller;

import com.demo.warehouseservice.dto.Stock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

    @GetMapping("/stock")
    public Stock getStock(Long skuId) {
        Stock stock = null;
        if (skuId == 1001L) {
            //有库存
            stock = new Stock(1001L, "Apple iPhone11 128GB紫色", 32, "台");
            stock.setDescription("Apple11 紫色版对应商品描述");
        } else if(skuId == 1002L) {
            //无库存
            stock = new Stock(1002L, "Apple iPhone12 128GB白色", 0, "台");
            stock.setDescription("Apple12 白色版对应商品描述");
        } else{
            stock = new Stock(skuId,"", 0,"");
        }
        return stock;
    }
}
