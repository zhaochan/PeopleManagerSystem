package com.levilee.store.junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.levilee.store.entity.Categories;
import com.levilee.stroe.service.CategoriesService;

public class CategoriesServiceTest {
	private CategoriesService s = new CategoriesService();
	@Before
	public void setUp() throws Exception {
		//ÐÂ½¨É¾³ýÓÃÀý
//		Categories c1 = new Categories();
//		c1.setCategoryname("junittest1");
//		c1.setCategoryid(1);
//		new CategoriesDao().add(c1);
//		Categories c2 = new Categories();
//		c2.setCategoryname("junittest2");
//		c2.setCategoryid(2);
//		new CategoriesDao().add(c2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		assertNotNull(s.get(1002));
	}

	@Test
	public void testAdd() {
		assertEquals(true, s.add("test111"));
	}

	@Test
	public void testDeleteInt() {
		assertEquals(true, s.delete(1));
	}

	@Test
	public void testDeleteCategories() {
		Categories c2 = new Categories();
		c2.setCategoryname("junittest2");
		c2.setCategoryid(2);
		assertEquals(true, s.delete(c2));
	}
}
