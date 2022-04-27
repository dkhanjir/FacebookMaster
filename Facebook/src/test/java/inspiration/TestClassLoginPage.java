package inspiration;

import java.io.IOException;

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


public class TestClassLoginPage extends Pojo {
	
	private WebDriver driver;
	private LoginOrSingUpPage loginOrSingUpPage;
	private SoftAssert softAssert;
	private String testID;
	
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
	}
	
	@Test
	public void verifyLoginPage()
	{
		testID = "LP101";
		softAssert = new SoftAssert();
		
		String title = driver.getTitle();
		Assert.assertEquals(title,"Facebook – log in or sign up");
		
	    softAssert = new SoftAssert();
		String message= loginOrSingUpPage.getMessageDisplayedOnEmailAddressOrPhoneNumberFeild();
	    softAssert.assertEquals(message,"Email address or phone number");
	    
	    message = loginOrSingUpPage.getMessageDisplayedOnPasswordFeild();
	    softAssert.assertEquals(message,"Password");
	    
	    message= loginOrSingUpPage.getTextPresentOnLoginButton();
	    softAssert.assertEquals(message,"Log In");
		
	    message= loginOrSingUpPage.getTextPresentOnCreateNewAccountButton();
	    softAssert.assertEquals(message,"Create New Account");
	    
	    softAssert.assertAll();
		
	}
	
	@Test
	public void verifyForgettenPasswordButton() throws InterruptedException 
	{
		testID = "LP102";
	    loginOrSingUpPage.clickOnForgottenPassword();
	    Thread.sleep(3000);
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url,"https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");
		Assert.assertEquals(title,"Forgotten Password | Can't Log In | Facebook");
	}
	
	@AfterMethod
	public void launch() throws IOException
	{
		Utility.captureScreenshot(driver,testID);
	}
	
	@AfterClass
	public void clearPOMClassObjectReferences()
	{
		loginOrSingUpPage=null;
	}
	
	@AfterTest
	public void closeTheBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();
	}

}
