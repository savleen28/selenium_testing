package dd_core;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import dd_util.TestConfig;
import dd_util.Xls_Reader;
import dd_util.monitoringMail;
public class testCore {


	//Initialising Properties, xls, creating db connection, generating logs, init WebDriver



	public static Properties config = new Properties();
	public static Properties object = new Properties();
	public static Properties validation = new Properties();
	public static Xls_Reader excel = null;
	public static WebDriver driver = null;
	public static Logger app_Logs = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public static void init() throws IOException
	{
		if(driver== null)
		{


			// loading config property file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\config.properties");
			config.load(fis);
			app_Logs.debug("Loading the config properties file");

			// loading object property file
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\object.properties");
			object.load(fis); 
			app_Logs.debug("Loading the object properties file");

			// loading validation property file
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\validation.properties");
			validation.load(fis); 
			app_Logs.debug("Loading the validation properties file");
			
			//excel = new Xls_Reader("C:\\Users\\BEDI\\Downloads\\Selenium\\testdatadd.xlsx");
			
			app_Logs.debug("Loading the excel file");
			if(config.getProperty("browser").equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\Users\\BEDI\\Downloads\\software\\"
						+ "geckodriver-v0.13.0-win32\\geckodriver.exe");
				driver = new FirefoxDriver();
			}

			else if(config.getProperty("browser").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\BEDI\\Downloads\\software\\New folder\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				

			}
			else if(config.getProperty("browser").equals("ie"))

			{
				System.setProperty("webdriver.ie.driver", "C:\\Users\\BEDI\\Downloads\\IEDriverServer_Win32_3.0.0\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

			// Implicit Wait

			driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
			driver.get(config.getProperty("testsite"));

		}
	}
	@AfterSuite
	public static void QuitDriver() throws AddressException, MessagingException
	{
		driver.quit();
		// monitoringMail mail = new monitoringMail();
		// mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
	}


}
