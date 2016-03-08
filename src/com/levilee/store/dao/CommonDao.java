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
			log.error("����ʧ��");
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
			log.error("ɾ��ʧ��");
			e1.printStackTrace();
			return false;
		}
		rx.commit();
		session.close();
		return true;
	}
	
	//ʹ����������ɾ��
	@Override
	public boolean delete(Serializable id){
		this.c = this.getClass();
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object d = null;
		try {
			//���ʵ��������
			String classname = c.getName().replace("dao", "entity").replace("Dao", "");
			d =  session.get(Class.forName(classname), id);
			session.delete(d);
		} catch (ClassNotFoundException e) {
			log.error("ɾ������");
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
				log.error("����ɾ������");
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
			log.error("����ʧ��");
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
			log.error("hql������"+hql);
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
			log.error("hql������"+"from "+name+"  "+sql);
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
			//���ʵ��������
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
	 * ��ȫʹ��Hql���в�ѯ
	 * �ʺ����н��и��Ӳ�ѯ
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
			log.error("hql������"+hql);
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
			log.error("��ȡʧ��");
			e.printStackTrace();
		}
		tx.commit();
		session.close();
		return list;
	}
}
