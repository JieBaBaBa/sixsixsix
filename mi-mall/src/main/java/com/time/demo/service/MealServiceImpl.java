package com.time.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.time.demo.entity.Meal;
import com.time.demo.mapper.MealMapper;

@Service
public class MealServiceImpl implements IMealService {
	
	@Autowired
	private MealMapper mealMapper;

	@Override
	public int deleteByPrimaryKey(Integer mealid) {

		return mealMapper.deleteByPrimaryKey(mealid);
	}

	@Override
	public int insert(Meal record) {

		return mealMapper.insert(record);
	}

	@Override
	public int insertSelective(Meal record) {

		return mealMapper.insertSelective(record);
	}

	@Override
	public Meal selectByPrimaryKey(Integer mealid) {

		return mealMapper.selectByPrimaryKey(mealid);
	}

	@Override
	public int updateByPrimaryKeySelective(Meal record) {

		return mealMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Meal record) {

		return mealMapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertMealList(List<Meal> mealList) {
		
		return mealMapper.insertMealList(mealList);
	}

	@Override
	public int updateMealList(List<Meal> confList) {
		
		return mealMapper.updateMealList(confList);
	}

	@Override
	public int deleteMealList(Integer productid) {
		
		return mealMapper.deleteMealList(productid);
	}

}
