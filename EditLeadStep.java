package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class EditLeadStep {
	public ChromeDriver driver;
	@Given("Open the chrome browser")
	public void open_the_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}

	@Given("Launch the application url")
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
	
	@Then("Edit Lead Functionality")
	public void EditLeadfunctionality() throws InterruptedException
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
	}
	
	@And("Edit Company Name as 'Capgemini'")
	public void  EditCompanyName()
	{
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Capgemini");
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

	


	
	

