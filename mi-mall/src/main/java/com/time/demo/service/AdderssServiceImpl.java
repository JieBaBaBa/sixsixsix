package com.time.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.time.demo.entity.Address;
import com.time.demo.mapper.AddressMapper;

@Service
public class AdderssServiceImpl implements IAddressService{

	@Autowired
	private AddressMapper AddressMapper;

	public int deleteByPrimaryKey(Integer addressid) {

		return AddressMapper.deleteByPrimaryKey(addressid);
	}

	public int insert(Address record) {

		return AddressMapper.insert(record);
	}

	public int insertSelective(Address record) {

		return AddressMapper.insertSelective(record);
	}

	public Address selectByPrimaryKey(Integer addressid) {

		return AddressMapper.selectByPrimaryKey(addressid);
	}

	public int updateByPrimaryKeySelective(Address record) {

		return AddressMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Address record) {

		return AddressMapper.updateByPrimaryKey(record);
	}

	public List<Address> selectByUserName(String username) {
		return AddressMapper.selectByUserName(username);
	}

}
