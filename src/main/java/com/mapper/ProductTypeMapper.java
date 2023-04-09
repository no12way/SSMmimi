package com.mapper;

import com.pojo.ProductType;
import com.pojo.ProductTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductTypeMapper {
    long countByExample(ProductTypeExample example);

    int deleteByExample(ProductTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(ProductType row);

    int insertSelective(ProductType row);

    List<ProductType> selectByExample(ProductTypeExample example);

    ProductType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("row") ProductType row, @Param("example") ProductTypeExample example);

    int updateByExample(@Param("row") ProductType row, @Param("example") ProductTypeExample example);

    int updateByPrimaryKeySelective(ProductType row);

    int updateByPrimaryKey(ProductType row);
}