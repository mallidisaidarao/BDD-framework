package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Composepage 
{
	
	public WebDriver driver;
	@FindBy(xpath="//*[text()='Compose']")	public WebElement comp;
	@FindBy(name="to") public WebElement clickto;
	@FindBy(name="subjectbox")public WebElement subj;
	@FindBy(xpath="(//*[@aria-label='Message Body'])[2]") public WebElement body;
	@FindBy(xpath="//*[contains(@data-tooltip,'Send')]")  public WebElement send;
	@FindBy(xpath="//*[text()='Message sent.']") public WebElement sendmsg;
	@FindBy(xpath="//*[contains(@aria-label,'Google Account')]") public WebElement profilepic;
	@FindBy(xpath="//*[text()='Sign out']") public WebElement signout;
	public Composepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickcomp()
	{
		comp.click();
	}
	public void fillto(String x)
	{
		clickto.sendKeys(x);
	}
	public void fillsubject(String x)
	{
		subj.sendKeys(x);
	}
	public void fillbody(String x)
	{
		body.sendKeys(x);
	}
	public void clicksend()
	{
		send.click();
	}
	public void profilepic()
	{
		profilepic.click();
	}
	public void signout()
	{
		signout.click();
	}
	

}
