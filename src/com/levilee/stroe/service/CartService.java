package com.levilee.stroe.service;

import java.util.List;
import org.jboss.logging.Logger;
import com.levilee.store.dao.CartDao;
import com.levilee.store.entity.Cart;
import com.levilee.store.interface1.CartServiceInter;
import com.levilee.store.util.HibernateUtil;
public class CartService implements CartServiceInter {
	private CartDao dao = new CartDao();
	private Logger log = Logger.getLogger("levilog");

	/**
	 * 添加购物车，参数Cart必须包含三个信息，username,productid,amount
	 */
	@Override
	public boolean add(Cart cart) {
		// 如果购物车中有相同username相同productid的记录，则不添加纪录
		// 1.查询该用户的记录
		List<Cart> list = null;
		Cart c = null;
		list = dao.getByCondition("where username='" + cart.getUsername()
				+ "'  and  productid=" + cart.getProductid());
		if (!list.isEmpty()) {
			c = list.get(0);
			log.info("该记录已经存在，正在更改纪录");
			// 将数据更改为总和
			c.setAmount(c.getAmount() + cart.getAmount());
			dao.update(c);
		} else {
			log.info("尚未存在该记录，正在新建记录");
			try {
				dao.add(cart);
			} catch (Exception e) {
				log.error("记录添加失败");
				return false;
			}
		}
		return true;
	}

	@Override
    public boolean add(String username, int productid, int amount) {
		// 如果购物车中有相同username相同productid的记录，则不添加纪录
				// 1.查询该用户的记录
				List<Cart> list = null;
				Cart c = null;
				list = dao.getByCondition("where username='" + username
						+ "'  and  productid=" + productid);
				if (!list.isEmpty()) {
					c = list.get(0);
					log.info("该记录已经存在，正在更改纪录");
					// 将数据更改为总和
					c.setAmount(c.getAmount() + amount);
					dao.update(c);
				} else {
					log.info("尚未存在该记录，正在新建记录");
					// 1.获取主键编号
					int keynumber = 0;
					try {
						keynumber = HibernateUtil.getId("cartid");
					} catch (Exception e) {
						e.printStackTrace();
						log.error("主键获取失败");
						return false;
					} 
					c = new Cart();
					c.setUsername(username);
					c.setProductid(productid);
					c.setAmount(amount);
					c.setCartid(keynumber);
					try {
						dao.add(c);
					} catch (Exception e) {
						log.error("记录添加失败");
						return false;
					}
				}
				return true;
	}
	/**
	 * 删除购物车数据,必须要有cartid
	 */
	@Override
	public boolean delete(Cart cart) {
		// TODO Auto-generated method stub
		try {
			dao.delete(cart);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除失败");
			return false;
		}
		log.info("购物车删除成功");
		return true;
	}

	/**
	 * 删除该用户的所有购物车记录
	 */
	@Override
	public boolean delete(String username) {
		// 直接使用hql语句删除
		try {
			dao.update("delete  Cart where username='" + username + "'");
		} catch (Exception e) {
			log.error("删除错误：" + "delete  Cart where username='" + username
					+ "'");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 使用cartid删除指定购物车类容
	 */
	@Override
	public boolean delete(int cartid) {
		Cart c = new Cart();
		c.setCartid(cartid);
		try {
			dao.delete(c);
		} catch (Exception e) {
			log.error("购物车删除失败");
			e.printStackTrace();
			return false;
		}
		log.info("购物车删除成功");
		return true;
	}

	/**
	 * 更新购物车内容
	 */
	@Override
	public boolean update(Cart cart) {
		try {
			dao.update(cart);
		} catch (Exception e) {
			log.info("更新失败");
			e.printStackTrace();
			return  false;
		}
		log.info("更新成功");
		return true;
	}

	@Override
	public List<Cart> get() {
		List<Cart> list = null;
		try {
			list = dao.get();
		} catch (Exception e) {
			log.error("获取失败");
			e.printStackTrace();
		}
		log.info("获取购物车信息成功");
		return list;
	}

	/**
	 * 获取指定用户的购物车信息
	 */
	@Override
	public List<Cart> get(String username) {
		List<Cart> list = null;
		String hql = "where username='"+username+"'";
		System.out.println(hql);
		try {
			list = dao.getByCondition(hql);
		} catch (Exception e) {
			log.error("购物车信息获取失败");
			e.printStackTrace();
		}
		log.info("购物车信息获取成功");
		return list;
	}

	/**
	 * 使用主键进行查询
	 */
	@Override
	public Cart get(int cartid) {
		Cart cart=null;
		try {
		cart = (Cart) dao.get(cartid);
		} catch (Exception e) {
		   log.error("查询失败");
			e.printStackTrace();
		}
		log.info("购物车查询成功");
		return cart;
	}

}
