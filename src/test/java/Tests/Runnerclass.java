package Tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"F:\\Selenium\\bddtestinggamil\\src\\test\\resources\\gmailresources"},
		tags={},
		monochrome=true,plugin={"pretty","html:target\\gmailsmoketestres"})

public class Runnerclass
{

}