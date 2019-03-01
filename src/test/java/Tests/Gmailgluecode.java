package Tests;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Composepage;
import pages.Homepage;
import pages.Loginpage;

public class Gmailgluecode 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public Homepage hp;
	public Loginpage lp;
	public Composepage cp;
	public Scenario s;
	public Properties p;
	
	@Before
	public void method1(Scenario s) throws Exception
	{
		this.s=s;
		File f=new File("F:\\Selenium\\bddtestinggamil\\src\\test\\resources\\gmailproperties.properties");
		FileReader fr=new FileReader(f);
		p=new Properties();
		p.load(fr);
	}
	@Given("^launch site$")
	public void method2()
	{
		System.setProperty("webdriver.chrome.driver",p.getProperty("Cdpath"));
		driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		hp=new Homepage(driver);
		lp=new Loginpage(driver);
		cp=new Composepage(driver);
	    wait=new WebDriverWait(driver,20);
	    driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOf(hp.uidnext));
	}
	@Then("^title should be \"(.*)\"$")
	public void method3(String et)
	{
		
		    String at=driver.getTitle();
		      if(at.equalsIgnoreCase(et))
	        	{
			     s.write("gmail test passed");
		        }
		      
		else
		{
			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b,"Gmail title test failed");
			Assert.fail();
		}
	}
	
	       @When("enter uid as \"(.*)\"$")
	       public void method4(String x)
	{
		   hp.filluid(x);
	}
	      @And("^click uid next button$")
	       public void method5() throws Exception
	{
	    Thread.sleep(2000);
	    	   wait.until(ExpectedConditions.elementToBeClickable(hp.uidnext));
		   hp.clickuidnext();
		   Thread.sleep(5000);
	}
	       @Then ("^Check uid outcome with \"(.*)\" Criteria$")
	       public void method6(String c)
	{  
	    	try
	    	{
	    		if(c.equalsIgnoreCase("uid_blank")&& hp.blankiderr.isDisplayed())
	    		{
	    			s.write("Blank uid test passed");
	    		}
	    		else if(c.equalsIgnoreCase("uid_invalid")&& hp.invaliduiderr.isDisplayed())
	    		{
	    			s.write("invalid uid test passed");
	    		}
	    		else if(c.equalsIgnoreCase("uid_valid")&&lp.pwd.isDisplayed())
	    		{
	    			s.write("valid uid test passed");
	    		}
	    		else
	    		{
	    			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    			s.embed(b, "uid testfailed");
	    			Assert.fail();
	    		}
	    	}
	    	catch(Exception ex)
	    	{
	    		s.write(ex.getMessage());
	    		Assert.fail();
	    	}
	      }
	       @And("^enter pwd as \"(.*)\"$")
	       public void method7(String x)
	       {
	    	   lp.fillpwd(x);
	       }
	       
	       @And("^click pwd next button$")
	    public void method8() throws Exception
	{
		  lp.clicknextbtn();
		  Thread.sleep(5000);
	}
	 
	       @Then("^check pwd outcome with \"(.*)\" Criteria$")
	       public void method10(String c)
	       {
	    	   try
	    	   {
	    		   if(c.equalsIgnoreCase("pwd_blank")&&lp.blankpwderr.isDisplayed())
	    		   {
	    			   s.write("Blank pwd test passed");
	    		   }
	    		   else if(c.equalsIgnoreCase("invalid")&&lp.wrongpwderr.isDisplayed())   
	    		   {
	    			   s.write("invalid pwd test passed");
	    		   }
	    		   else if(c.equalsIgnoreCase("pwd_valid")&&cp.comp.isDisplayed())
	    		   {
	    			 s.write("valid pwd test passed");
	    			 cp.profilepic.click();
	    			 wait.until(ExpectedConditions.elementToBeClickable(cp.signout));
	    		   }
	    		   else
	    		   {
	    			   byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    			   s.embed(b, "pwd test failed");
	    			   Assert.fail();
	    		   }
	    	   }
	    	   catch(Exception ex)
	    	   {
	    		   s.write(ex.getMessage());
	    		   
	    		    }
	       }
	       @And ("^click Compose and sendmail$")
	       public void method11(DataTable dt)
	       {
	    	   List<List<String>> data=dt.asLists(String.class);
	    	   for(int i=1;i<data.size();i++)
	    	   {
	    		   cp.clickcomp();
	    		   wait.until(ExpectedConditions.visibilityOf(cp.clickto));
	    		   String t=data.get(i).get(0);
	    		   String sub=data.get(i).get(1);
	    		   String b=data.get(i).get(2);
	    		   cp.fillto(t);
	    		   wait.until(ExpectedConditions.visibilityOf(cp.subj));
	    		   cp.fillsubject(sub);
	    		   wait.until(ExpectedConditions.visibilityOf(cp.body));
	    		   cp.fillbody(b);
	    		   wait.until(ExpectedConditions.visibilityOf(cp.send));
	    		   cp.clicksend();
	    		   try
	    		   {
	    			   wait.until(ExpectedConditions.visibilityOf(cp.sendmsg));
	    			   s.write("compose test passed");
	    		   }
	    		   catch(Exception ex)
	    		   {
	    			   s.write("compose test failed");
	    		   }
	    	   } 
	    	   wait.until(ExpectedConditions.visibilityOf(cp.profilepic));
	    	   cp.profilepic();
	    	   wait.until(ExpectedConditions.visibilityOf(cp.signout));
	    	   cp.signout();
	       }
           
	       @When ("^close site$")
	       public void close()
	       {
	    	   driver.close();
	       }
              
}