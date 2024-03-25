package com.test;


import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.core.DriverFactory;
import com.core.baseTest;

public class WebElementTest extends baseTest{
	
	@Before
	public void setUp() throws Exception {
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/elementsweb.html");	
	}

	@Test
	public void testInputTextFieldHelloWorld() {
		//identifica o elemento
		WebElement textField = getDriver().findElement(By.name("txtbox1"));	
		//envia um valor de texto para o elemento		
		textField.sendKeys("Hello World!!");				
		
		//valida o resultado esperado é igual ao resultado atual
		assertEquals("Hello World!!", textField.getAttribute("value"));
	}
	
	@Test
	public void testValidaHabilitadoTextFields() {
		WebElement textField1 = getDriver().findElement(By.name("txtbox1"));
		WebElement textField2 = getDriver().findElement(By.name("txtbox2"));
		
		//elemento está habilitado?
		assertTrue(textField1.isEnabled());
		//elemento está desabilitado?
		assertFalse(textField2.isEnabled());					
	}
	
	@Test
	public void testValidaRadioButton() {
		//mapeia
		List<WebElement> radios = getDriver().findElements(By.name("radioGroup1"));	
		
		//faz a iteração
		for (WebElement radio : radios) {
			if (radio.getAttribute("value").equals("Radio 3")) {
				radio.click();
			}			
		}		
		//Outra forma de fazer por posição
		//radios.get(2).click();
				
		//faz a validação
		assertTrue(radios.get(2).isSelected());
		
		assertFalse(radios.get(0).isSelected());
		assertFalse(radios.get(1).isSelected());
		assertFalse(radios.get(3).isSelected());		
	}
	
	@Test
	public void testValidaCheckBox() {
		//mapeia
		List<WebElement> checkBoxes = getDriver().findElements(By.name("chkbox"));
		
		//valida se a lista tem 4 elementos
		assertEquals(4, checkBoxes.size());

		//faz a iteração com elemnto
		for (WebElement checkBox : checkBoxes) {
			if (checkBox.getAttribute("value").equals("Check 3") || 
					(checkBox.getAttribute("value").equals("Check 4"))) {
				checkBox.click();
			}			
		}		
				
		//faz a validação
		assertTrue(checkBoxes.get(2).isSelected());
		assertTrue(checkBoxes.get(3).isSelected());
		
		assertFalse(checkBoxes.get(0).isSelected());
		assertFalse(checkBoxes.get(1).isSelected());		
	}
	
	@Test
	public void testValidaSelectSingle() {
		//mapeia o elemento
		WebElement dropdownSingle = getDriver().findElement(By.name("dropdownlist"));		
		Select selectSingle = new Select(dropdownSingle);
		
		//faz a iteração
		selectSingle.selectByVisibleText("Item 6");		
		
		selectSingle.selectByVisibleText("Item 7");
		
		//faz a validação
		assertEquals("Item 7", selectSingle.getFirstSelectedOption().getText());
	}
	
	@Test
	public void testValidaSelectMulti() {
		WebElement dropdownMulti = getDriver().findElement(By.name("multiselectdropdown"));
		
		Select selectMulti = new Select(dropdownMulti);
		
		selectMulti.selectByVisibleText("Item 5");
		selectMulti.selectByVisibleText("Item 8");
		selectMulti.selectByVisibleText("Item 9");				
		
		List<WebElement> optionsSelected = selectMulti.getAllSelectedOptions();
		
		//Valida 3 selecionados // Quantos
		assertEquals(3, optionsSelected.size());
		
		//Quais
		assertEquals("Item 5", optionsSelected.get(0).getText());
		assertEquals("Item 8", optionsSelected.get(1).getText());
		assertEquals("Item 9", optionsSelected.get(2).getText());
		
		selectMulti.deselectByVisibleText("Item 8");
		
		optionsSelected = selectMulti.getAllSelectedOptions();
		
		//Quantos
		assertEquals(2, optionsSelected.size());
		///Quais
		assertEquals("Item 5", optionsSelected.get(0).getText());
		assertEquals("Item 9", optionsSelected.get(1).getText());
	}
	@Test
	public void testValidaAlert() throws InterruptedException {
		WebElement btnAlert = getDriver().findElement(By.name("alertbtn"));
		btnAlert.click();
		
		Alert alert = getDriver().switchTo().alert();
		assertEquals("Eu sou um alerta!", alert.getText());
		
		alert.accept();		
	}
	@Test
	public void testValidaAlertConfirm() throws InterruptedException {
		WebElement confirmBtn = getDriver().findElement(By.name("confirmbtn"));
		confirmBtn.click();
		
		Alert alertConfirm = getDriver().switchTo().alert();
		assertEquals("Pressione um botão!", alertConfirm.getText());
		
		alertConfirm.accept();
	
	}
	
	@Test
	public void testValidaPromptBtn() throws InterruptedException {
		WebElement btnPrompt = getDriver().findElement(By.id("promptBtn"));
		btnPrompt.click();
		
		Alert preencheAlert = getDriver().switchTo().alert();
		preencheAlert.sendKeys("2024");
		
		preencheAlert.accept();
		Alert confirmaAno = getDriver().switchTo().alert();
		assertEquals("O ano é 2024?", confirmaAno.getText());
		
		confirmaAno.accept();
		Alert confirmaFinal = getDriver().switchTo().alert();
		assertEquals(confirmaFinal.getText(), "Feito!");
		
		confirmaFinal.accept();
	}
	
	@Test
	public void testaValidaIframe() {
		getDriver().switchTo().frame("frame1");
		
		WebElement tfIframe = getDriver().findElement(By.id("tfiframe"));
		tfIframe.sendKeys("Automação de teste");
		
		assertEquals("Automação de teste", tfIframe.getAttribute("value"));
		getDriver().switchTo().defaultContent();
		
}

		
	}
