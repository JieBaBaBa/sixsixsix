package com.time.demo.service;

import java.util.List;

import com.time.demo.entity.Address;

public interface IAddressService{

	int deleteByPrimaryKey(Integer addressid);

	int insert(Address record);

	int insertSelective(Address record);

	Address selectByPrimaryKey(Integer addressid);

	int updateByPrimaryKeySelective(Address record);

	int updateByPrimaryKey(Address record);

	// 根据用户名查找该用户所有地址
	List<Address> selectByUserName(String username);
}
