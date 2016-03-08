package com.levilee.store.interface1;

import java.io.Serializable;
import java.util.List;

public interface CommonInterface {
	//����
	public <E> boolean  add(E e);
   //ɾ��
	public <E> boolean delete(E e);
	public boolean delete(Serializable id);
	//ɾ�����������е�ֵ����Ҫ��Ϊ���Ż�����
	public boolean delete(List list);
	//����
	public <E> boolean update(E e);
	public boolean update(String hql);
	//��ѯ
	//��ѯ����
	public  <E> List<E> get();
	//��ָ��������ѯ
	public <E> List<E> getByCondition(String sql);
	//ʹ��������ѯ
	public Object get(Serializable id);
	//��ȫʹ��hql����ѯ
	public <E> List <E> getByHql(String hql);
}
