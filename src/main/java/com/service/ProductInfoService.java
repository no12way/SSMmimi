package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    /**
     * 显示全部商品,不进行分页
     * @return
     */
    public List<ProductInfo> selectAll();

    /**
     * 分页查询
     * @param page (代表第几页)
     * @param pageSize (每页数据大小)
     * @return
     */
    public PageInfo splitPage(int page, int pageSize);
}
