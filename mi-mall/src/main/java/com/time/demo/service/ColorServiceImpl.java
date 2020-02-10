package com.time.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.time.demo.entity.Color;
import com.time.demo.mapper.ColorMapper;

@Service
public class ColorServiceImpl implements IColorService {

	@Autowired
	private ColorMapper colorMapper;

	@Override
	public int deleteByPrimaryKey(Integer colorid) {

		return colorMapper.deleteByPrimaryKey(colorid);
	}

	@Override
	public int insert(Color record) {

		return colorMapper.insert(record);
	}

	@Override
	public int insertSelective(Color record) {

		return colorMapper.insertSelective(record);
	}

	@Override
	public Color selectByPrimaryKey(Integer colorid) {

		return colorMapper.selectByPrimaryKey(colorid);
	}

	@Override
	public int updateByPrimaryKeySelective(Color record) {

		return colorMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Color record) {

		return colorMapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertColorList(List<Color> colorList) {
		
		return colorMapper.insertColorList(colorList);
	}

	@Override
	public int updateColorList(List<Color> confList) {
		
		return colorMapper.updateColorList(confList);
	}

	@Override
	public int deleteColorList(Integer productid) {
		
		return colorMapper.deleteColorList(productid);
	}

}
