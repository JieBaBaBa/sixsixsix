package com.time.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.time.demo.entity.Like;
import com.time.demo.service.ILikeService;

@RestController
@RequestMapping("/like")
public class LikeController {

	private ILikeService iLikeService;

	@RequestMapping("/selectLikeProduct")
	public List<Like> selectLikeProduct(HttpServletResponse response, String username) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return iLikeService.selectByUserName(username);
	}
}
