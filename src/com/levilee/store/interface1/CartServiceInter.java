package com.levilee.store.interface1;

import java.util.List;

import com.levilee.store.entity.Cart;

public interface CartServiceInter {
	 //1.添加内容(可以先new一个Cart对象，然后使用set方法设值，最后调用该方法添加)
	 public boolean add(Cart cart);
     //直接使用输入用户名，产品id,数量添加，后台会自动
	 public boolean add(String username,int productid,int amount);
	 //2.删除内容
	 public boolean delete(Cart cart);
	 //2.1删除指定用户的所有购物车内容
	 public boolean delete(String username);
	 //2.2使用id删除指定购物车内容
	 public boolean delete(int cartid);
	 //3.更改内容
	 public boolean update(Cart cart);
	 //4.查询内容
	 //4.1查询所有购物车内容
	 public List<Cart>  get();
	 //4.2查询指定客户的购物车内容,返回的是一个List
	 public List<Cart> get(String username);
	 //4.3查询指定id的购物车内容
	 public Cart get(int cartid);
}
