package class3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testInput {
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
	public void InputTest() {
		driver.get("http://localhost:8080/workspace/input.html");
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("", display.getText());
		WebElement name = driver.findElement(By.id("name"));
		WebElement password = driver.findElement(By.id("password"));
		name.clear();
		name.sendKeys("John");
		password.clear();
		password.sendKeys("secret");
		assertEquals("", display.getText());
		
		WebElement btn = driver.findElement(By.id("btn"));
		btn.click();
		assertEquals("Hello John", display.getText());
		assertEquals("", name.getAttribute("value"));
	}

}
