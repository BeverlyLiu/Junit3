package class3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testSelect {
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
	public void testOptions() {
		driver.get("http://localhost:8080/workspace/select.html");
		Select pick = new Select(driver.findElement(By.id("car")));
		List<WebElement> options = pick.getOptions();
		String[] expected = {"Pick a car", "Volvo", "Saab", "Mercedes", "Audi"};
		List<String> actual = new ArrayList<String>();
		for(WebElement option : options) {
			actual.add(option.getText());
		}
		extracted(expected, actual);
	}

	@SuppressWarnings("deprecation")
	private void extracted(String[] expected, List<String> actual) {
		assertEquals(expected, actual.toArray());
	}
	
	@Test
	public void testSelection() {
		driver.get("http://localhost:8080/workspace/select.html");
		Select pick = new Select(driver.findElement(By.id("car")));
		WebElement display = driver.findElement(By.id("display"));
		WebElement selected = pick.getFirstSelectedOption();
		assertEquals("Pick a car", selected.getText());
		
		pick.selectByVisibleText("Audi");
		selected = pick.getFirstSelectedOption();
		assertEquals("Audi", selected.getText());
		assertEquals("Audi", display.getText());
		
		pick.selectByValue("");
		selected = pick.getFirstSelectedOption();
		assertEquals("Pick a car", selected.getText());
		assertEquals("Pick a car", display.getText());
		
		pick.selectByIndex(3);
		selected = pick.getFirstSelectedOption();
		assertEquals("Mercedes", selected.getText());
		assertEquals("Mercedes", display.getText());
		
	}
	

}