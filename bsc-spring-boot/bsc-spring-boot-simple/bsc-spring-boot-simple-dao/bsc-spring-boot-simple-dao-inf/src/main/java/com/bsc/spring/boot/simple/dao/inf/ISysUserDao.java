package com.bsc.spring.boot.simple.dao.inf;

import java.util.List;

import com.bsc.spring.boot.simple.model.SysUser;

public interface ISysUserDao {

	SysUser queryUserByUserId(String userId);
	
	List<SysUser> queryUserList(SysUser user);
}
