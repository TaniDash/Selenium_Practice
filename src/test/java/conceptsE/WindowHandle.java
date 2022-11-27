package conceptsE;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void windowHandleTest() throws InterruptedException {
		//System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("w3 School");
		String handle1= driver.getWindowHandle();
		//System.out.println(handle1);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ybar-search']")).click();
		//System.out.println(driver.getTitle());
		String handle2= driver.getWindowHandle();
		//System.out.println(handle2);
		
		driver.findElement(By.xpath("//div[@id='web']/ol/li[1]/div/div[1]/h3/a")).click();
		Set<String> handle3= driver.getWindowHandles();
		System.out.println(handle3);
		
		for (String str: handle3) {
			driver.switchTo().window(str);	
		}
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(handle2);
		System.out.println(driver.getTitle());
		
	}
	
	
}
