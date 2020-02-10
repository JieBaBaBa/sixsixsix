package com.time.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.time.demo.entity.Conf;
import com.time.demo.entity.Meal;

@Mapper
public interface MealMapper {
    int deleteByPrimaryKey(Integer mealid);

    int insert(Meal record);

    int insertSelective(Meal record);

    Meal selectByPrimaryKey(Integer mealid);

    int updateByPrimaryKeySelective(Meal record);

    int updateByPrimaryKey(Meal record);
    
    int insertMealList(List<Meal> mealList);
    
    int updateMealList(List<Meal> confList);

	int deleteMealList(Integer productid);
}