package pageobj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class orhr {
WebDriver driver;
	
	
	private By uname=By.id("txtUsername");
	private By pass=By.id("txtPassword");
	private By login=By.id("btnLogin");
	private By viewpim=By.xpath("//*[@id='menu_pim_viewPimModule']/b");
	private By config=By.xpath("//*[@id='menu_pim_Configuration']");
	private By save=By.id("btnSave");
	private By name=By.className("ac_input");
	
	public orhr(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void login(String username,String password) throws InterruptedException
	{
		
		 driver.findElement(uname).sendKeys(username);
			driver.findElement(pass).sendKeys(password);
			driver.findElement(login).click();
			 System.out.println("loginsuccessful");
			
	}
	
	public void pimmodule() throws InterruptedException
	{
		driver.findElement(uname).sendKeys("Admin");
		driver.findElement(pass).sendKeys("admin123");
		driver.findElement(login).click();
		driver.findElement(viewpim).click();
		 System.out.println(driver.getTitle());
		 System.out.println("admin is in pim module");
			
	}
	public void configuration() throws InterruptedException
	{
		driver.findElement(config).click();	
		 System.out.println("admin selects configuration field");
	}
	
	public void optionalfield() throws InterruptedException
	{
		driver.findElement(config).click();
		driver.findElement(By.xpath("//*[@id='menu_pim_configurePim']")).click();
		driver.findElement(save).click();
		driver.findElement(save).click();
		
		
	}
	public void customfield(String fieldname) throws InterruptedException
	{
		driver.findElement(config).click();
		driver.findElement(By.xpath("//*[@id='menu_pim_listCustomFields']")).click();	
		driver.findElement(By.id("buttonAdd")).click();
		WebElement a=driver.findElement(By.id("customField_name"));
		a.sendKeys(fieldname);
		WebElement screen=driver.findElement(By.id("customField_screen"));
		Select s=new Select(screen);
		s.selectByIndex(1);
		WebElement type=driver.findElement(By.id("customField_type"));
		Select t=new Select(type);
		t.selectByIndex(1);
		driver.findElement(save).click();
	}
	public void view(String employeename,String empid) throws InterruptedException
	{
		
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		Thread.sleep(1000);
		WebElement b=driver.findElement(name);
		b.sendKeys(employeename);
		WebElement c=driver.findElement(By.id("empsearch_id"));
		c.sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
	}
	public void add(String empname,String employeeid) throws InterruptedException
	{
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(300);
		WebElement b=driver.findElement(By.id("firstName"));
		b.sendKeys(empname);
		WebElement d=driver.findElement(By.id("lastName"));
		d.sendKeys(empname);
		WebElement c=driver.findElement(By.xpath("//*[@id='employeeId']"));
		c.sendKeys(employeeid);
		driver.findElement(save).click();
	}
	
	public void report(String report) throws InterruptedException
	{
		
		driver.findElement(By.id("menu_core_viewDefinedPredefinedReports")).click();
		WebElement d=driver.findElement(By.id("search_search"));
		d.sendKeys(report);
		driver.findElement(By.xpath("//*[@id='searchForm']/fieldset/p/input[1]")).click();
		
     }
}


