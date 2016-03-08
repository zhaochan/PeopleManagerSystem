package com.levilee.store.interface1;

import java.util.List;

import com.levilee.store.entity.Orders;

public interface OrdersInter {
	//ʹ�ö�����Ӽ�¼�����Ƽ�ʹ�� 
	public boolean add(Orders order);
	//ʹ��username ��productid ��Ӽ�¼���������Զ�����һ�����㷨���ɣ��Ƽ�ʹ��
	public boolean add(String username,int productid);
	//ɾ����¼
	public boolean delete(Orders order);
	//ɾ��ĳ�û����еĶ���
	public boolean deleteByUsername(String username);
	//ɾ��ĳ�û�����ĳ����Ʒ�Ķ�������ֹ��ɾ��һ�������Ƽ�ʹ��
	public boolean deleteByUsernameAddProductid(String username,int productid);
	//���ļ�¼
	//ע�����ǵ�һ������²����ж����ĸ������������ֻ�ṩ���޸Ķ���״̬�ӿ�
	public boolean updateStatus(Orders order,int status);
	public boolean updateStatus(String username,int productid,int status);
	//��ѯ��¼
	//��ȡ���ж�����¼
	public List<Orders> getAll();
	//��ȡĳ�û��Ķ�����¼
	public List<Orders> getByUsername(String username);
	//���ĳ��������Ϣ
	public Orders getByOrderid(int orderid);
	//ʹ��username��productid ��ö�����Ϣ�����Ƽ�ʹ��
	public Orders getByUsernameAndProductid(String username,int productid);
}
