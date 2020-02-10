package com.time.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.time.demo.entity.Like;
import com.time.demo.mapper.LikeMapper;

@Service
public class LikeServiceImpl implements ILikeService{

	private LikeMapper likeMapper;

	public int deleteByPrimaryKey(Integer likeid) {

		return likeMapper.deleteByPrimaryKey(likeid);
	}

	public int insert(Like record) {

		return likeMapper.insert(record);
	}

	public int insertSelective(Like record) {

		return likeMapper.insertSelective(record);
	}

	public Like selectByPrimaryKey(Integer likeid) {

		return likeMapper.selectByPrimaryKey(likeid);
	}

	public int updateByPrimaryKeySelective(Like record) {

		return likeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Like record) {

		return likeMapper.updateByPrimaryKey(record);
	}

	public List<Like> selectByUserName(String username) {

		return likeMapper.selectByUserName(username);
	}

}
