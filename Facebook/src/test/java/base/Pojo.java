package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Pojo {
	
	public WebDriver lauchChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Software Testing\\Chrome\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    return driver;
	}
	
	public WebDriver lauchFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Software Testing\\firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public WebDriver lauchEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver", "F:\\Software Testing\\edge\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}

}
