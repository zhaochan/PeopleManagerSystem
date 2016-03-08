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
	 * ��ӹ��ﳵ������Cart�������������Ϣ��username,productid,amount
	 */
	@Override
	public boolean add(Cart cart) {
		// ������ﳵ������ͬusername��ͬproductid�ļ�¼������Ӽ�¼
		// 1.��ѯ���û��ļ�¼
		List<Cart> list = null;
		Cart c = null;
		list = dao.getByCondition("where username='" + cart.getUsername()
				+ "'  and  productid=" + cart.getProductid());
		if (!list.isEmpty()) {
			c = list.get(0);
			log.info("�ü�¼�Ѿ����ڣ����ڸ��ļ�¼");
			// �����ݸ���Ϊ�ܺ�
			c.setAmount(c.getAmount() + cart.getAmount());
			dao.update(c);
		} else {
			log.info("��δ���ڸü�¼�������½���¼");
			try {
				dao.add(cart);
			} catch (Exception e) {
				log.error("��¼���ʧ��");
				return false;
			}
		}
		return true;
	}

	@Override
    public boolean add(String username, int productid, int amount) {
		// ������ﳵ������ͬusername��ͬproductid�ļ�¼������Ӽ�¼
				// 1.��ѯ���û��ļ�¼
				List<Cart> list = null;
				Cart c = null;
				list = dao.getByCondition("where username='" + username
						+ "'  and  productid=" + productid);
				if (!list.isEmpty()) {
					c = list.get(0);
					log.info("�ü�¼�Ѿ����ڣ����ڸ��ļ�¼");
					// �����ݸ���Ϊ�ܺ�
					c.setAmount(c.getAmount() + amount);
					dao.update(c);
				} else {
					log.info("��δ���ڸü�¼�������½���¼");
					// 1.��ȡ�������
					int keynumber = 0;
					try {
						keynumber = HibernateUtil.getId("cartid");
					} catch (Exception e) {
						e.printStackTrace();
						log.error("������ȡʧ��");
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
						log.error("��¼���ʧ��");
						return false;
					}
				}
				return true;
	}
	/**
	 * ɾ�����ﳵ����,����Ҫ��cartid
	 */
	@Override
	public boolean delete(Cart cart) {
		// TODO Auto-generated method stub
		try {
			dao.delete(cart);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ɾ��ʧ��");
			return false;
		}
		log.info("���ﳵɾ���ɹ�");
		return true;
	}

	/**
	 * ɾ�����û������й��ﳵ��¼
	 */
	@Override
	public boolean delete(String username) {
		// ֱ��ʹ��hql���ɾ��
		try {
			dao.update("delete  Cart where username='" + username + "'");
		} catch (Exception e) {
			log.error("ɾ������" + "delete  Cart where username='" + username
					+ "'");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ʹ��cartidɾ��ָ�����ﳵ����
	 */
	@Override
	public boolean delete(int cartid) {
		Cart c = new Cart();
		c.setCartid(cartid);
		try {
			dao.delete(c);
		} catch (Exception e) {
			log.error("���ﳵɾ��ʧ��");
			e.printStackTrace();
			return false;
		}
		log.info("���ﳵɾ���ɹ�");
		return true;
	}

	/**
	 * ���¹��ﳵ����
	 */
	@Override
	public boolean update(Cart cart) {
		try {
			dao.update(cart);
		} catch (Exception e) {
			log.info("����ʧ��");
			e.printStackTrace();
			return  false;
		}
		log.info("���³ɹ�");
		return true;
	}

	@Override
	public List<Cart> get() {
		List<Cart> list = null;
		try {
			list = dao.get();
		} catch (Exception e) {
			log.error("��ȡʧ��");
			e.printStackTrace();
		}
		log.info("��ȡ���ﳵ��Ϣ�ɹ�");
		return list;
	}

	/**
	 * ��ȡָ���û��Ĺ��ﳵ��Ϣ
	 */
	@Override
	public List<Cart> get(String username) {
		List<Cart> list = null;
		String hql = "where username='"+username+"'";
		System.out.println(hql);
		try {
			list = dao.getByCondition(hql);
		} catch (Exception e) {
			log.error("���ﳵ��Ϣ��ȡʧ��");
			e.printStackTrace();
		}
		log.info("���ﳵ��Ϣ��ȡ�ɹ�");
		return list;
	}

	/**
	 * ʹ���������в�ѯ
	 */
	@Override
	public Cart get(int cartid) {
		Cart cart=null;
		try {
		cart = (Cart) dao.get(cartid);
		} catch (Exception e) {
		   log.error("��ѯʧ��");
			e.printStackTrace();
		}
		log.info("���ﳵ��ѯ�ɹ�");
		return cart;
	}

}
