package conceptsE;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void moveToElementTest() throws InterruptedException {

		By MOTORS_MENU_LOCATOR = (By.xpath("//div[@id='mainContent']/descendant::li[3]/a"));
		By BOATS_LOCATOR = (By.xpath("//a[contains(text(), 'Boats')]"));

		By HOME_GARDEN_LOCATOR = (By.xpath("//div[@id='mainContent']/descendant::ul[1]/li[6]/a"));
		// By HOME_GARDEN_LOCATOR = (By.xpath("//li[@class= 'hl-cat-nav__js-tab'][3]/a"));
		By HOME_DECOR_LOCATOR = (By.xpath("//a[contains(text(), 'Home Décor')]"));

	
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(HOME_GARDEN_LOCATOR)).build().perform();
		action.moveToElement(driver.findElement(MOTORS_MENU_LOCATOR)).build().perform();
		driver.findElement(BOATS_LOCATOR).click();
		
		
	}

}
