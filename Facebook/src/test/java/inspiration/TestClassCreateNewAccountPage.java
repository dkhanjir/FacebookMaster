package inspiration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Pojo;
import pom.LoginOrSingUpPage;
import util.Utility;

public class TestClassCreateNewAccountPage extends Pojo{
	
	private WebDriver driver;
	private LoginOrSingUpPage loginOrSingUpPage;
	private String testID;
	private SoftAssert softAssert;
	
	@BeforeTest
	@Parameters("browser")
	public void launchTheBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver= lauchChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			driver= lauchFirefoxBrowser();
		}
		if(browserName.equals("Edge"))
		{
			driver= lauchEdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createObjectOfPOMClasses()
	{
		loginOrSingUpPage = new LoginOrSingUpPage(driver);
	}
	
	@BeforeMethod
	public void launchTheApplication()
	{
		driver.get("https://www.facebook.com/");
		loginOrSingUpPage.clickOnCreateNewAccount();
	}
	
	@Test
	public void verifyCreateNewAccountPopup()
	{
		testID = "CNA101";
				
		softAssert = new SoftAssert();
		
		boolean result = loginOrSingUpPage.verifyVisibilityOfCreateNewAccountPopup();
		Assert.assertEquals(result,true);
		
		result = loginOrSingUpPage.verifyVisibilityOfselectYourPronounField();
		softAssert.assertEquals(result, false);
		
		result = loginOrSingUpPage.verifyIfFemaleRadioIsSelected();
		softAssert.assertEquals(result, false);
		
		result = loginOrSingUpPage.verifyIfMaleRadioIsSelected();
		softAssert.assertEquals(result, false);
		
		result = loginOrSingUpPage.verifyIfCoustomRadioIsSelected();
		softAssert.assertEquals(result, false);
		
		loginOrSingUpPage.clickOnFemale();
		result = loginOrSingUpPage.verifyIfFemaleRadioIsSelected();
		softAssert.assertEquals(result, true);
		
		loginOrSingUpPage.clickOnMale();
		result = loginOrSingUpPage.verifyIfMaleRadioIsSelected();
		softAssert.assertEquals(result, true);
		
		loginOrSingUpPage.clickOnCoustom();
		result = loginOrSingUpPage.verifyIfCoustomRadioIsSelected();
		softAssert.assertEquals(result, true);
		
		result = loginOrSingUpPage.verifyVisibilityOfselectYourPronounField();
		softAssert.assertEquals(result, true);
		
		String text = loginOrSingUpPage.getTextPresentOnSignUpButton();
		softAssert.assertEquals(text, "Sign Up");
		
		softAssert.assertAll();
		
	}
	@AfterMethod
	public void launch() throws IOException
	{
		Utility.captureScreenshot(driver, testID);
		loginOrSingUpPage.clickOnCloseCreateNewAccountPopup();
	}
	
	@AfterClass
	public void clearPOMClassObjectReferences()
	{
		loginOrSingUpPage= null;
	}
	
	@AfterTest
	public void closeTheBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();
	}

}
