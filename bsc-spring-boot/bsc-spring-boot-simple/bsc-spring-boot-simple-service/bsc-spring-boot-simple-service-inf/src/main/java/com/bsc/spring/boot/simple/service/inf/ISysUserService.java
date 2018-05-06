package com.bsc.spring.boot.simple.service.inf;

import java.util.List;

import com.bsc.spring.boot.simple.model.SysUser;

public interface ISysUserService {

	SysUser queryUserByUserId(String userId);
	
	List<SysUser> queryUserList(SysUser user);
}
