package pom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

public class LoginOrSingUpPage {
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailAddressOrPhoneNumber;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement login;
	
	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement forgottenPassword;
	
	@FindBy(xpath="//a[contains(@data-testid,'open-registration-form')]")
	private WebElement createNewAccount;
	
	@FindBy(xpath="//div[text()='Sign Up']")
	private WebElement createNewAccountPopupTitle;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement surname;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	private WebElement mobileNumberOrEmailAddress;
	
	@FindBy(xpath="//input[@id='password_step_input']")
	private WebElement newPassword;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement day;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement month;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement year;
	
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement female;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	private WebElement male;
	
	@FindBy(xpath="(//input[@type='radio'])[3]")
	private WebElement coustom;
	
	@FindBy(xpath="//select[@name='preferred_pronoun']")
	private WebElement selectYourPronoun;
	
	@FindBy(xpath="//button[@name='websubmit']")
	private WebElement signUp;
	
	@FindBy(xpath="//img[@class='_8idr img']")
	private WebElement closeCreateNewAccountPopup;
	
	
	
	public LoginOrSingUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void sendEmailAddressOrPhoneNumber(String username)
	{
		emailAddressOrPhoneNumber.sendKeys(username);
	}
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void clickOnForgottenPassword()
	{
		forgottenPassword.click();
	}
	
	public void clickOnCreateNewAccount()
	{
		createNewAccount.click();
	}
	
	public boolean verifyVisibilityOfCreateNewAccountPopup()
	{
		boolean result = createNewAccountPopupTitle.isDisplayed();
		return result;
	}
	
	public void sendFirstName()
	{
		firstName.sendKeys("Dhananjay");
	}
	
	public void sendSirName()
	{
		surname.sendKeys();
	}
	
	public void sendMobileNumberOrEmailAddress()
	{
		mobileNumberOrEmailAddress.sendKeys("5555555555");
	}
	
	public void sendNewPassword()
	{
		newPassword.sendKeys("Velocity");
	}
	
	public void enterDateOfBirth()
	{
		day.sendKeys("28");
		month.sendKeys("April");
		year.sendKeys("1997");
	}
	
	public boolean verifyIfMaleRadioIsSelected()
	{
		boolean result = male.isSelected();
		return result;
	}
	
	public boolean verifyIfFemaleRadioIsSelected()
	{
		boolean result = female.isSelected();
		return result;
	}
	
	public boolean verifyIfCoustomRadioIsSelected()
	{
		boolean result = coustom.isSelected();
		return result;
	}
	public void clickOnMale()
	{
		male.click();
	}
	
	public void clickOnFemale()
	{
		female.click();
	}
	
	public void clickOnCoustom()
	{
		coustom.click();
	}
	
	public boolean verifyVisibilityOfselectYourPronounField()
	{
		boolean result = selectYourPronoun.isDisplayed();
		return result;
	}
	
	public void selectPronoun()
	{
		Select sel = new Select(selectYourPronoun);
		sel.selectByValue("2");
	}
	
	public void clickOnSingUp()
	{
		signUp.click();
	}
	
	public void clickOnCloseCreateNewAccountPopup()
	{
		closeCreateNewAccountPopup.click();
	}
	
	public String getMessageDisplayedOnEmailAddressOrPhoneNumberFeild()
	{
		String message = emailAddressOrPhoneNumber.getAttribute("placeholder");
		return message;
	}
	
	public String getMessageDisplayedOnPasswordFeild()
	{
		String message = password.getAttribute("placeholder");
		return message;
	}
	
	public String getTextPresentOnLoginButton()
	{
		String text = login.getText();
		return text;
	}
	
	public String getTextPresentOnCreateNewAccountButton()
	{
		String text = createNewAccount.getText();
		return text;
	}
	
	public String getTextPresentOnSignUpButton()
	{
		String text = signUp.getText();
		return text;
	}
	
	

}
