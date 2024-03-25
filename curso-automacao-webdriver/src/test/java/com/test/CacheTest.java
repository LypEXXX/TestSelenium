package com.test;


import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.core.DriverFactory;
import com.core.baseTest;

public class CacheTest extends baseTest{
	
	@Before
	public void setUp() throws Exception {		
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/index.html");		
	}
	
	@Test
	public void testNavigationCache() throws InterruptedException {
		assertEquals("Treino Automação de Testes", getDriver().getTitle());		
		
		WebElement menuCalculadora = getDriver().findElement(By.linkText("Calculadora"));
		menuCalculadora.click();
		
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		WebElement menuLocalizarTable = getDriver().findElement(By.linkText("Localizar Table"));
		menuLocalizarTable.click();
		
		assertEquals("Trabalhando com tables", getDriver().getTitle());	
		
		getDriver().navigate().back();
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		getDriver().navigate().back();
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		getDriver().navigate().forward();
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		getDriver().navigate().forward();
		assertEquals("Trabalhando com tables", getDriver().getTitle());
		
		getDriver().navigate().refresh();
		assertEquals("Trabalhando com tables", getDriver().getTitle());
		
	}

}
