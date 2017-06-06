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

public class submitTest extends testCore {
	@BeforeTest
	public void isSkip()
	{
		if(! TestUtil.isExecutable("SubmitForm"))
		{
			throw new SkipException("Skipping the test case as the run mode is set to No");
		}
	}

	@Test(dataProvider = "getData", priority =10)
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
			Thread.sleep(3000L);

			
			String fname = driver.findElement(By.xpath(object.getProperty("submit_fname"))).getText();
			String lname = driver.findElement(By.xpath(object.getProperty("submit_lname"))).getText();
			String fname_excel = TestUtil.excel.getCellData("SubmitForm", 0, 2);
			String lname_excel = TestUtil.excel.getCellData("SubmitForm", 1, 2);
			String phone_excel = TestUtil.excel.getCellData("SubmitForm", 2, 2);
			assertEquals(fname,fname_excel);
			assertEquals(lname,lname_excel);
			assertEquals(validation.getProperty("val_submitted"), driver.findElement(By.xpath(object.getProperty("submit_mess"))).getText());
			



		}
		catch(Throwable t)
		{
			TestUtil.CaptureScreenshot();
			Assert.assertTrue(false, t.getMessage());
			driver.get(config.getProperty("testsite"));
			t.getStackTrace();

		}

	}

	@DataProvider
	public Object[][] getData()
	{
		return TestUtil.getData("SubmitForm");
	}

}
