package class3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssTest {
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
	public void testH1Sytel() {
		driver.get("http://localhost:8080/workspace/css.html");
		WebElement h1 = driver.findElement(By.tagName("h1"));
		assertEquals("center", h1.getCssValue("text-align"));
		assertEquals("rgba(51, 51, 51, 1)", h1.getCssValue("color"));
		assertEquals("rgba(255, 255, 0, 1)", h1.getCssValue("background-color"));
		
	}
	
	@Test
	public void testH2Sytel() {
		driver.get("http://localhost:8080/workspace/css.html");
		WebElement h2 = driver.findElement(By.tagName("h2"));
		System.out.println(h2.getCssValue("border"));
		System.out.println(h2.getCssValue("border-top-color"));
		System.out.println(h2.getCssValue("border-top-width"));
		System.out.println(h2.getCssValue("border-top-sytel"));
	}
}
