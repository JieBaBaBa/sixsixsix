package com.time.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.time.demo.entity.Order;
import com.time.demo.entity.ShoppingCard;
import com.time.demo.entity.User;
import com.time.demo.mapper.UserMapper;
import com.time.demo.util.JSONHelper;
import com.time.demo.util.RedisUtil;
import com.time.demo.util.RegularExpressionUtil;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import net.sf.json.JSONObject;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OrderServiceImpl orderService;

	@Autowired
	private RedisUtil redis;

	/*
	 * 返回值： 1：注册成功 2：账号存在 0：正则匹配失败
	 */
	public int insertSelective(User user) {
		String username = user.getUsername();
		User user2 = userMapper.selectUser(user);
		if ((RegularExpressionUtil.parse(username,
				"^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"))
				|| (RegularExpressionUtil.parse(username,
						"^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$"))) {
			if (user2 == null || "".equals(user2)) {
				return userMapper.insertSelective(user);
			} else {
				return 2;
			}
		} else {
			return 0;
		}
	}

	public User selectUser(User user) {
		return userMapper.selectUser(user);
	}

	public List<User> selectAllUser(Integer start,Integer number) {
		return userMapper.selectAllUser(start,number);
	}

	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	// 删除用户时删除用户下所有订单
	@Transactional(rollbackFor = Exception.class)
	public int deleteByUserName(String username) {
		userMapper.deleteByUserName(username);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("username", username);
		List<Order> order = orderService.selectByUserName(hashMap);
		for (Order order2 : order) {
			System.out.println(order2);
			orderService.deleteByPrimaryKey(order2.getOrderid());
		}
		return 1;
	}

	// 用户添加购物车
	@SuppressWarnings("null")
	public int addShoppingCart(ShoppingCard shoppingcard) throws Exception {
		boolean flag = false;
		Integer MAXshoppingcartid = 0;

		// 获取数据库所有数据
		List<ShoppingCard> redisShoppingCard = getShoppingCarts(shoppingcard.getName());
		System.out.println("数据库：" + redisShoppingCard);
		System.out.println("shoppingcard:" + shoppingcard);
		if (redisShoppingCard != null && !"".equals(redisShoppingCard)) {
			for (ShoppingCard product : redisShoppingCard) {
				System.out.println("product:" + product);
				if (product.getCurrentPrice().equals(shoppingcard.getCurrentPrice())
						&& product.getProductname().equals(shoppingcard.getProductname())
						&& product.getPicture1().equals(shoppingcard.getPicture1())
						&& product.getColor().equals(shoppingcard.getColor())
						&& product.getConf().equals(shoppingcard.getConf())
						&& product.getVersion().equals(shoppingcard.getVersion())) {
					product.setQuantity(product.getQuantity() + 1);
					flag = true;
				}
				if (MAXshoppingcartid < product.getShoppingcartid()) {
					MAXshoppingcartid = product.getShoppingcartid();
				}
			}
			if (flag == false) {
				shoppingcard.setShoppingcartid(MAXshoppingcartid + 1);
				redisShoppingCard.add(shoppingcard);
			}
		}
		for (

		ShoppingCard shoppingCard : redisShoppingCard) {
			redis.hPutAll(shoppingCard.getName() + shoppingCard.getProductname() + shoppingCard.getShoppingcartid(),
					Convert.convert(new TypeReference<Map<String, String>>() {
					}, RegularExpressionUtil.convertBean(shoppingCard)));
		}
		return 1;

	}

	public List<ShoppingCard> getShoppingCarts(String name) {
		List<ShoppingCard> list = new ArrayList<ShoppingCard>();
		// 利用keys 18219106065* 获取相关用户的所有对应key
		Set<String> keys = redis.keys(name);
		for (String key : keys) {
			Map<Object, Object> hGetAll = redis.hGetAll(key);
			// 根据返回的keys获取对应的所有value
			JSONObject jsonMap = JSONObject.fromObject(hGetAll);
			list.add((ShoppingCard) JSONHelper.json2Object(jsonMap.toString(), ShoppingCard.class));
		}
		return list;
	}

	// 用户获取购物车
	public List<Object> getShoppingCart(String name) {

		List<Object> list = new ArrayList<Object>();
		// 利用keys 18219106065* 获取相关用户的所有对应key
		Set<String> keys = redis.keys(name);
		for (String key : keys) {
			// 根据返回的keys获取对应的所有value
			list.add(redis.hGetAll(key));
		}
		return list;
	}

	public int deleteShoppingCard(String key) {
		redis.delete(key);
		return 1;
	}

	@Override
	public User selectByPrimaryKey(Integer uid) {
		
		return userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public int selectTotalCount() {
		return userMapper.selectTotalCount();
	}

}
