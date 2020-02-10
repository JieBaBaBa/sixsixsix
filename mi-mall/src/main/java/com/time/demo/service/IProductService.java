package com.time.demo.service;

import java.util.List;

import com.time.demo.entity.Product;
import com.time.demo.vo.ProductVO;

public interface IProductService {

	int deleteByPrimaryKey(Integer proid);

	int insertProduct(Product product);
	
	int updateProduct(Product product);

	List<ProductVO> selectAll(Integer start, Integer number);
	
	Product selectByPrimaryKey(Integer pid);

	Product selectByProductName(String productname);
	
	int selectTotalCount();
	

}
