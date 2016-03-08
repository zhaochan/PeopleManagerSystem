package com.levilee.stroe.service;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.levilee.store.dao.OrdersDao;
import com.levilee.store.entity.Orders;
import com.levilee.store.interface1.OrdersInter;
import com.levilee.store.util.HibernateUtil;

public class OrdersService implements OrdersInter {
	private OrdersDao dao = new OrdersDao();
	private Logger log = Logger.getLogger("levilog");
	@Override
	public boolean add(Orders order) {
		try {
			dao.add(order);
		} catch (Exception e) {
			log.error("添加订单失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean add(String username, int productid) {
		/* 相同的用户相同的产品可以多次下订单 */
		Orders o = new Orders();
		o.setUsername(username);
		o.setProductid(productid);
		o.setOrderid(HibernateUtil.getId("orderid"));
		o.setStatus(0);
		o.setOrderdate(new Date(System.currentTimeMillis()));
		try {
			dao.add(o);
		} catch (Exception e) {
			log.error("添加失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Orders order) {
		try {
			dao.delete(order);
		} catch (Exception e) {
			log.error("删除失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteByUsername(String username) {
		List<Orders> list = dao.getByCondition("where username='" + username + "'");
		try {
			dao.delete(list);
		} catch (Exception e) {
			log.error("删除失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteByUsernameAddProductid(String username, int productid) {
		List<Orders> list = dao.getByCondition("where username='" + username
				+ "' and productid='" + productid + "'");
		try {
			dao.delete(list);
		} catch (Exception e) {
			log.error("删除失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
	@Override
	public boolean updateStatus(Orders order, int status) {
		order.setStatus(status);
		try {
			dao.update(status);
		} catch (Exception e) {
			log.error("更新数据失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 不推荐使用
	 */
	@Override
	public boolean updateStatus(String username, int productid, int status) {
		List<Orders> list = dao.getByCondition("where username='" + username
				+ "'  and  productid=" + productid);
		if (list.isEmpty()) {
			log.error("查询失败，没有找到用户名为：" + username + ",productid 为" + productid
					+ "的订单");
			return false;
		}
		Orders o = list.get(0);
		o.setStatus(status);
		dao.update(o);
		return true;
	}

	@Override
	public List<Orders> getAll() {
		List<Orders> list = dao.get();
		return list;
	}

	@Override
	public List<Orders> getByUsername(String username) {
		List<Orders> list = null;
		try {
			list = dao.getByCondition("where username='" + username + "'");
		} catch (Exception e) {
			log.error("查询失败");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Orders getByOrderid(int orderid) {
		Orders o = null;
		try {
			o = (Orders) dao.get(orderid);
		} catch (Exception e) {
			log.error("查询失败");
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public Orders getByUsernameAndProductid(String username, int productid) {
		List<Orders> list = null;
		try {
			list = dao.getByCondition("where username='" + username + "' and productid='"
					+ productid + "'");
		} catch (Exception e) {
			log.error("查询失败");
			e.printStackTrace();
			return null;
		}
		return list.get(0);
	}

}
