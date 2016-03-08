package com.levilee.store.util;

import javax.xml.crypto.dsig.keyinfo.KeyName;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.levilee.store.entity.Keynumber;

public class HibernateUtil {
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	/*
	 * ServiceRegistry��Hibernate4.X�����ӿڣ�
	 * Ӧ����Hibernate�����û��߷���Ƚ�ͳһ�����ServiceRegistryע��������Ч��
	 * ������Ҫ����һ��ServiceRegistry����
	 * ����������Ϣ����ע�ᣬȻ��Configuration������ݴ����ServiceRegistry�����л�ȡ������Ϣ����SessionFactory
	 * �� Hibernate4��������ڲ�����Configuration���󣬶���ServiceRegistry����
	 * Configuration����ͨ��ServiceRegistry�����ȡ������Ϣ�� hibernate4
	 * Դ��λ�ã�org.hibernate.service.ServiceRegistryBuilder ����ɲο�hibernateԴ�롣�Լ�API
	 */
	private static ServiceRegistry serviceRegistry = null;
	static {
		try {
			// ���Ȼ�ȡ������Ϣ
			configuration = new Configuration().configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			// ����Session Factory
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// System.out.println("SessionFactory����ʧ��");
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		Session session = null;
		if (null == session || false == session.isOpen()) {
			session = sessionFactory.openSession();
		}

		return session;
	}

	public static void closeSession(Session session) {
		try {
			if (null != session && session.isOpen())
				session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	public static int getId(String keyname){
		int t;
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Keynumber keynumber = (Keynumber) session.get(Keynumber.class, keyname);
		t = keynumber.getKeynumber();
		keynumber.setKeynumber(t+1);
		tx.commit();
		session.close();
		return t;
	}
}
