package com.levilee.stroe.service;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.levilee.store.dao.UserinfoDao;
import com.levilee.store.entity.Userinfo;
import com.levilee.store.interface1.UserinfoInter;

public class UserinfoService implements UserinfoInter{
    private UserinfoDao dao = new UserinfoDao();
    private Logger log = Logger.getLogger("levilog");
	@Override
	public boolean add(Userinfo userinfo) {
		try {
			dao.add(userinfo);
		} catch (Exception e) {
			log.error("�û���Ϣ���ʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean add(String username, String sex, String email,
			String phonenumber, String address) {
		Userinfo userinfo = new Userinfo();
		userinfo.setAddress(address);
		userinfo.setEmail(email);
		userinfo.setPhonenumber(phonenumber);
		userinfo.setRegdate(new Date(System.currentTimeMillis()));
		userinfo.setSex(sex);
		userinfo.setUsername(username);
		try {
			dao.add(userinfo);
		} catch (Exception e) {
			log.error("����û���Ϣʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Userinfo userinfo) {
		try {
			dao.delete(userinfo);
		} catch (Exception e) {
			log.error("ɾ��ʧ�ܣ����������ݿ��в����ڶ�����Ϣ");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteByUsername(String username) {
		try {
			dao.delete(username);
		} catch (Exception e) {
			log.error("ɾ��ʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Userinfo userinfo) {
		try {
			dao.update(userinfo);
		} catch (Exception e) {
			log.error("����ʧ�ܣ����ݿ���û�������Ϣ");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Userinfo> getAll() {
		List<Userinfo> list = null;
		try {
			list = dao.get();
		} catch (Exception e) {
			log.error("�û���Ϣ��ȡʧ��");
			e.printStackTrace();
			return null;
		}
		return list;
	}
	@Override
	public Userinfo getByUsername(String username) {
		List<Userinfo> list = null;
		try {
			list =  dao.getByCondition("where username ="+username);
		} catch (Exception e) {
			log.error("�û���Ϣ��ȡʧ��");
			e.printStackTrace();
			return null;
		}
		if(list.isEmpty()){
			log.error("�û���Ϣ��ȡʧ��");
			return null;
		}
		return list.get(0);
	}
	
//	@org.junit.Test
 public void Test(){
	 Userinfo userinfo = getByUsername("123");
	 System.out.println(userinfo.getAddress());
 }
}
