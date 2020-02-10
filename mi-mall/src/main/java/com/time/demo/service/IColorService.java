package com.time.demo.service;

import java.util.List;

import com.time.demo.entity.Color;

public interface IColorService {
	int deleteByPrimaryKey(Integer colorid);

	int insert(Color record);

	int insertSelective(Color record);

	Color selectByPrimaryKey(Integer colorid);

	int updateByPrimaryKeySelective(Color record);

	int updateByPrimaryKey(Color record);
	
	int insertColorList(List<Color> colorList);
	
	int updateColorList(List<Color> confList);

	int deleteColorList(Integer productid);
}
