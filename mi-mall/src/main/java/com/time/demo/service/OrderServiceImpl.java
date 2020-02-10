package com.time.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.time.demo.entity.Order;
import com.time.demo.entity.OrderProduct;
import com.time.demo.mapper.OrderMapper;
import com.time.demo.mapper.OrderProductMapper;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderProductMapper orderProductMapper;

	public int deleteByPrimaryKey(Integer orderid) {
		return orderMapper.deleteByPrimaryKey(orderid);
	}

	public int insert(Order record) {
		return orderMapper.insert(record);
	}

	@Transactional
	public int insertSelective(Order order) {
		int flag = orderMapper.insertSelective(order);
		List<OrderProduct> orderProductList = order.getProductlist();
		if (flag > 0) {
			for (OrderProduct orderProduct : orderProductList) {
				System.out.println(orderProduct);
				orderProduct.setOrderid(order.getOrderid());
			}
			return orderProductMapper.insertProductList(orderProductList);
		}
		return 0;
	}

	public Order selectByPrimaryKey(Integer orderid) {
		return orderMapper.selectByPrimaryKey(orderid);
	}

	public int updateByPrimaryKeySelective(Order order) {
		return orderMapper.updateByPrimaryKeySelective(order);
	}

	public int updateByPrimaryKey(Order record) {
		return orderMapper.updateByPrimaryKey(record);
	}

	public List<Order> selectByUserName(Map<String, Object> map) {
		return orderMapper.selectByUserName(map);
	}

	@Override
	public List<Order> selectAll(Integer start,Integer number) {
		return orderMapper.selectAll(start,number);
	}

}
