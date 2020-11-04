package com.example.demo1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo1.dao.Demo1Dao;
import com.example.demo1.vo.Demo1VO;

import lombok.Builder;

@Service
public class Demo1ServiceImpl implements Demo1Service {
	
	private Demo1Dao deptDao;
	
	@Builder
	public Demo1ServiceImpl(Demo1Dao deptDao) {
		super();
		this.deptDao = deptDao;
	}
	
	@Override
	public List<Demo1VO> list() {
		return deptDao.list();
	}

}
