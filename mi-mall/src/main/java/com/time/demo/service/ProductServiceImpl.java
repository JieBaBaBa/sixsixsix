package com.time.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.time.demo.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.time.demo.entity.Color;
import com.time.demo.entity.Conf;
import com.time.demo.entity.Meal;
import com.time.demo.entity.Product;
import com.time.demo.mapper.ProductMapper;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements IProductService {

	@Resource
	private ProductMapper productMapper;

	@Autowired
	private IColorService colorService;

	@Autowired
	private IConfService confService;

	@Autowired
	private IMealService mealService;

	@Override
	public Product selectByPrimaryKey(Integer pid) {

		return productMapper.selectByPrimaryKey(pid);
	}

	@Override
	public List<ProductVO> selectAll(Integer start, Integer number) {
		List<ProductVO> products = productMapper.selectAll(start, number);
		return products;
	}

	@Override
	public Product selectByProductName(String productname) {
		return productMapper.selectByProductName(productname);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int insertProduct(Product product) {
		int flag = productMapper.insertProduct(product);
		List<Conf> confList = null;
		List<Color> colorList = null;
		List<Meal> mealList = null;
		if (flag > 0) {
			Map<String, Object> setList = setList(product);
			confList = (List<Conf>) setList.get("conf");
			colorList = (List<Color>) setList.get("color");
			mealList = (List<Meal>) setList.get("meal");

		}

		if (mealService.insertMealList(mealList) > 0 && colorService.insertColorList(colorList) > 0
				&& confService.insertConfList(confList) > 0) {
			return 1;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int updateProduct(Product product) {
		int flag = productMapper.updateProduct(product);
		List<Conf> confList = null;
		List<Color> colorList = null;
		List<Meal> mealList = null;
		if (flag > 0) {
			Map<String, Object> setList = setList(product);
			confList = (List<Conf>) setList.get("conf");
			colorList = (List<Color>) setList.get("color");
			mealList = (List<Meal>) setList.get("meal");

		}

		if (mealService.updateMealList(mealList) > 0 && colorService.updateColorList(colorList) > 0
				&& confService.updateConfList(confList) > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer proid) {
		int flag = 0;
		if (mealService.deleteMealList(proid) > 0 && colorService.deleteColorList(proid) > 0
				&& confService.deleteConfList(proid) > 0) {
			flag = productMapper.deleteByPrimaryKey(proid);
		}
		return flag;
	}

	public Map<String, Object> setList(Product product) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Conf> confList = product.getConf();
		List<Color> colorList = product.getColor();
		List<Meal> mealList = product.getMeal();

		for (Meal meal : mealList) {
			meal.setProductid(product.getProID());
		}
		result.put("meal", mealList);
		for (Conf conf : confList) {
			conf.setProductid(product.getProID());
		}
		result.put("conf", confList);
		for (Color color : colorList) {
			color.setProductid(product.getProID());
		}
		result.put("color", colorList);
		return result;
	}

	@Override
	public int selectTotalCount() {
		
		return productMapper.selectTotalCount();
	}

}
