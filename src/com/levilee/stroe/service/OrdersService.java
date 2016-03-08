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
			log.error("��Ӷ���ʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean add(String username, int productid) {
		/* ��ͬ���û���ͬ�Ĳ�Ʒ���Զ���¶��� */
		Orders o = new Orders();
		o.setUsername(username);
		o.setProductid(productid);
		o.setOrderid(HibernateUtil.getId("orderid"));
		o.setStatus(0);
		o.setOrderdate(new Date(System.currentTimeMillis()));
		try {
			dao.add(o);
		} catch (Exception e) {
			log.error("���ʧ��");
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
			log.error("ɾ��ʧ��");
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
			log.error("ɾ��ʧ��");
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
			log.error("ɾ��ʧ��");
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
			log.error("��������ʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ���Ƽ�ʹ��
	 */
	@Override
	public boolean updateStatus(String username, int productid, int status) {
		List<Orders> list = dao.getByCondition("where username='" + username
				+ "'  and  productid=" + productid);
		if (list.isEmpty()) {
			log.error("��ѯʧ�ܣ�û���ҵ��û���Ϊ��" + username + ",productid Ϊ" + productid
					+ "�Ķ���");
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
			log.error("��ѯʧ��");
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
			log.error("��ѯʧ��");
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
			log.error("��ѯʧ��");
			e.printStackTrace();
			return null;
		}
		return list.get(0);
	}

}
