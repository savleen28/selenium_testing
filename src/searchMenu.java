import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class searchMenu {

	public static void main(String[] args) throws InterruptedException {
		
		/*System.setProperty("webdriver.gecko.driver","C:\\Users\\BEDI\\Downloads\\software\\"
				+ "geckodriver-v0.13.0-win32\\geckodriver.exe");*/
		
		/*WebDriver driver = new FirefoxDriver();*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BEDI\\Downloads\\software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		
		
	/*	FluentWait fluentWait = new FluentWait<>(driver)
		    .withTimeout(30, TimeUnit.SECONDS)
		    .pollingEvery(200, TimeUnit.MILLISECONDS);*/
		
		
		driver.get("http://www.fb.com");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("savleenbedi90@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("bedisavleen001");
		driver.findElement(By.cssSelector(".uiButton.uiButtonConfirm")).click();
		Thread.sleep(15000L);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='u_4_2']/input[1]")));
		driver.findElement(By.cssSelector("._1frb")).sendKeys("Amarpreet Singh");
		Thread.sleep(5000);
		List<WebElement> a = driver.findElements(By.cssSelector("._202._19bq"));
		//System.out.println(a.get(0).getText());
		a.get(0).click();
		Thread.sleep(5000);
		Boolean t = driver.findElement(By.cssSelector("._2yer._401d._2xje")).getText().contains("Tata Consultancy Services");
		
		System.out.println(t);
		

	}

}
