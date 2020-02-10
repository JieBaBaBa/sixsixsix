package com.time.demo.entity;

import java.io.Serializable;

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
public class Address extends BaseRowModel implements Serializable {

	private static final long serialVersionUID = 1L;

	// 商品编号
	@ExcelProperty(value = "id", index = 0)
	private Integer addressid;

	// 所属人
	@ExcelProperty(value = "所属人", index = 1)
	private String owner;

	// 收件人
	@ExcelProperty(value = "收件人", index = 2)
	private String consignee;

	// 电话
	@ExcelProperty(value = "电话", index = 3)
	private String phone;

	// 收货地址
	@ExcelProperty(value = "收货地址", index = 4)
	private String address;

	// 邮政编码
	@ExcelProperty(value = "邮政编码", index = 5)
	private Integer postalcode;

	// 备注
	@ExcelProperty(value = "备注", index = 6)
	private String note;
	

}