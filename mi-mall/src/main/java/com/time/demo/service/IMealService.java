package com.time.demo.service;

import java.util.List;

import com.time.demo.entity.Meal;

public interface IMealService {
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
