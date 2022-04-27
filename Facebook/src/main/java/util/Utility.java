package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void captureScreenshot(WebDriver driver,String testID)throws IOException
	{
		String dateAndTime = LocalDateTime.now().toString();
		dateAndTime = dateAndTime.replace(':', '-');
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("F:\\Software Testing\\Automation\\Screenshots\\Test"+testID+dateAndTime+".jpg");
		
		FileHandler.copy(source, destination);
	}
   
   public static String getData(String sheetName,int rowIndex, int columnIndex)throws IOException
   {
	   String path ="F:\\Software Testing\\TestData\\FacebookTestData.xlsx";
	   
	   FileInputStream file = new FileInputStream(path);
		
	   String data = WorkbookFactory.create(file).getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getStringCellValue();
	   
	   return data;
			     
   }
}
