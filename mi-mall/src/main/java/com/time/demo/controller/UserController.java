package com.time.demo.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.time.demo.entity.ShoppingCard;
import com.time.demo.entity.User;
import com.time.demo.service.UserServiceImpl;
import com.time.demo.util.MD5Util;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	// 注册
	@RequestMapping("/registe")
	public int insertUser(HttpServletResponse response, String username, String password) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		User user = new User();
		user.setUsername(username);
		user.setNickname(username);
		user.setPassword(MD5Util.stringMD5(password));

		return userService.insertSelective(user);
	}

	/*
	 * 登陆 返回值 0：没有该用户 1：该用户存在
	 */
	@RequestMapping("/login")
	public int selectUser(HttpServletResponse response, String username, String password) {

		response.setHeader("Access-Control-Allow-Origin", "*");
		User user = new User();
		user.setUsername(username);
		user.setPassword(MD5Util.stringMD5(password));
		User result = userService.selectUser(user);
		if (!"".equals(result) && result != null) {
			return 1;
		} else {
			return 0;
		}
	}

	/*
	 * 传入用户名，返回该用户全部信息
	 */
	@RequestMapping("/selectByUserName")
	public User selectByUserName(HttpServletResponse response, String username) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		User user = new User();
		user.setUsername(username);
		return userService.selectUser(user);
	}
	
	//根据主键查询
	@RequestMapping("/selectByPrimaryKey")
	public User selectByPrimaryKey(HttpServletResponse response, Integer uid) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return userService.selectByPrimaryKey(uid);
	}

	// 获取全部用户全部信息 测
	@RequestMapping("/selectAllUser")
	public List<User> selectAllUser(HttpServletResponse response,Integer start,Integer number) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return userService.selectAllUser(start,number);
	}

	// 修改用户
	@RequestMapping("/updateUser")
	public int updateUser(HttpServletResponse response, User user) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return userService.updateByPrimaryKeySelective(user);
	}

	// 删除用户，如果用户下有订单则一起删除 测
	@RequestMapping("/deleteUser")
	public int deleteUser(HttpServletResponse response,String username) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return userService.deleteByUserName(username);
	}
	
	@RequestMapping("/selectTotalCount")
	public int selectTotalCount(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return userService.selectTotalCount();
	}

	// ---------------购物车--------------

	@RequestMapping("/addShoppingCart")
	public int addShoppingCart(HttpServletResponse response, HttpServletRequest request, ShoppingCard shoppingcard)
			throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		shoppingcard.setQuantity(1);
		return userService.addShoppingCart(shoppingcard);
	}

	@RequestMapping("/getShoppingCard")
	public List<Object> getShoppingCard(HttpServletResponse response, String name) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return userService.getShoppingCart(name);
	}

	@RequestMapping("/removeShoppingCard")
	public int removeShoppingCard(HttpServletResponse response, String key) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return userService.deleteShoppingCard(key);
	}

}
