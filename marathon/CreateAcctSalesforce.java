package marathon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAcctSalesforce {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);

		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password#123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(2000);

		WebElement clc = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", clc);

//		WebElement click = driver.findElement(By.xpath("//span[text()='Accounts']"));
//		driver.executeScript("arguments[0].click();",click);
		
		 
		  WebElement click1 =
		  driver.findElement(By.xpath("(//a[@class='forceActionLink'])[1]"));
		  driver.executeScript("arguments[0];",click1);
		  driver.findElement(By.xpath("//div[text()='New']")).click();
		 
		  driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Dilip");
		 
		  Thread.sleep(5000); WebElement click4 = driver.findElement(By.xpath( "(//button[contains(@class,'slds-combobox__input-value')])[3]"));
		  driver.executeScript("arguments[0].click();", click4); 
		  Thread.sleep(3000);
		 driver.findElement(By.xpath("(//span[text()='Public'])[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		  Thread.sleep(5000); 
		  String attribute = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]/a")).getAttribute("title");
		  System.out.println(attribute);
		if (attribute.contains("Test")) {
			 System.out.println("verfied");
			 }else {
		 System.out.println("not verfied"); }
		 
	}

}
