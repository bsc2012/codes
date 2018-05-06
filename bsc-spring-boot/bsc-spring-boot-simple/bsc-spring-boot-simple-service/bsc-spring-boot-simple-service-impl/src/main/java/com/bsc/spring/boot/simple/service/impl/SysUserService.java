package com.bsc.spring.boot.simple.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsc.spring.boot.simple.dao.inf.ISysUserDao;
import com.bsc.spring.boot.simple.model.SysUser;
import com.bsc.spring.boot.simple.service.inf.ISysUserService;

@Service
public class SysUserService implements ISysUserService{

	@Autowired
	private ISysUserDao sysUserDao;
	
	@Override
	public SysUser queryUserByUserId(String userId) {
		return sysUserDao.queryUserByUserId(userId);
	}

	@Override
	public List<SysUser> queryUserList(SysUser user) {
		return sysUserDao.queryUserList(user);
	}

}
