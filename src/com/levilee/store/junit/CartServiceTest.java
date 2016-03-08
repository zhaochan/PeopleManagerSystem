package com.levilee.store.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.levilee.store.entity.Cart;
import com.levilee.stroe.service.CartService;

public class CartServiceTest {
    private CartService s = new CartService(); 
	@Before
	public void setUp() throws Exception {
		//增加三个删除用例
		Cart cart = new Cart();
		cart.setProductid(999);
		cart.setCartid(999);
		cart.setUsername("test");
		cart.setAmount(1);
		s.add(cart);
		cart.setCartid(998);
		s.add(cart);
		cart.setProductid(1007);
		cart.setCartid(1);
		cart.setUsername("levi");
		cart.setAmount(10);
		s.add(cart);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testAdd() {
		assertEquals(true, s.add("levi",1009,5));
	}

	@Test
	public void testDeleteCart() {
		assertEquals(true, s.delete(998));
	}

	@Test
	public void testDeleteString() {
		assertEquals(true, s.delete("levi"));
	}

	@Test
	public void testDeleteInt() {
		assertEquals(true, s.delete(999));
	}

	@Test
	public void testUpdate() {
		Cart cart = new Cart();
		cart.setProductid(1007);
		cart.setCartid(1);
		cart.setUsername("levi");
		cart.setAmount(10);
		assertEquals(true, s.update(cart));
	}

	@Test
	public void testGet() {
		assertNotNull(s.get());
	}

	@Test
	public void testGetString() {
		assertEquals("test", s.get("test").get(0).getUsername()  );
	}

	@Test
	public void testGetInt() {
		assertEquals("test", ((Cart)s.get(999)).getUsername());
	}

}
