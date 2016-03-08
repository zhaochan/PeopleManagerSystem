package com.levilee.store.interface1;

import java.io.Serializable;
import java.util.List;

public interface CommonInterface {
	//增加
	public <E> boolean  add(E e);
   //删除
	public <E> boolean delete(E e);
	public boolean delete(Serializable id);
	//删除整个集合中的值，主要是为了优化性能
	public boolean delete(List list);
	//更改
	public <E> boolean update(E e);
	public boolean update(String hql);
	//查询
	//查询所有
	public  <E> List<E> get();
	//按指定条件查询
	public <E> List<E> getByCondition(String sql);
	//使用主键查询
	public Object get(Serializable id);
	//完全使用hql语句查询
	public <E> List <E> getByHql(String hql);
}
