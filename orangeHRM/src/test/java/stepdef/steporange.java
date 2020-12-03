package stepdef;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageobj.orhr;


public class steporange {
	WebDriver driver;
	orhr p;
	static int count;
	 String str1 = "OrangeHRM";
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
     
         
        
	}
	@After
	public void teardown()
	{
	driver.close();	
	}
	
	
	 @Given("^User login succesfully and is in PIM module$")
	    public void user_login_succesfully_and_is_in_pim_module() throws Throwable {
		 p=new orhr(driver);
		 p.pimmodule();
	    }

	    @When("^User enters (.+) and password (.+) and clicks on PIM$")
	    public void user_enters_and_password_and_clicks_on_pim(String username, String password) throws Throwable {
	    	 p=new orhr(driver);
	       p.login(username, password);
	       System.out.println("admin logn is succesful with"+username+password);
	    }

	    @When("^admin select the option configuration he is able to edit and save the modified optional fields$")
	    public void admin_select_the_option_configuration_he_is_able_to_edit_and_save_the_modified_optional_fields() throws Throwable {
	    	 p.configuration();
		       p.optionalfield();
		      
		     Assert.assertEquals(str1,driver.getTitle()); 
		     System.out.println("admin select option fields successfully");
	    }

	 
	    @When("^admin select the option configuration and type the field name to be added(.+) and select screen and type and verify$")
	    public void admin_select_the_option_configuration_and_type_the_field_name_to_be_added_and_select_screen_and_type_and_verify(String fieldname) throws Throwable {
	    	p.configuration();
	    	p.customfield(fieldname);
	    	 Assert.assertEquals(str1,driver.getTitle());  
	    	System.out.println("admin added field name succcesfully"+fieldname);
	    }

	    @When("^admin select the option Employee List enter the name of employee(.+)and enter the id of employee(.+)and verify$")
	    public void admin_select_the_option_employee_list_enter_the_name_of_employeeand_enter_the_id_of_employeeand_verify(String employeename, String empid) throws Throwable {
	    	 
	    	p.view(employeename, empid);
	    	 Assert.assertEquals(str1,driver.getTitle());  
	    	System.out.println("admin view employee name"+employeename+"and "+empid+"succcesfully");
	    }

	    @When("^admin select the option  Add Employee enter the name of employee(.+)and enter the id of employee(.+) and verify$")
	    public void admin_select_the_option_add_employee_enter_the_name_of_employeeand_enter_the_id_of_employee_and_verify(String empname, String employeeid) throws Throwable {
	    	p.add(empname, employeeid);
	    	 Assert.assertEquals(str1,driver.getTitle());  
	    	System.out.println("admin add employee name"+empname+"and "+employeeid+"succcesfully");
	    }

	    @When("^admin select the option report and enter the name of report to be generated(.+) and view the generated report$")
	    public void admin_select_the_option_report_and_enter_the_name_of_report_to_be_generated_and_view_the_generated_report(String report) throws Throwable {
	    	
	    	p.report(report);
	    	 Assert.assertEquals(str1,driver.getTitle());  
	    	System.out.println("the generated report is"+report);
	    }

	    @Then("^Admin isin PIM module$")
	    public void admin_isin_pim_module() throws Throwable {
	    	 Assert.assertEquals(str1,driver.getTitle());  
	      System.out.println("admin is in pim module");
	     
	    }

	   
}

