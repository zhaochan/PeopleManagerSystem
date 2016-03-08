package com.levilee.store.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.levilee.store.interface1.CommonInterface;
import com.levilee.store.util.HibernateUtil;
public class CommonDao implements CommonInterface{
     public Class<? extends CommonDao> c;
     public Logger log = Logger.getLogger("levilog");
	@Override
	public <E> boolean add(E e) {
		Session session = HibernateUtil.getSession();
		Transaction rx = session.beginTransaction();
		try{
		session.save(e);
		}catch(Exception ex){
			log.error("保存失败");
			ex.printStackTrace();
			return false;
		}
		rx.commit();
		session.close();
		return true;
	}
	@Override
	public <E> boolean delete(E e) {
		Session session = HibernateUtil.getSession();
		Transaction rx = session.beginTransaction();
		try {
			session.delete(e);
		} catch (Exception e1) {
			log.error("删除失败");
			e1.printStackTrace();
			return false;
		}
		rx.commit();
		session.close();
		return true;
	}
	
	//使用主键进行删除
	@Override
	public boolean delete(Serializable id){
		this.c = this.getClass();
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object d = null;
		try {
			//获得实体类类名
			String classname = c.getName().replace("dao", "entity").replace("Dao", "");
			d =  session.get(Class.forName(classname), id);
			session.delete(d);
		} catch (ClassNotFoundException e) {
			log.error("删除错误");
			e.printStackTrace();
		}
		tx.commit();
		session.close();
		return true;
	}
	@Override
	public boolean delete(List list){
		this.c = this.getClass();
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		for(Object o :list){
			try {
				session.delete(o);
			} catch (Exception e) {
				log.error("集合删除错误");
				e.printStackTrace();
				return false;
			}
		}
		tx.commit();
		session.close();
		return true;
	}
	@Override
	public <E> boolean update(E e) {
		Session session = HibernateUtil.getSession();
		Transaction rx = session.beginTransaction();
		try {
			session.update(e);
		} catch (Exception e1) {
			log.error("更新失败");
			e1.printStackTrace();
		}
		rx.commit();
		session.close();
		return true;
	}
	@Override
	public boolean update(String hql){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try{
		Query query = session.createQuery(hql);
		 query.executeUpdate();
		}catch(Exception e){
			log.error("hql语句出错："+hql);
			e.printStackTrace();
			return false;
		}
		tx.commit();
		session.close();
		return true;
	}
	
	@Override
	public <E> List<E> getByCondition(String sql) {
		this.c = this.getClass();
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String name = c.getSimpleName();
		name = name.substring(0, name.length()-3);
		List<E> list=null ;
		try{
		Query query = session.createQuery("from "+name+"  "+sql);
		list =query.list();
		}catch(Exception e){
			log.error("hql语句出错："+"from "+name+"  "+sql);
		}
		tx.commit();
		session.close();
		return list;
	}
	@Override
	public Object get(Serializable id) {
		this.c = this.getClass();
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object d = null;
		try {
			//获得实体类类名
			String classname = c.getName().replace("dao", "entity").replace("Dao", "");
			d =  session.get(Class.forName(classname), id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		tx.commit();
		session.close();
		return d;
	}
	/**
	 * 完全使用Hql进行查询
	 * 适合自行进行复杂查询
	 */
	@Override
	public <E> List<E> getByHql(String hql) {
		this.c = this.getClass();
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<E> list=null ;
		try{
		Query query = session.createQuery(hql);
		list =query.list();
		}catch(Exception e){
			log.error("hql语句出错："+hql);
		}
		tx.commit();
		session.close();
		return list;
	}
	@Override
	public <E> List<E> get() {
		this.c = this.getClass();
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String name = c.getSimpleName();
		name = name.substring(0, name.length()-3);
		Query query = session.createQuery("from "+name);
		List<E> list=null;
		try {
			list = query.list();
		} catch (Exception e) {
			log.error("获取失败");
			e.printStackTrace();
		}
		tx.commit();
		session.close();
		return list;
	}
}
