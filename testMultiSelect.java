package class3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testMultiSelect {
private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void MultiSelectTest() {
		driver.get("http://localhost:8080/workspace/multiple.html");
		Select pick = new Select(driver.findElement(By.id("color")));
		pick.selectByVisibleText("White");
		pick.selectByVisibleText("Brown");
		
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("White,Brown", display.getText());
		
	}
	
	@Test
	public void MultipleSelectTest() {
		driver.get("http://localhost:8080/workspace/multiple.html");
		Select pick = new Select(driver.findElement(By.id("color")));
		pick.selectByVisibleText("Red");
		pick.selectByVisibleText("White");
		pick.deselectByIndex(1);
		pick.selectByValue("rb");
		
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("Red,Brown", display.getText());
		
	}
}
