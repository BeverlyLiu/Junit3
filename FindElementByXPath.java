package class3;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByXPath {
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
	public void testAncestor() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		List<WebElement> divs = driver.findElements(By.xpath("//p[@id='bye']/ancestor::div"));
		for(WebElement div:divs) {
			System.out.println(div.getAttribute("id"));
		}
		WebElement innerMostDiv = driver.findElement(By.xpath("//p[@id='bye']/ancestor::div[1]"));
		WebElement outerMostDiv = driver.findElement(By.xpath("//p[@id='bye']/ancestor::div[3]"));
		
		assertEquals("inner",innerMostDiv.getAttribute("id"));
		assertEquals("outer",outerMostDiv.getAttribute("id"));
		
		WebElement mystery = driver.findElement(By.xpath("//p[@id='bye']/ancestor::div"));
		
		assertEquals("outer", mystery.getAttribute("id"));
		
		//another way to find parent
		WebElement parent = driver.findElement(By.xpath("//p[@id='bye']/parent::*"));
		
		assertEquals("inner", parent.getAttribute("id"));
		
		WebElement middleDiv = driver.findElement(By.xpath("//p[@id='bye']/ancestor::*[contains(@class, 'a-row')][1]"));
		
		assertEquals("div", middleDiv.getAttribute("id"));
	}
	
	

}
