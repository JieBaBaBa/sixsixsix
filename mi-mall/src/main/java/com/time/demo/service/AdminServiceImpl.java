package com.time.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.time.demo.entity.Admin;
import com.time.demo.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public int deleteByPrimaryKey(Integer adminid) {

		return adminMapper.deleteByPrimaryKey(adminid);
	}

	@Override
	public int insert(Admin record) {

		return adminMapper.insert(record);
	}

	@Override
	public int insertSelective(Admin record) {

		return adminMapper.insertSelective(record);
	}

	@Override
	public Admin selectByPrimaryKey(Integer adminid) {

		return adminMapper.selectByPrimaryKey(adminid);
	}

	@Override
	public int updateByPrimaryKeySelective(Admin record) {

		return adminMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Admin record) {

		return adminMapper.updateByPrimaryKey(record);
	}

	@Override
	public int login(Admin admin) {
		Admin result = adminMapper.selectByName(admin.getName());
		if(result != null && "".equals(result)) {
			return 0;
		}
		return 1;
	}

}
