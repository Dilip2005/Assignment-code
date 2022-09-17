package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class opparSalesforce {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Login to https://login.salesforce.com
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys(" Password#123");
		driver.findElement(By.id("Login")).click();

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// Click view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// click Sales from App Launcher
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//Click on Opportunity tab 
		
		WebElement findElement = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", findElement);
		Thread.sleep(3000);
		//Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		//Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it (Elder to younger sibling I taken)
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("i am tester");
		
		//Get the text and Store it 
		
		 String text = driver.findElement(By.xpath("//input[@name='Name']")).getText();
		System.out.println(text);
		
		//Choose close date as Today
	
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("07/30/2022",Keys.ENTER);
		
		
		//Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input-value')]")).click();
		
		Thread.sleep(3000);
		
		
		WebElement findElement2 = driver.findElement(By.xpath("(//span[@class='slds-media__body'])[4]/span"));
		driver.executeScript("arguments[0].click();", findElement2);
		//click Save
		driver.findElement(By.xpath("//button[contains(@class,'button_brand')]")).click();
		
		
		String attribute = driver.findElement(By.xpath("//span[contains(@class,'toastMessage ')]/a")).getAttribute("title");
		
		System.out.println(attribute);
		if(attribute.contains("i am tester")){
			System.out.println("Verified");
		}
		else {
			System.out.println("Not verified");
		}
		
	}

	}

