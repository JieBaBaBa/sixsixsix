package com.time.demo.mapper;

import java.util.List;

import com.time.demo.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import com.time.demo.entity.Product;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
	int deleteByPrimaryKey(Integer proid);

	List<ProductVO> selectAll(@Param("start") int start, @Param("number") int number);
	
	Product selectByPrimaryKey(Integer pid);

	Product selectByProductName(String productname);

	int updateProduct(Product product);
	
	int updateByPrimaryKey(Integer proid);

	int insertProduct(Product product);
	
	int selectTotalCount();
}