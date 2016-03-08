package com.levilee.store.interface1;

import java.sql.Date;
import java.util.List;

import com.levilee.store.entity.Userinfo;

public interface UserinfoInter {
     //增加用户信息
	public boolean add(Userinfo userinfo);
	public boolean add(String username,String sex,String email,String phonenumber,String address);
	//删除用户信息
	public boolean delete(Userinfo userinfo);
	public boolean deleteByUsername(String username);
	//更改用户信息
	public boolean update(Userinfo userinfo);
	//查询用户信息
	public List<Userinfo>  getAll();
	public Userinfo getByUsername(String username);
}
