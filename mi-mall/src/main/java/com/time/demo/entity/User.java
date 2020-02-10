package com.time.demo.entity;

import java.io.Serializable;

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
public class User extends BaseRowModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//用户编号
	private Integer userid;

	//用户昵称
	private String nickname;

	//用户名
	private String username;

	//密码
	private String password;

	//用户性别
	private String sex;
	

}