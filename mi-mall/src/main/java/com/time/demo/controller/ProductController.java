package com.time.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.time.demo.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.time.demo.entity.Product;
import com.time.demo.service.IProductService;
import com.time.demo.util.UploadUtil;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService iProductService;

	@Autowired
	private UploadUtil uploadUtil;

	@RequestMapping("/selectAll")
	public List<ProductVO> selectAll(HttpServletResponse response, Integer start, Integer number) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return iProductService.selectAll(start, number);
	}

	@RequestMapping("/selectByProductName")
	public Product selectByProductName(HttpServletResponse response, String productname) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return iProductService.selectByProductName(productname);
	}

	@RequestMapping("/selectByPrimaryKey")
	public Product selectByPrimaryKey(HttpServletResponse response, Integer pid) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return iProductService.selectByPrimaryKey(pid);
	}

	@RequestMapping(value = "/insertProduct")
	public int insertProduct(HttpServletResponse response, @RequestBody Product product) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println(product);
		return iProductService.insertProduct(product);
	}
	
	@RequestMapping(value = "/deleteProduct")
	public int deleteProduct(HttpServletResponse response, Integer productid) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return iProductService.deleteByPrimaryKey(productid);
	}

	@RequestMapping("/updateProduct")
	public int updateProduct(HttpServletResponse response, Product product) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return iProductService.updateProduct(product);
	}

	@RequestMapping("/upload")
	public String upload(HttpServletResponse response, @RequestParam(value = "file") MultipartFile multipartFile1) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String s = uploadUtil.upload(multipartFile1);
		System.out.println(s);
		return s;
	}
	
	@RequestMapping("/selectTotalCount")
	public int selectTotalCount(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return iProductService.selectTotalCount();
	}
}
