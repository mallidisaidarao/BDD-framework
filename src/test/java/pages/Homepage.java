package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage

{ 
		
	public WebDriver driver;
	 
	@FindBy(name="identifier")
	public WebElement uid;
    
	@FindBy(xpath="//*[text()='Next']")
	public WebElement uidnext;
	
	@FindBy(xpath="//*[contains(text(),'Enter an email')]")
	public WebElement blankiderr;
	
	@FindBy(xpath=("(//*[contains(text(),'find your Google Account')])[2]"))
	public WebElement invaliduiderr;

	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void filluid(String x)
	{
		uid.sendKeys(x);
	}
	public void clickuidnext()
	{
		uidnext.click();
	}
	
	
}

