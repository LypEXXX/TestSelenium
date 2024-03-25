package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.core.DriverFactory;
import com.core.baseTest;

public class validaCpfTest extends baseTest{
	
	@Before
	public void setUp() throws Exception {
		getDriver().get("https://www.geradordecpf.org/");		
	}

	@Test
	public void validaCpfTest() {
		assertEquals("Gerador de CPF", getDriver().getTitle());
		
		WebElement selecPontuacao = getDriver().findElement(By.name("cbPontos"));
		selecPontuacao.click();
		WebElement geraCpfBtn = getDriver().findElement(By.id("btn-gerar-cpf"));
		geraCpfBtn.click();
		WebElement numeroCpf1 = getDriver().findElement(By.id("numero"));
		
		String cpfGerado = numeroCpf1.getAttribute("value");
		System.out.println(cpfGerado);
	
		assertTrue(cpfGerado.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$"));
		}



	@Test
	public void validaCpfSemPontuacao() {
		
		assertEquals("Gerador de CPF", getDriver().getTitle());
		
		WebElement geraCpfBtn = getDriver().findElement(By.id("btn-gerar-cpf"));
		geraCpfBtn.click();
		
		WebElement numeroCpf2 = getDriver().findElement(By.id("numero"));
		
		String cpfGeradoSemPontuacao = numeroCpf2.getAttribute("value");
		System.out.println(cpfGeradoSemPontuacao);
		
		assertTrue(cpfGeradoSemPontuacao.matches("^[0-9]{11}$"));
		}
}

