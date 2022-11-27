package conceptsE;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class DropDownPractice {

	WebDriver driver;
	
	@Before
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
	
	@Test
	public void alertPopupTest() throws InterruptedException {
		
		By USERNAME_LOCATOR = By.xpath("//input[@id='username']");
		By PASSWORD_LOCATOR = (By.xpath("//input[@name='password']"));
		By SIGIN_BUTTON_LOCATOR = (By.xpath("//button[@class='btn btn-success block full-width']"));
		By DASHBOARD_HEADER_LOCATOR = (By.xpath("//h2[contains(text(), 'Dashboard')]"));
		By TRANSACTIONS_LOCATOR = (By.xpath("//span[contains(text(), 'Transactions')]"));
		By NEW_DEPOSIT_LOCATOR = (By.xpath("//a[contains(text(), 'New Deposit')]"));
		By ADD_DEPOSIT_LOCATOR = (By.xpath("//h5[contains(text(), 'Add Deposit')]"));
		By CHOOSE_ACCOUNT_DROPDOWN_LOCATOR = (By.xpath("//select[@id='account']"));
		By DESCRIPTION_LOCATOR = (By.xpath("//input[@name='description']"));
		By AMOUNT_LOCATOR = (By.xpath("//input[@name='amount']"));
		By SUBMIT_BUTTON_LOCATOR = (By.xpath("//button[@id='submit']"));
		By OPTION_LOCATOR = (By.xpath("//option[contains(text(), 'Choose an Account')]"));
		
		
		
		driver.findElement(USERNAME_LOCATOR).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_LOCATOR).sendKeys("abc123");
		driver.findElement(SIGIN_BUTTON_LOCATOR).click();
		driver.findElement(DASHBOARD_HEADER_LOCATOR).click();
		
		
		String dashBoardHeader = driver.findElement(DASHBOARD_HEADER_LOCATOR).getText();
		Assert.assertEquals("Wrong Page!", "Dashboard", dashBoardHeader);
		System.out.println(dashBoardHeader);
		
		driver.findElement(TRANSACTIONS_LOCATOR).click();
		driver.findElement(NEW_DEPOSIT_LOCATOR).click();
		driver.findElement(ADD_DEPOSIT_LOCATOR).click();
		
		Assert.assertEquals("Wrong Page!", "Add Deposit", driver.findElement(ADD_DEPOSIT_LOCATOR).getText());
		System.out.println(driver.findElement(ADD_DEPOSIT_LOCATOR).getText());
	
		
		Select sel = new Select (driver.findElement(CHOOSE_ACCOUNT_DROPDOWN_LOCATOR));
	//	sel.selectByVisibleText("CHECKING");
		List<WebElement> myArray = sel.getOptions();
	
		
		for (WebElement w: myArray) {
			System.out.println(w.getText());
		}
		
		
		
//		driver.findElement(DESCRIPTION_LOCATOR).sendKeys("Test account");
//		driver.findElement(AMOUNT_LOCATOR).sendKeys("500");
//		driver.findElement(SUBMIT_BUTTON_LOCATOR).click();
//		

		
		
		
	}
	
	

}
