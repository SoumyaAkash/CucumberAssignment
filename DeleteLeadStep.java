package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DeleteLeadStep {
	public ChromeDriver driver;
	@Given ("Open the chrome browser for DeleteLead")
	public void open_the_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}

	@Given("Launch the application Webbrower URL")
	public void launch_the_application_url() {
			driver.get("http://leaftaps.com/opentaps");
		}
	

	@Given("Enter the username as {string} and Enter the password as {string}")
	
		public void enterUsername(String uName , String pwd) {
			driver.findElement(By.id("username")).sendKeys(uName);
			driver.findElement(By.id("password")).sendKeys(pwd);			
		} 
	@When("Press the Login button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@Then("Find the Lead details to be deleted")
	public void EditLeadfunctionality() throws InterruptedException
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

	}
	
	@Then("Delete the Lead with LeadId")
	public void  deleteLead()
	{
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String text = driver.findElement(By.className("x-paging-info")).getText();
	}
	@And("Press Submit Button")	
	public void SubmitButton()
	{
		driver.findElement(By.name("submitButton")).click();
		
	}
	@And ("Close the Browser")
	public void Close()
	{
	driver.close();	
	}
}

	


	
	

