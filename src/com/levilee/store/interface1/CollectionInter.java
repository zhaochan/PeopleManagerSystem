package com.levilee.store.interface1;

import java.util.List;

import com.levilee.store.entity.Collection;

public interface CollectionInter {
	//�����ղؼ�¼��������ݿ����Ѿ����˾ͻ����ʧ��,�������������û��ʲô����
	public boolean add(Collection collection);
	//������ݿ�������ͬusername��ͬ��Ʒproductid�����ݣ������ݲ�����ӣ�����false
	public boolean add(String username,int productid);
    //ɾ��ĳ���ղؼ�¼��һ�����Ȼ�ȡ��ɾ����
	public boolean delete(Collection collection);
	//ɾ��ĳ�û��������ղؼ�¼
	public boolean deleteByUsername(String username);
	//ɾ��ָ�����ղؼ�¼
	public boolean deleteByUsernameAddProductid(String username,int productid);
	//��ȡ�����û������ղؼ�¼
	public List<Collection> getAll();
	//��ȡָ���û��������ղؼ�¼
	public List<Collection> getByUsername(String username);
	

}
