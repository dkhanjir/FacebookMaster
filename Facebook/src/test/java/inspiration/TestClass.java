package inspiration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.ApplicationHeaderPage;
import pom.LoginOrSingUpPage;
import pom.SecurityAndLoginSettingsPage;
import pom.ApplicationHomePage;
import pom.SettingsPage;
import util.Utility;
public class TestClass {

	public static void main (String []args) throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Software Testing\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		LoginOrSingUpPage loginOrSingUpPage = new LoginOrSingUpPage(driver);
		
		String username = Utility.getData("credentials",1,1);
		String password = Utility.getData("credentials",1,2);
		
		loginOrSingUpPage.sendEmailAddressOrPhoneNumber(username);
		loginOrSingUpPage .sendPassword(password);
		loginOrSingUpPage .clickOnLogin();
		

		
	
		ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage(driver);
		
		applicationHeaderPage.clickOnMessenger();

		ApplicationHomePage applicationHomePage = new ApplicationHomePage(driver);
		
		applicationHomePage.sendFriendName();
		
		applicationHomePage.clickOnFirstResult();
	
		applicationHomePage.typeMessege();
	
		applicationHomePage.clickOnSendMessageButton();
	
		applicationHomePage.clickOnCloseChatWindow();
		
		
		

		applicationHeaderPage.clickOnAccount();
		
		applicationHomePage.clickOnSettingsAndprivacy();
		
		applicationHomePage.clickOnSettings();
		
		SettingsPage settingsPage = new SettingsPage(driver);
		
		settingsPage.clickOnSecurityAndLogin();
		
		Thread.sleep(5000);
		
		settingsPage .clickOnSwitchToIframe();
		
		SecurityAndLoginSettingsPage securityAndLoginSettingsPage = new SecurityAndLoginSettingsPage(driver);
		
		securityAndLoginSettingsPage.clickOnChangePassword();
		
		securityAndLoginSettingsPage.sendCurrentPassword();
		
		securityAndLoginSettingsPage .sendNewPassword();
		
		securityAndLoginSettingsPage.resendNewPasswordToConfirm();
		
		securityAndLoginSettingsPage.clickOnSaveChanges();
		
		securityAndLoginSettingsPage.clickOnCloseChangePasswordWindow();
		
		//Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
		
		
		applicationHeaderPage.clickOnAccount();
		
		applicationHomePage.clickOnLogOut();
		
		Alert alt= driver.switchTo().alert();
	
		
		alt.accept();
		
	}
}
