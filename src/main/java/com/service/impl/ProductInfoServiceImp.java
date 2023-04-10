package com.service.impl;

import com.mapper.ProductInfoMapper;
import com.pojo.ProductInfo;
import com.pojo.ProductInfoExample;
import com.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductInfoServiceImp implements ProductInfoService {
    //业务层一定会调用dao层对象
    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> selectAll() {
        //example不进行操作相当于没有写where语句,也就是全部查询
        return productInfoMapper.selectByExample(new ProductInfoExample());
    }
}
