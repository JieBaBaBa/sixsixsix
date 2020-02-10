package com.time.demo.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//所属订单的商品类
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	// id
	@JsonProperty(value = "OrderProductid")
	private int OrderProductid;

	// 所属的订单id
	@JsonProperty(value = "Orderid")
	private int Orderid;

	// 商品图片
	@JsonProperty(value = "ProductPicture")
	private String ProductPicture;

	// 商品名称
	@JsonProperty(value = "ProductName")
	private String ProductName;

	// 商品颜色
	@JsonProperty(value = "ProductColor")
	private String ProductColor;

	// 商品金额
	@JsonProperty(value = "ProductMount")
	private Double ProductMount;

	// 商品数量
	@JsonProperty(value = "ProductNumber")
	private Long ProductNumber;
}
