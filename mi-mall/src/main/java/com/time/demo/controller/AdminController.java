package com.time.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.time.demo.entity.Admin;
import com.time.demo.service.IAdminService;
import com.time.demo.util.UploadUtil;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService iAdminService;

	@Autowired
	private UploadUtil uploadUtil;

	// 注册
	@RequestMapping("/regist")
	public int regist(HttpServletResponse response, Admin admin) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return iAdminService.insertSelective(admin);
	}

	// 登陆
	@RequestMapping("/login")
	public int login(HttpServletResponse response, Admin admin) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return iAdminService.login(admin);
	}

	// 修改
	@RequestMapping("/update")
	public int update(HttpServletResponse response, @RequestPart("admin") Admin admin,
			@RequestParam("avatar") MultipartFile multipartFile) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		if (multipartFile != null && "".equals(multipartFile)) {
			admin.setAvatar(uploadUtil.upload(multipartFile));
		}
		return iAdminService.updateByPrimaryKeySelective(admin);
	}
}
