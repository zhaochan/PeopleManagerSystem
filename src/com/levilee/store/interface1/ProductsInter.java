package com.levilee.store.interface1;

import java.util.List;

import com.levilee.store.entity.Products;

public interface ProductsInter {
	//增加产品，需确定productid不存在于数据库中,否则会添加失败
	public boolean add(Products product);
	public boolean add(String username,String description,double price,String category,String photo1,String photo2);
	//删除产品
	public boolean delete(Products product);
	public boolean delete(int productid);
	//更新产品
	public boolean update(Products product);
	//查询产品
	//查询所有产品
	public List<Products> getAll();
	//查询指定用户名的产品
	public List<Products> getByUsername(String username);
	//查询指定类目名称的产品
	public List<Products> getByCategory(String categoryname);
	
	public List<Products> getByProductid(int productid);
	
}
