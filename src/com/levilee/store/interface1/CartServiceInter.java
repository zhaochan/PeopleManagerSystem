package com.levilee.store.interface1;

import java.util.List;

import com.levilee.store.entity.Cart;

public interface CartServiceInter {
	 //1.�������(������newһ��Cart����Ȼ��ʹ��set������ֵ�������ø÷������)
	 public boolean add(Cart cart);
     //ֱ��ʹ�������û�������Ʒid,������ӣ���̨���Զ�
	 public boolean add(String username,int productid,int amount);
	 //2.ɾ������
	 public boolean delete(Cart cart);
	 //2.1ɾ��ָ���û������й��ﳵ����
	 public boolean delete(String username);
	 //2.2ʹ��idɾ��ָ�����ﳵ����
	 public boolean delete(int cartid);
	 //3.��������
	 public boolean update(Cart cart);
	 //4.��ѯ����
	 //4.1��ѯ���й��ﳵ����
	 public List<Cart>  get();
	 //4.2��ѯָ���ͻ��Ĺ��ﳵ����,���ص���һ��List
	 public List<Cart> get(String username);
	 //4.3��ѯָ��id�Ĺ��ﳵ����
	 public Cart get(int cartid);
}
