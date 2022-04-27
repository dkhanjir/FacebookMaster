package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationHomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//span[text()='Settings & privacy']")
	private WebElement settingsAndPrivacy;
	
	@FindBy(xpath="//span[text()='Settings']")
	private WebElement settings;
	
	@FindBy(xpath="//input[@placeholder='Search Messenger']")
	private WebElement searchMessenger;
	
	@FindBy(xpath="(//ul[@role='listbox']//a)[1]")
	private WebElement selectFirstResult;
	
	@FindBy(xpath="//p[@class='kvgmc6g5 oygrvhab']")
	private WebElement enterMessegeFeild;
	
	@FindBy(xpath="//div[@aria-label='Press enter to send']")
	private WebElement sendMessegeButton;
	
	@FindBy(xpath="//div[@aria-label='Close chat']")
	private WebElement closeChatWindow;
	
	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logOut;
	
	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logOut1;
	
	public ApplicationHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver= driver;
		wait = new WebDriverWait(driver, 20);
		
	}
	
	public void sendFriendName()
	{
		searchMessenger.sendKeys("Akash Pandey");
	}
	
	public void clickOnFirstResult()
	{
		wait.until(ExpectedConditions.visibilityOf(selectFirstResult));
		selectFirstResult.click();
	}
	
	public void typeMessege()
	{
		enterMessegeFeild.sendKeys("Hello");
	}
	
	public void clickOnSendMessageButton()
	{
		sendMessegeButton.click();
	}
	
	public void clickOnCloseChatWindow()
	{
		closeChatWindow.click();
	}
	
	public void clickOnSettingsAndprivacy()
	{
		settingsAndPrivacy.click();
	}

	public void clickOnLogOut()
	{
		logOut.click();
	}
	
	public void clickOnSettings()
	{
		settings.click();
	}
	
	
}
