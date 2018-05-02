package com.bsc.spring.boot.simple.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsc.spring.boot.simple.jpa.model.SysUser;
import com.bsc.spring.boot.simple.jpa.repository.ISysUserRepository;

@RestController
@RequestMapping("sysUser")
public class SysUserController {

	@Autowired
	private ISysUserRepository sysUserRepository;
	
	@GetMapping("query")
	public SysUser querySysUser(SysUser sysUser) {
		return sysUserRepository.findOne(sysUser.getId());
	}
	
	@GetMapping("queryByUserName")
	public List<SysUser> queryByUserName(SysUser sysUser) {
		return sysUserRepository.findByUserName(sysUser.getUserName());
	}
}
