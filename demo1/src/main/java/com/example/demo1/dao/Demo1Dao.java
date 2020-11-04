package com.example.demo1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo1.vo.Demo1VO;

@Mapper
public interface Demo1Dao {
	public List<Demo1VO> list();
}
