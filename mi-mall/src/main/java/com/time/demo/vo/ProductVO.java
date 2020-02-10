package com.time.demo.vo;

import com.time.demo.entity.Color;
import com.time.demo.entity.Conf;
import com.time.demo.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductVO implements Serializable {

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

	private String conf;// 配置

	private String color;// 颜色

	private String meal;// 套餐S

}