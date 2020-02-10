package com.time.demo.service;

import java.util.List;

import com.time.demo.entity.Conf;

public interface IConfService {
	int deleteByPrimaryKey(Integer confid);

	int insert(Conf record);

	int insertSelective(Conf record);

	Conf selectByPrimaryKey(Integer confid);

	int updateByPrimaryKeySelective(Conf record);

	int updateByPrimaryKey(Conf record);
	
	int insertConfList(List<Conf> confList);
	
	int updateConfList(List<Conf> confList);

	int deleteConfList(Integer productid);
}
