package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("-disable-notiofications");
		ChromeDriver driver=new ChromeDriver(option);  
		
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password$123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(2000);

		WebElement click = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();",click);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("S.Manoj Kumar",Keys.ENTER);
Thread.sleep(3000);
//driver.findElement(By.xpath("//div[contains(@class,'forceVirtualActionMarker')][1]")).click();

WebElement click2 = driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody/tr/td[6]"));
driver.executeScript("arguments[0].click();", click2);
Actions act=new Actions(driver);
act.moveToElement(click2).perform();
Thread.sleep(2000);




	}

}
