package com.time.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.time.demo.entity.Color;
import com.time.demo.entity.Conf;

@Mapper
public interface ColorMapper {
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