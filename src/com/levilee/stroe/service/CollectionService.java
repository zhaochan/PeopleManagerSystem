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
		//1.判断该collection是否存在于数据库
		Collection c = (Collection) dao.get(collection.getCollectionid());
		if(c!=null){
			log.warn("该购物车记录已存在，添加失败");
			return false;
		}
		dao.add(collection);
		return true;
	}

	@Override
	public boolean add(String username, int productid) {
		List<Collection> list = dao.getByCondition(" where username='"+username+"'  and productid='"+productid+"'");
		if(!list.isEmpty()){
			//如果查询结果不为空，说明数据库已存在该数据，不再添加
			log.warn("该购物车记录已存在，添加失败");
			return false;
		}
		//新建collection对象
		Collection c = new Collection();
		//为对象赋值
		c.setCollectionid(HibernateUtil.getId("collectionid"));
		c.setUsername(username);
		c.setProductid(productid);
		c.setDate(new Date(System.currentTimeMillis()));
		dao.add(c);
		log.info("Collection 记录添加成功");
		return true;
	}

	@Override
	public boolean delete(Collection collection) {
		dao.delete(collection);
		log.info("Collection 记录删除成功");
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
			log.error("hql执行失败");
			return false;
		}
		log.info("Collection 记录删除成功");
		return true;
	}

	@Override
	public boolean deleteByUsernameAddProductid(String username, int productid) {
		try{
			System.out.println("执行删除"+username+productid);
			List<Collection> list = dao.getByCondition("collection where username='"+username+"'  and productid='"+productid+"'");
			System.out.println(list);
			for(Collection e : list){
				dao.delete(e);
			}
		}catch(Exception e){
			log.error("hql执行失败");
			return false;
		}
		log.info("Collection 记录删除成功");
		return true;
	}

	@Override
	public List<Collection> getAll() {
		List<Collection> list = dao.get();
		log.info("Collection 记录获取成功");
		return list;
	}

	@Override
	public List<Collection> getByUsername(String username) {
		List<Collection> list = dao.getByCondition(" where username='"+username+"' ");
		log.info("Collection 记录获取成功");
		return list;
	}

}
