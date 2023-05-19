package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.ProductInfoMapper;
import com.pojo.ProductInfo;
import com.pojo.ProductInfoExample;
import com.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    //业务层一定会调用dao层对象
    @Autowired
    ProductInfoMapper productInfoMapper;
    //查询所有数据
    @Override
    public List<ProductInfo> selectAll() {
        //example不进行操作相当于没有写where语句,也就是全部查询
        return productInfoMapper.selectByExample(new ProductInfoExample());
    }
    //分页查询
    @Override
    public PageInfo splitPage(int page,int pageSize){
        //重点,在取集合之前,使用分页工具设置当前页和每页的工具
        PageHelper.startPage(page,pageSize);
        //创建一个productInfoExample类,并且创造查询条件
        ProductInfoExample productInfoExample = new ProductInfoExample();
        productInfoExample.setOrderByClause("p_id desc");
        List<ProductInfo> productInfos = productInfoMapper.selectByExample(productInfoExample);
        //将查询到的集合封装到pageInfo
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(productInfos);

        return pageInfo;
    }

}
