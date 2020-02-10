package com.time.demo.service;

import java.util.List;

import com.time.demo.entity.Like;

public interface ILikeService{
	
	int deleteByPrimaryKey(Integer likeid);

	int insert(Like record);

	int insertSelective(Like record);

	Like selectByPrimaryKey(Integer likeid);

	int updateByPrimaryKeySelective(Like record);

	int updateByPrimaryKey(Like record);

	// 查找该用户下所有喜欢的商品
	List<Like> selectByUserName(String username);
}
