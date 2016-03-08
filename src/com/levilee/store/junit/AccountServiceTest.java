package com.levilee.store.junit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.levilee.stroe.service.AccountService;

public class AccountServiceTest {
    private AccountService accountService =new AccountService();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testRegister() {
		assertEquals(true, accountService.register("test12", "password2"));
	}

	@Test
	public void testLogin() {
		assertEquals(true, accountService.login("levi", "levi"));
	}

	@Test
	public void testGetAccounts() {
		assertNotNull(accountService.getAccounts());
	}
	@Test
	public void testGetAccount() {
		assertEquals("levi", accountService.getAccount("levi111").getPassword());
	}
	@Test
	public void testDelete() {
		assertEquals(true, accountService.delete("levitest"));
		
	}
	
	
}
