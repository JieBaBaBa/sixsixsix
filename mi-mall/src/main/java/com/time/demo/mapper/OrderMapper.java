package com.time.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.time.demo.entity.Order;

@Mapper
public interface OrderMapper {
	// 根据主键删除
	int deleteByPrimaryKey(Integer orderid);

	// 添加订单
	int insert(Order record);

	// 按条件添加
	int insertSelective(Order record);

	// 按主键查询
	Order selectByPrimaryKey(Integer orderid);

	// 按条件修改
	int updateByPrimaryKeySelective(Order record);

	// 修改全部
	int updateByPrimaryKey(Order record);

	// 按用户名查询
	List<Order> selectByUserName(Map<String, Object> map);
	
	List<Order> selectAll(Integer start,Integer number);
}