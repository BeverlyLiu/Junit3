package class3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindNestedElementByXPath {
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
	public void testFindElementInsideElement() {
		driver.get("http://localhost:8080/workspace/divs.html");
		WebElement id1 = driver.findElement(By.id("id1"));
		WebElement p1 = id1.findElement(By.xpath("//p"));
		WebElement p2 = id1.findElement(By.xpath("./p"));
		WebElement p3 = id1.findElement(By.xpath(".//p"));
		
		assertEquals("Hello", p1.getText());
		assertEquals("World", p2.getText());
		assertEquals("World", p3.getText());
	}

}
