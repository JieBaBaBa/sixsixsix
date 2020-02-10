package com.time.demo.entity;

import lombok.Data;

@Data
public class ShoppingCard {
	public Integer shoppingcartid; // 购物车id
	public Integer quantity; // 数量
	public String color; // 颜色
	public String name; // 用户名
	public String picture1; // 图片
	public String productname; // 商品名称
	public Double currentPrice; // 商品价格
	public String conf; // 商品套餐
	public String version; // 商品版本

}
