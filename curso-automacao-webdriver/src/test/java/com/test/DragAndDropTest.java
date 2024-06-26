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
import org.openqa.selenium.interactions.Actions;

import com.core.DriverFactory;
import com.core.baseTest;

public class DragAndDropTest extends baseTest{
	
	@Before
	public void setUp() throws Exception {		
		getDriver().get("https://jqueryui.com/resources/demos/droppable/default.html");	
	}

	@Test
	public void testDragAndDrop() throws InterruptedException {
		
		WebElement origin = getDriver().findElement(By.id("draggable"));
		WebElement target = getDriver().findElement(By.id("droppable"));
		
		assertEquals("Drag me to my target", origin.getText());
		assertEquals("Drop here", target.getText());
		
		new Actions(getDriver()).dragAndDrop(origin, target).perform();
		assertEquals("Dropped!", target.getText());
		}
}
