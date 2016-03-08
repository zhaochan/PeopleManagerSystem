package com.levilee.store.interface1;

import java.util.List;

import com.levilee.store.entity.Orders;

public interface OrdersInter {
	//使用对象添加纪录，不推荐使用 
	public boolean add(Orders order);
	//使用username 和productid 添加纪录，主键会自动根据一定的算法生成，推荐使用
	public boolean add(String username,int productid);
	//删除记录
	public boolean delete(Orders order);
	//删除某用户所有的订单
	public boolean deleteByUsername(String username);
	//删除某用户购买某件物品的订单，不止会删除一个，不推荐使用
	public boolean deleteByUsernameAddProductid(String username,int productid);
	//更改记录
	//注：考虑到一般情况下不会有订单的更新情况，所以只提供了修改订单状态接口
	public boolean updateStatus(Orders order,int status);
	public boolean updateStatus(String username,int productid,int status);
	//查询记录
	//获取所有订单记录
	public List<Orders> getAll();
	//获取某用户的订单记录
	public List<Orders> getByUsername(String username);
	//获得某个订单信息
	public Orders getByOrderid(int orderid);
	//使用username和productid 获得订单信息，不推荐使用
	public Orders getByUsernameAndProductid(String username,int productid);
}
