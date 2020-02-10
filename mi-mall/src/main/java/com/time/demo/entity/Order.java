package com.time.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseRowModel implements Serializable {

	private static final long serialVersionUID = 1L;

	// 订单编号
	@ExcelProperty(value = "订单编号", index = 0)
	private Integer orderid;

	// 用户名
	@ExcelProperty(value = "用户名", index = 1)
	private String owner;

	// 昵称
	@ExcelProperty(value = "昵称", index = 2)
	private String nikename;

	// 订单状态
	@ExcelProperty(value = "订单状态", index = 3)
	private Integer orderstatus;

	// 创建时间
	@ExcelProperty(value = "创建时间", index = 4)
	private Date createtime;

	// 收货人
	@ExcelProperty(value = "收货人", index = 5)
	private String consign;

	// 收货人电话
	@ExcelProperty(value = "收货人电话", index = 6)
	private String consignphone;

	// 收货地址
	@ExcelProperty(value = "收货地址", index = 7)
	private String consignaddress;

	// 订单号
	@ExcelProperty(value = "订单号", index = 8)
	private String ordernumber;

	// 支付方式
	@ExcelProperty(value = "支付方式", index = 9)
	private String paymethod;

	// 商品列表
	private List<OrderProduct> productlist;

}