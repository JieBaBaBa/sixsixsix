package com.time.demo.service;

import com.time.demo.entity.Admin;

public interface IAdminService {
	int deleteByPrimaryKey(Integer adminid);

	int insert(Admin record);

	int insertSelective(Admin record);

	Admin selectByPrimaryKey(Integer adminid);

	int updateByPrimaryKeySelective(Admin record);

	int updateByPrimaryKey(Admin record);
	
	int login(Admin admin);
}
