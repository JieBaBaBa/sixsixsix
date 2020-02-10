package com.time.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.time.demo.entity.Address;

@Mapper
public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressid);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressid);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    
    //根据用户名查找该用户所有地址
    List<Address> selectByUserName(String username);
    
}