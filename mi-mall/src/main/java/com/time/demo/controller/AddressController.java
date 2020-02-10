package com.time.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.time.demo.entity.Address;
import com.time.demo.service.IAddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private IAddressService iAddressService;

	@RequestMapping("/selectAddress")
	public List<Address> selectAddress(HttpServletResponse response, String username) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return iAddressService.selectByUserName(username);
	}
}
