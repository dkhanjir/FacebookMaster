package pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeaderPage {
	
	@FindBy(xpath="(//div[@aria-label='Messenger'])[1]")
	private WebElement messenger;
	
	@FindBy(xpath="//div[@aria-label='Account']")
	private WebElement account;
	

	

	public ApplicationHeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAccount()
	{
		account.click();
	}
	
	public void clickOnMessenger()
	{
		messenger.click();
	}

}
