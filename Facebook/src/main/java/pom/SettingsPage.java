package pom;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class SettingsPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//span[text()='Security and Login']")
	private WebElement securityAndLogin;
	
	@FindBy(xpath="(//html[@id='facebook']//iframe)[1]")
	private WebElement iframe;
	
	public SettingsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnSecurityAndLogin()
	{
		securityAndLogin.click();
	}
	
	public void clickOnSwitchToIframe()
    {
	    driver.switchTo().frame(iframe);
	}
	

}
