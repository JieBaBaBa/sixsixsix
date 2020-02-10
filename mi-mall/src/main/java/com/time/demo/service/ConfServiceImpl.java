package com.time.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.time.demo.entity.Conf;
import com.time.demo.mapper.ConfMapper;

@Service
public class ConfServiceImpl implements IConfService {
	
	@Autowired
	private ConfMapper confMapper;

	@Override
	public int deleteByPrimaryKey(Integer confid) {

		return confMapper.deleteByPrimaryKey(confid);
	}

	@Override
	public int insert(Conf record) {

		return confMapper.insert(record);
	}

	@Override
	public int insertSelective(Conf record) {

		return confMapper.insertSelective(record);
	}

	@Override
	public Conf selectByPrimaryKey(Integer confid) {

		return confMapper.selectByPrimaryKey(confid);
	}

	@Override
	public int updateByPrimaryKeySelective(Conf record) {

		return confMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Conf record) {

		return confMapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertConfList(List<Conf> confList) {
		
		return confMapper.insertConfList(confList);
	}

	@Override
	public int updateConfList(List<Conf> confList) {
		
		return confMapper.updateConfList(confList);
	}

	@Override
	public int deleteConfList(Integer productid) {
		
		return confMapper.deleteConfList(productid);
	}

}
