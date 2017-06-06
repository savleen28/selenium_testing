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

public class charTest extends testCore {
	
	@BeforeTest
	public void isSkip()
	{
		if(! TestUtil.isExecutable("FirstName_c"))
		{
			throw new SkipException("Skipping the test case as the run mode is set to No");
		}
	}
	
	@Test(dataProvider = "getData", priority =8)
	public void valFirstName(String firstname, String lastname, String phone) throws InterruptedException, IOException
	{
		try
		{
		app_Logs.debug("Executing valFirstName Test");
		driver.findElement(By.xpath(object.getProperty("clear"))).click();
		driver.findElement(By.xpath(object.getProperty("firstname"))).sendKeys(firstname);
		//
		driver.findElement(By.xpath(object.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(object.getProperty("phone"))).sendKeys(phone);
		driver.findElement(By.xpath(object.getProperty("submit"))).click();
		assertEquals(validation.getProperty("val7"),driver.findElement(By.xpath(object.getProperty("val1"))).getText());
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
		return TestUtil.getData("FirstName_c");
	}
	
	
	@BeforeTest
	public void isSkip1()
	{
		if(! TestUtil.isExecutable("LastName_c"))
		{
			throw new SkipException("Skipping the test case as the run mode is set to No");
		}
	}
	
	@Test(dataProvider = "getData1", priority =9)
	public void valLastName(String firstname, String lastname, String phone) throws InterruptedException, IOException
	{
		try
		{
		app_Logs.debug("Executing valLastName Test");
		driver.findElement(By.xpath(object.getProperty("clear"))).click();
		driver.findElement(By.xpath(object.getProperty("firstname"))).sendKeys(firstname);
		driver.findElement(By.xpath(object.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.xpath(object.getProperty("phone"))).sendKeys(phone);
		driver.findElement(By.xpath(object.getProperty("submit"))).click();
		assertEquals(validation.getProperty("val8"),driver.findElement(By.xpath(object.getProperty("val1"))).getText());
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
		return TestUtil.getData("LastName_c");
	}


}
