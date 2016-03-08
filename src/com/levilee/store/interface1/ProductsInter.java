package com.levilee.store.interface1;

import java.util.List;

import com.levilee.store.entity.Products;

public interface ProductsInter {
	//���Ӳ�Ʒ����ȷ��productid�����������ݿ���,��������ʧ��
	public boolean add(Products product);
	public boolean add(String username,String description,double price,String category,String photo1,String photo2);
	//ɾ����Ʒ
	public boolean delete(Products product);
	public boolean delete(int productid);
	//���²�Ʒ
	public boolean update(Products product);
	//��ѯ��Ʒ
	//��ѯ���в�Ʒ
	public List<Products> getAll();
	//��ѯָ���û����Ĳ�Ʒ
	public List<Products> getByUsername(String username);
	//��ѯָ����Ŀ���ƵĲ�Ʒ
	public List<Products> getByCategory(String categoryname);
	
	public List<Products> getByProductid(int productid);
	
}
