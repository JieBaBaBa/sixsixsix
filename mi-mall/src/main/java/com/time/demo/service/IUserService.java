package com.time.demo.service;

import java.util.List;
import com.time.demo.entity.ShoppingCard;
import com.time.demo.entity.User;

public interface IUserService {

	int deleteByUserName(String username);

	int insertSelective(User user);

	User selectUser(User user);
	
	User selectByPrimaryKey(Integer uid);
	
	public List<User> selectAllUser(Integer start,Integer number);

	int updateByPrimaryKeySelective(User user);

	int addShoppingCart(ShoppingCard shoppingcard) throws Exception;

	List<Object> getShoppingCart(String name);

	int deleteShoppingCard(String key);
	
	int selectTotalCount();

}
