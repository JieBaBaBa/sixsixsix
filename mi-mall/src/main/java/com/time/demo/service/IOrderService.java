package com.time.demo.service;

import java.util.List;
import java.util.Map;

import com.time.demo.entity.Order;

public interface IOrderService {

	int deleteByPrimaryKey(Integer orderid);

	int insert(Order record);

	int insertSelective(Order record);

	Order selectByPrimaryKey(Integer orderid);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);

	List<Order> selectByUserName(Map<String, Object> map);
	
	List<Order> selectAll(Integer start,Integer number);
}
