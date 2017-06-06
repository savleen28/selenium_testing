package dd_tests;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class mandFieldTest extends testCore 
{
	@BeforeTest
	public void isSkip()
	{
		if(! TestUtil.isExecutable("FirstName_r"))
		{
			throw new SkipException("Skipping the test case as the run mode is set to No");
		}
	}
	
	@Test(dataProvider = "getData", priority =4)
	public void valFirstName(String firstname, String lastname, String phone) throws InterruptedException, IOException
	{
		try
		{
		app_Logs.debug("Executing valFirstName Test");
		driver.findElement(By.xpath(object.getProperty("clear"))).click();
		driver.findElement(By.xpath(object.getProperty("firstname"))).sendKeys(firstname);
		driver.findElement(By.xpath(object.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(object.getProperty("phone"))).sendKeys(phone);
		driver.findElement(By.xpath(object.getProperty("submit"))).click();
		assertEquals(validation.getProperty("val4"),driver.findElement(By.xpath(object.getProperty("val1"))).getText());
		}
		catch(Throwable t)
		{
			TestUtil.CaptureScreenshot();
			Assert.assertTrue(false, t.getMessage());
			driver.get(config.getProperty("testsite"));
			
		}
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return TestUtil.getData("FirstName_r");
	}
	
	
	public void isSkip1()
	{
		if(! TestUtil.isExecutable("LastName_r"))
		{
			throw new SkipException("Skipping the test case as the run mode is set to No");
		}
	}
	
	@Test(dataProvider = "getData1", priority =5)
	public void valLastName(String firstname, String lastname, String phone) throws InterruptedException, IOException
	{
		try
		{
		app_Logs.debug("Executing valFirstName Test");
		driver.findElement(By.xpath(object.getProperty("clear"))).click();
		driver.findElement(By.xpath(object.getProperty("firstname"))).sendKeys(firstname);
		//String fName = driver.findElement(By.xpath(object.getProperty("firstname"))).getAttribute("value");
		driver.findElement(By.xpath(object.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(object.getProperty("phone"))).sendKeys(phone);
		driver.findElement(By.xpath(object.getProperty("submit"))).click();
		assertEquals(validation.getProperty("val5"),driver.findElement(By.xpath(object.getProperty("val2"))).getText());
		}
		catch(Throwable t)
		{
			TestUtil.CaptureScreenshot();
			Assert.assertTrue(false, t.getMessage());
			driver.get(config.getProperty("testsite"));
			
		}
		
	}
	
	@DataProvider
	public Object[][] getData1()
	{
		return TestUtil.getData("LastName_r");
	}
	
	
	public void isSkip2()
	{
		if(! TestUtil.isExecutable("Phone_r"))
		{
			throw new SkipException("Skipping the test case as the run mode is set to No");
		}
	}
	
	@Test(dataProvider = "getData2", priority =6)
	public void valPhone(String firstname, String lastname, String phone) throws InterruptedException, IOException
	{
		try
		{
		app_Logs.debug("Executing valFirstName Test");
		driver.findElement(By.xpath(object.getProperty("clear"))).click();
		driver.findElement(By.xpath(object.getProperty("firstname"))).sendKeys(firstname);
		//String fName = driver.findElement(By.xpath(object.getProperty("firstname"))).getAttribute("value");
		driver.findElement(By.xpath(object.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(object.getProperty("phone"))).sendKeys(phone);
		driver.findElement(By.xpath(object.getProperty("submit"))).click();
		assertEquals(validation.getProperty("val6"),driver.findElement(By.xpath(object.getProperty("val3"))).getText());
		}
		catch(Throwable t)
		{
			TestUtil.CaptureScreenshot();
			Assert.assertTrue(false, t.getMessage());
			driver.get(config.getProperty("testsite"));
			
		}
		
	}
	
	@DataProvider
	public Object[][] getData2()
	{
		return TestUtil.getData("Phone_r");
	}
}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
