package com.time.demo.entity;

import java.io.Serializable;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Admin extends BaseRowModel implements Serializable  {
	private static final long serialVersionUID = 1L;

	@ExcelProperty(value = "订单编号", index = 0)
	private Integer adminid;

	@ExcelProperty(value = "管理员名字", index = 1)
	private String name;

	@ExcelProperty(value = "密码", index = 2)
	private String password;

	private String avatar;
}