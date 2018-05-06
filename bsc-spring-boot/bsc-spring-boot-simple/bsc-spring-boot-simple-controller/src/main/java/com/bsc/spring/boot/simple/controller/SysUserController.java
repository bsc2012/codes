package com.bsc.spring.boot.simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsc.spring.boot.simple.model.SysUser;
import com.bsc.spring.boot.simple.service.inf.ISysUserService;

@RestController
public class SysUserController {

	@Autowired
	private ISysUserService sysUserService;
	
	@RequestMapping("/getUser/{userId}")
	public SysUser getUserByUserId(@PathVariable("userId") String userId) {
		return sysUserService.queryUserByUserId(userId);
	}
	
	@RequestMapping("/getUsers")
	public List<SysUser> getUserByUserId(SysUser user) {
		return sysUserService.queryUserList(user);
	}
}
