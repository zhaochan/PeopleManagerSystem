package com.levilee.store.interface1;

import com.levilee.store.entity.Categories;

public interface CategoriesServiceInter {
	//根据指定id获取Category
	public Categories get(int id);
	//添加category（注意：如果categoryname在数据库中已存在的话会不执行添加）
	public boolean add(String categoryname);
	//删除category
	public boolean delete(int id);
	public boolean delete(Categories categories);

}
