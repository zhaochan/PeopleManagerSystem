package com.levilee.store.interface1;

import java.util.List;

import com.levilee.store.entity.Collection;

public interface CollectionInter {
	//增加收藏记录，如果数据库中已经有了就会添加失败,所以这个方法并没有什么卵用
	public boolean add(Collection collection);
	//如果数据库中有相同username相同产品productid的数据，则数据不会添加，返回false
	public boolean add(String username,int productid);
    //删除某个收藏记录（一般是先获取再删除）
	public boolean delete(Collection collection);
	//删除某用户的所有收藏记录
	public boolean deleteByUsername(String username);
	//删除指定的收藏记录
	public boolean deleteByUsernameAddProductid(String username,int productid);
	//获取所有用户所有收藏记录
	public List<Collection> getAll();
	//获取指定用户的所有收藏记录
	public List<Collection> getByUsername(String username);
	

}
