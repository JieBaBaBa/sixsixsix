package com.time.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.time.demo.entity.Admin;

@Mapper
public interface AdminMapper {
	int deleteByPrimaryKey(Integer adminid);

	int insert(Admin record);

	int insertSelective(Admin record);

	Admin selectByPrimaryKey(Integer adminid);

	Admin selectByName(String name);

	int updateByPrimaryKeySelective(Admin record);

	int updateByPrimaryKey(Admin record);
}