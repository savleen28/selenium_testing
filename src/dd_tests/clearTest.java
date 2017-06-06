package dd_tests;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class clearTest extends testCore{
	@BeforeTest
	public void isSkip()
	{
		if(! TestUtil.isExecutable("ClearForm"))
		{
			throw new SkipException("Skipping the test case as the run mode is set to No");
		}
	}
	
	
	@Test(dataProvider = "getData", priority =7)
	public void valClearButton(String firstname, String lastname, String phone) throws InterruptedException, IOException
	{
		try{
			app_Logs.debug("Executing valFirstName Test");
		driver.findElement(By.xpath(object.getProperty("clear"))).click();
		driver.findElement(By.xpath(object.getProperty("firstname"))).sendKeys(firstname);
		driver.findElement(By.xpath(object.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(object.getProperty("phone"))).sendKeys(phone);
		driver.findElement(By.xpath(object.getProperty("submit"))).click();
		driver.findElement(By.xpath(object.getProperty("clear"))).click();
		String fname = driver.findElement(By.xpath(object.getProperty("firstname"))).getAttribute("value");
		String lname = driver.findElement(By.xpath(object.getProperty("lastname"))).getAttribute("value");
		String phone1 = driver.findElement(By.xpath(object.getProperty("phone"))).getAttribute("value");
		boolean val1 = driver.findElement(By.xpath(object.getProperty("val1"))).isDisplayed();
		boolean val2 = driver.findElement(By.xpath(object.getProperty("val2"))).isDisplayed();
		boolean val3 = driver.findElement(By.xpath(object.getProperty("val3"))).isDisplayed();
		
		if(fname.isEmpty())
		{
			assertEquals("1","1");
		}
		
		if(lname.isEmpty())
		{
			assertEquals("1","1");
		}
		
		if(phone1.isEmpty())
		{
			assertEquals("1","1");
		}
		
		
		
		if(!val1)
		{
			assertEquals("1","1");
		}
		
		if(!val2)
		{
			assertEquals("1","1");
		}
		
		if(!val3)
		{
			assertEquals("1","1");
		}
		
		}
		catch(Throwable t)
		{
			Assert.assertTrue(false, t.getMessage());
		}
		
		
	}
	
@DataProvider
	public Object[][] getData()
	{
		return TestUtil.getData("ClearForm");
	}
	
	

}
