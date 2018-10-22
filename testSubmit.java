package class3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testSubmit {
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
	public void SubmitTest() {
		driver.get("http://localhost:8080/workspace/form.php");
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("", display.getText());
		
		WebElement input = driver.findElement(By.id("id"));
		input.clear();
		input.sendKeys("John");
		input.submit();
		
		// I am at the second page
		display = driver.findElement(By.id("display"));
		assertEquals("John", display.getText());
		
	}

}
