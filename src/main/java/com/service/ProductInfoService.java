package com.service;

import com.pojo.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    /**
     * 显示全部商品,不进行分页
     * @return
     */
    public List<ProductInfo> selectAll();
}
