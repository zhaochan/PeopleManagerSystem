package com.levilee.store.interface1;

import java.sql.Date;
import java.util.List;

import com.levilee.store.entity.Userinfo;

public interface UserinfoInter {
     //�����û���Ϣ
	public boolean add(Userinfo userinfo);
	public boolean add(String username,String sex,String email,String phonenumber,String address);
	//ɾ���û���Ϣ
	public boolean delete(Userinfo userinfo);
	public boolean deleteByUsername(String username);
	//�����û���Ϣ
	public boolean update(Userinfo userinfo);
	//��ѯ�û���Ϣ
	public List<Userinfo>  getAll();
	public Userinfo getByUsername(String username);
}
