package com.time.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.time.demo.entity.User;

@Mapper
public interface UserMapper {
    int deleteByUserName(String username);

	int insertSelective(User record);

	User selectUser(User user);
	
	User selectByPrimaryKey(Integer uid);
	
	List<User> selectAllUser(Integer start,Integer number);

	int updateByPrimaryKeySelective(User record);
	
	int selectTotalCount();
}