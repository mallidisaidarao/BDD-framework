package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	public WebDriver diver;
	
	@FindBy(xpath="//*[@name='password']")
	public WebElement pwd;
	
	@FindBy(xpath="//*[text()='Next']")
	public WebElement nextbtn;
	
	@FindBy(xpath="//*[text()='Enter a password']")
	public WebElement blankpwderr;
	
	@FindBy(xpath="(//*[contains(text(),'Try again')])[2]")
	public WebElement wrongpwderr;
	  
	public Loginpage(WebDriver driver)
	{
		this.diver=driver;
		PageFactory.initElements(driver,this);
	}
    
	public void fillpwd(String x)
	{
		pwd.sendKeys(x);
	}
	public  void clicknextbtn()
	{
		nextbtn.click();
	}
	
}
