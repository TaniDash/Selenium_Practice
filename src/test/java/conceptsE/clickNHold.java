package conceptsE;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class clickNHold {

	//Drag and Drop
	
WebDriver driver;
	
	@Before
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
	
	@Test
	public void dragNDropTest() {
		
		driver.switchTo().frame(0);
		
		By draggable_locator = By.xpath("//div[@id='draggable']");
		By droppable_locator = By.xpath("//div[@id='droppable']");
		
		
		Actions action = new Actions (driver);
		action.clickAndHold(driver.findElement(draggable_locator))
		.moveToElement(driver.findElement(droppable_locator))
		.release().build().perform();
	
		
	}	
	
	
	
	
	
}
