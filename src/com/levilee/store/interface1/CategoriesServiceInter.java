package com.levilee.store.interface1;

import com.levilee.store.entity.Categories;

public interface CategoriesServiceInter {
	//����ָ��id��ȡCategory
	public Categories get(int id);
	//���category��ע�⣺���categoryname�����ݿ����Ѵ��ڵĻ��᲻ִ����ӣ�
	public boolean add(String categoryname);
	//ɾ��category
	public boolean delete(int id);
	public boolean delete(Categories categories);

}
