package com.service.impl;

import com.mapper.ProductTypeMapper;
import com.pojo.ProductType;
import com.pojo.ProductTypeExample;
import com.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAllType() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
