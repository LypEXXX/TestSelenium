package com.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.core.baseTest;
import com.Page.IndexBSPage;
import com.Page.LoginBSPage;

public class LoginBSTest extends baseTest{
	
	private LoginBSPage loginPage;
	private IndexBSPage indexPage;
	private String url = "http://sahitest.com/demo/training/login.htm";
	
	@Before
	public void setUp() {
		loginPage = new LoginBSPage();
	}

	@Test
	public void testLoginValido() {				
		loginPage.open(url);
		loginPage.inputUser("test");
		loginPage.inputPassword("secret");
		
		indexPage = loginPage.clickLoginValido();	
		
		assertTrue("Login deveria ter sido realizado!", indexPage.isLogin());
		
	}
	
	@Test
	public void testLoginPasswordInvalido() {
		loginPage.open(url);
		loginPage.inputUser("test");
		loginPage.inputPassword("passinvalido");
		
		loginPage.clickLoginInvalido();
		
		assertEquals("Mensagem deveria estar disponibilizada na tela", 
				"Invalid username or password", loginPage.getMessageError());		
		
	}
	
}