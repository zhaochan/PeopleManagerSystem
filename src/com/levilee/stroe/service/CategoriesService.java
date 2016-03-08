package com.levilee.stroe.service;

import java.util.List;

import org.apache.log4j.Logger;



import com.levilee.store.dao.CategoriesDao;
import com.levilee.store.entity.Categories;
import com.levilee.store.interface1.CategoriesServiceInter;
import com.levilee.store.util.HibernateUtil;
/** @author levi */
public class CategoriesService implements CategoriesServiceInter {
    private CategoriesDao dao = new CategoriesDao();
    private Logger log = Logger.getLogger("levilog");
	@Override
	public Categories get(int id) {
		try{
		Categories c = (Categories) dao.get(id);
		return c;
		}catch(NullPointerException e){
			log.error("��ǰid�����ڣ���ѯ����");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��category��������
	 */
	@Override
	public boolean add(String categoryname) {
		//�ж����ݿ����Ƿ�����ͬcategoryname����
		List<Categories> list = dao.getByCondition("where categoryname='"+categoryname+"'");
		if(!list.isEmpty()){
			log.error("�Ѵ�����ͬ������");
			return false;
		}
		Categories c = new Categories();
		try {
			c.setCategoryid(HibernateUtil.getId("categoryid"));
			c.setCategoryname(categoryname);
			dao.add(c);
		} catch (Exception e) {
			log.error("������ʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		try {
			dao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Categories c) {
		try {
			dao.delete(c);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
