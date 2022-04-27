package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurityAndLoginSettingsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	

	@FindBy(xpath="//span[text()='Change password']")
	private WebElement changePassword;
	
	@FindBy(xpath="//input[@id='password_old']")
	private WebElement currentPassword;
	
	@FindBy(xpath="//input[@id='password_new']")
	private WebElement newPassword;
	
	@FindBy(xpath="//input[@id='password_confirm']")
	private WebElement retypeNewPassword;
	
	@FindBy(xpath="(//input[@value='Save changes'])[1]")
	private WebElement saveChanges;
	
	@FindBy(xpath="//button[text()='Close']")
	private WebElement closeChangePasswordWindow;
	
	
	
	public SecurityAndLoginSettingsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
		wait = new WebDriverWait(driver,20);
	}
	
	public void clickOnChangePassword()
	{
		//wait.until(ExpectedConditions.visibilityOf(changePassword));
		changePassword.click();
	}
	
	public void sendCurrentPassword()
	{
		currentPassword.sendKeys("1234");
	}
	
	public void sendNewPassword()
	{
		newPassword.sendKeys("4567");
	}
	
	public void resendNewPasswordToConfirm()
	{
		retypeNewPassword.sendKeys("1234");
	}
	public void clickOnSaveChanges()
	{
		currentPassword.click();
	}
	public void clickOnCloseChangePasswordWindow()
	{
		closeChangePasswordWindow.click();
	}
	
	
}
