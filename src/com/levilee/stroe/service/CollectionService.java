package com.levilee.stroe.service;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.levilee.store.dao.CollectionDao;
import com.levilee.store.entity.Collection;
import com.levilee.store.interface1.CollectionInter;
import com.levilee.store.util.HibernateUtil;

public class CollectionService implements CollectionInter {
    private CollectionDao dao = new CollectionDao();
    private Logger log = Logger.getLogger("levilog");
	@Override
	public boolean add(Collection collection) {
		//1.�жϸ�collection�Ƿ���������ݿ�
		Collection c = (Collection) dao.get(collection.getCollectionid());
		if(c!=null){
			log.warn("�ù��ﳵ��¼�Ѵ��ڣ����ʧ��");
			return false;
		}
		dao.add(collection);
		return true;
	}

	@Override
	public boolean add(String username, int productid) {
		List<Collection> list = dao.getByCondition(" where username='"+username+"'  and productid='"+productid+"'");
		if(!list.isEmpty()){
			//�����ѯ�����Ϊ�գ�˵�����ݿ��Ѵ��ڸ����ݣ��������
			log.warn("�ù��ﳵ��¼�Ѵ��ڣ����ʧ��");
			return false;
		}
		//�½�collection����
		Collection c = new Collection();
		//Ϊ����ֵ
		c.setCollectionid(HibernateUtil.getId("collectionid"));
		c.setUsername(username);
		c.setProductid(productid);
		c.setDate(new Date(System.currentTimeMillis()));
		dao.add(c);
		log.info("Collection ��¼��ӳɹ�");
		return true;
	}

	@Override
	public boolean delete(Collection collection) {
		dao.delete(collection);
		log.info("Collection ��¼ɾ���ɹ�");
		return true;
	}

	@Override
	public boolean deleteByUsername(String username) {
		try{
			List<Collection> list = dao.getByCondition(" where username='"+username+"'");
			for(Collection e : list){
				dao.delete(e);
			}
		}catch(Exception e){
			log.error("hqlִ��ʧ��");
			return false;
		}
		log.info("Collection ��¼ɾ���ɹ�");
		return true;
	}

	@Override
	public boolean deleteByUsernameAddProductid(String username, int productid) {
		try{
			System.out.println("ִ��ɾ��"+username+productid);
			List<Collection> list = dao.getByCondition("collection where username='"+username+"'  and productid='"+productid+"'");
			System.out.println(list);
			for(Collection e : list){
				dao.delete(e);
			}
		}catch(Exception e){
			log.error("hqlִ��ʧ��");
			return false;
		}
		log.info("Collection ��¼ɾ���ɹ�");
		return true;
	}

	@Override
	public List<Collection> getAll() {
		List<Collection> list = dao.get();
		log.info("Collection ��¼��ȡ�ɹ�");
		return list;
	}

	@Override
	public List<Collection> getByUsername(String username) {
		List<Collection> list = dao.getByCondition(" where username='"+username+"' ");
		log.info("Collection ��¼��ȡ�ɹ�");
		return list;
	}

}
