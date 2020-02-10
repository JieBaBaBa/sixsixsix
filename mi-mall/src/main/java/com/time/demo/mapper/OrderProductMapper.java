package com.time.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.time.demo.entity.OrderProduct;

@Mapper
public interface OrderProductMapper {
	int deleteByPrimaryKey(Integer orderproductid);

	int insert(OrderProduct record);

	int insertSelective(OrderProduct record);

	int insertProductList(List<OrderProduct> insertProductList);

	OrderProduct selectByPrimaryKey(Integer orderproductid);

	int updateByPrimaryKeySelective(OrderProduct record);

	int updateByPrimaryKey(OrderProduct record);
}