package com.time.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.time.demo.entity.Order;
import com.time.demo.service.IOrderService;
import com.time.demo.util.RegularExpressionUtil;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService iOrderService;

	@RequestMapping("/deleteByPrimaryKey")
	public int deleteByPrimaryKey(Integer orderid) {
		return iOrderService.deleteByPrimaryKey(orderid);
	}

	@RequestMapping("/selectByPrimaryKey")
	public Order selectByPrimaryKey(Integer orderid) {
		return iOrderService.selectByPrimaryKey(orderid);
	}
	
	// 添加订单
	@RequestMapping(value = "/insertOrder")
	public int insertOrder(@RequestBody Order order) {
		order.setCreatetime(new Date());
		order.setOrdernumber(RegularExpressionUtil.getOrderNumber());
		System.out.println(order);
		return iOrderService.insertSelective(order);
	}

	// 必须传入用户名，如果订单编号和商品名称不为空，则作为查询条件传入，如果都为空则默认查询该用户下所有订单
	@RequestMapping("/selectByUsername")
	public List<Order> selectByUsername(HttpServletResponse response, String username, Integer ordernumber,
			String product) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("ordername", ordernumber);
		map.put("product", product);

		return iOrderService.selectByUserName(map);
	}
	
	//修改用户订单 测
		@RequestMapping("/updateOrder")
		public int updateOrder(HttpServletResponse response,Order order) {
			response.setHeader("Access-Control-Allow-Origin", "*");
			return iOrderService.updateByPrimaryKeySelective(order);
		}

	//拉取所有的用户的订单 测
	@RequestMapping("/selectAll")
	public List<Order> selectAll(HttpServletResponse response,Integer start,Integer number) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return iOrderService.selectAll(start,number);
	}

}
