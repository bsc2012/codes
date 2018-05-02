package com.bsc.spring.boot.simple.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsc.spring.boot.simple.jpa.model.SysUser;

public interface ISysUserRepository extends JpaRepository<SysUser, Long>{

	List<SysUser> findByUserName(String userName);
}
