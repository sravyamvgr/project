package testrunner;
import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;


	

	@CucumberOptions(
			features="feature/orangeHRM.feature"
			,glue= {"stepdef"}
		
			)
	public class tesrtngrunner extends AbstractTestNGCucumberTests{

	}


