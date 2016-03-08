package com.levilee.stroe.service;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.levilee.store.dao.ProductsDao;
import com.levilee.store.entity.Products;
import com.levilee.store.interface1.ProductsInter;
import com.levilee.store.util.HibernateUtil;

public class ProductsService implements ProductsInter{
    private ProductsDao dao = new ProductsDao();
    private Logger log = Logger.getLogger("levilog");
	@Override
	public boolean add(Products product) {
		try{
		dao.add(product);
		}catch(Exception ex){
			log.error("���ʧ��");
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean add(String username, String description, double price, String category, String photo1, String photo2) {
		Products p = new Products();
		p.setCategory(category);
		p.setDescription(description);
		p.setPhoto1(photo1);
		p.setPhoto2(photo2);
		p.setPrice(price);
		p.setProductid(HibernateUtil.getId("productid"));
		p.setReleasedate(new Date(System.currentTimeMillis()));
		p.setStatus(1);
		p.setUsername(username);
		try {
			dao.add(p);
		} catch (Exception e) {
			log.error("���ʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Products product) {
		try {
			dao.delete(product);
		} catch (Exception e) {
			log.error("ɾ��ʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int productid) {
		try {
			dao.delete(productid);
		} catch (Exception e) {
			log.error("ɾ��ʧ��,����ԭ�������ݿ���û��productid="+productid+"������");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Products product) {
		try {
			dao.update(product);
		} catch (Exception e) {
			log.error("����ʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Products> getAll() {
		List<Products> list=null;
		try {
			list = dao.get();
		} catch (Exception e) {
			log.error("��ȡ��Ʒʧ��");
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public List<Products> getByUsername(String username) {
		List<Products> list = null;
		try {
			list = dao.getByCondition("where username='"+username+"'");
		} catch (Exception e) {
			log.error("��ȡ��Ʒʧ��");
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public List<Products> getByCategory(String category) {
		List<Products> list = null;
		try {
			list = dao.getByCondition("where category='"+category+"'order by releasedate");
		} catch (Exception e) {
			log.error("��ȡ��Ʒʧ��");
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public List<Products> getByProductid(int productid) {
		List<Products> list = null;
		try {
			list =  dao.getByCondition("where productid="+productid+"");
		} catch (Exception e) {
			log.error("��ȡ��Ʒʧ��");
			e.printStackTrace();
			return null;
		}
		return list;
	}

@Test
public void test(){
	List<Products> p =  getByProductid(4);
	System.out.println(p.get(0).toString());
	
}

}
