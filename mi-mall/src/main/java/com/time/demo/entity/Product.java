package com.time.demo.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer proID;

	private String protype;// 商品类型

	private String name;// 商品名称

	private String picture1;// 图片1

	private String picture2;// 图片2

	private String picture3;// 图片3

	private String rednote;// 红色note

	private String graynote;// 灰色note

	private Double currentPrice;// 现价\

	private Double totalPrice;// 小计

	private Double originalPrice;// 原价

	private int quantity;// 数量

	private List<Conf> conf;// 配置

	private List<Color> color;// 颜色

	private List<Meal> meal;// 套餐S

}