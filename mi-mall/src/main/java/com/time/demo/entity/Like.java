package com.time.demo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Like implements Serializable {

	private static final long serialVersionUID = 1L;

	// 编号
	private Integer likeid;

	// 用户名
	private String owner;

	// 商品名称
	private String product;

	// 商品版本
	private String model;

	// 商品颜色
	private String color;

	// 商品价格
	private Double price;

}