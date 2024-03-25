package com.test;

	
import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.core.baseTest;

	public class locatorsTest extends baseTest{

	@Before
	public void setUp() throws Exception {
			getDriver().get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");	
		}

	@Test
	public void locatorsTest() {
		
		WebElement checkBox = getDriver().findElement(By.xpath("//td[contains(text(),'Fulano')] /../td/input"));
		checkBox.click();
		
		assertTrue(checkBox.isSelected());
			
		}
	
	@Test
	public void testCopyEmail() {
		//É necessário colocar um /.. cada vez que for pegar outro locator
		WebElement emailEscolhido = getDriver().findElement(By.xpath("//td[.='Fulano da Silva']/..//td/following-sibling::td"));
		String email = emailEscolhido.getText();
		WebElement reservaEmail = getDriver().findElement(By.id("txt01"));
		
		reservaEmail.sendKeys(email);
		
		assertEquals("mail2@gmail.com", reservaEmail.getAttribute("value"));
		
		}

	}