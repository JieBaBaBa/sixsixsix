package com.time.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.time.demo.entity.Conf;

@Mapper
public interface ConfMapper {
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