package com.test;


import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.core.DriverFactory;
import com.core.baseTest;

public class navegacaoJanelasAbertasTest extends baseTest{
	
	@Before
	public void setUp() throws Exception {		
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/index.html");	
	}
	
	@Test
	public void testValidaNavigationForTabs() throws InterruptedException {
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
				
		WebElement linkDragAndDrop = getDriver().findElement(By.linkText("Drag and Drop"));
		linkDragAndDrop.click();
	
		WebElement linkBookStore = getDriver().findElement(By.linkText("Book Store"));
		linkBookStore.click();
				
		//Monta um array com as janelas/tabs abertas
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		//Navega nas posições do array
		getDriver().switchTo().window(tabs.get(1));
		assertEquals("Login", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(2));
		assertEquals("Mootools Drag and Drop Example", getDriver().getTitle());		
	
		getDriver().switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
	}

}