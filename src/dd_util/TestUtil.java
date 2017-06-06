



package dd_util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import dd_core.testCore;

public class TestUtil extends testCore{
	public static Xls_Reader excel = new Xls_Reader("C:\\Users\\BEDI\\Downloads\\Selenium\\testdatadd.xlsx");

	public static boolean isExecutable(String tcid)
	{
		try{

			//Xls_Reader excel = new Xls_Reader("C:\\Users\\BEDI\\Downloads\\Selenium\\testdatadd.xlsx");
			for (int rownum =2;rownum<=excel.getRowCount("test_suite");rownum++)
			{
				if(excel.getCellData("test_suite", "tcid", rownum).equals(tcid))
				{
					if(excel.getCellData("test_suite", "runmode", rownum).equals("Y"))
					{


						return true;

					}
					else
					{
						System.out.println("false");
						return false;
					}
				}
			}



		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return false;
	}



	@DataProvider
	public static Object[][] getData(String sheetname) 
	{
		Xls_Reader excel1 = new Xls_Reader("C:\\Users\\BEDI\\Downloads\\Selenium\\testdatadd.xlsx");
		int rows = excel1.getRowCount(sheetname);

		int cols = excel1.getColumnCount(sheetname);
		Object data[][] = new Object [rows-1][cols];
		for(int rownum = 2;rownum<=rows;rownum++)
		{
			for(int colnum=0; colnum<cols;colnum++)
			{
				data[rownum-2][colnum] = excel1.getCellData(sheetname, colnum, rownum);

			}
		}

		return data;
	}

	public static void CaptureScreenshot() throws IOException {
		try
		{
			Calendar cal = new GregorianCalendar();
			int month = cal.get(Calendar.MONTH); 
			int year = cal.get(Calendar.YEAR); 
			int sec =cal.get(Calendar.SECOND);
			int min =cal.get(Calendar.MINUTE);
			int date = cal.get(Calendar.DATE);
			int day =cal.get(Calendar.HOUR_OF_DAY);

			String mailscreenshotpath = System.getProperty("user.dir")+"\\screenshots\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";

			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
		}
		catch(Exception e)
		{
			System.out.println("Exception is" + e);
		}

	}




}
























/*package dd_util;

//import dd_core.testCore;

public class TestUtil extends testCore{
	public static Xls_Reader excel = null;

	public static  boolean isExecutable()
	{
		 excel  = new Xls_Reader(System.getProperty("C:\\Users\\BEDI\\workspace\\Selenium\\WebDriver_TestNG_DDFramework\\src\\dd_properties\\testdatadd.xlsx"));

		//String x = excel.getCellData("test_suite", "tcid", 2);
		//System.out.println(x);
		for (int rownum =2;rownum<=excel.getRowCount("test_suite");rownum++)
		{
			if(excel.getCellData("test_suite", "tcid", rownum).equals("LoginTest"))
			{
				if(excel.getCellData("test_suite", "runmode", rownum).equals("Y"))
				{System.out.println("T");
					return true;
				}
				else
				{System.out.println("F");
					return false;
				}
			}
		}
		System.out.println("F");
		return false;

	}

	public static void main(String[] args)
	{
		isExecutable();
	}

}
 */