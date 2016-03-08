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
			log.error("当前id不存在，查询错误");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 向category中添加类别
	 */
	@Override
	public boolean add(String categoryname) {
		//判断数据库中是否用相同categoryname的项
		List<Categories> list = dao.getByCondition("where categoryname='"+categoryname+"'");
		if(!list.isEmpty()){
			log.error("已存在相同分类名");
			return false;
		}
		Categories c = new Categories();
		try {
			c.setCategoryid(HibernateUtil.getId("categoryid"));
			c.setCategoryname(categoryname);
			dao.add(c);
		} catch (Exception e) {
			log.error("类别添加失败");
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
