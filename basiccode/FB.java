package basiccode;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class FB { 
	
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.edgedriver().setup();
	EdgeDriver driver = new EdgeDriver();
	//Load the url
	driver.get("https://login.salesforce.com/");
	//Maximize the browser
	driver.manage().window().maximize();
	//implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//Enter the username and password,click on login button
	driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Password#123");
	driver.findElement(By.id("Login")).click();
	
	//click on the learn more option in the Mobile publisher
	driver.findElement(By.xpath("//span[text()='Learn More']")).click();
	
	//Switch to the next window using Windowhandle
	Set<String> windows=driver.getWindowHandles();
	List<String> list=new ArrayList<String>(windows);
	driver.switchTo().window(list.get(1));
	
	//click on the confirm button in the redirecting page
	driver.findElement(By.xpath("//button[text()='Confirm']")).click();
	//Click Resources and mouse hover on Learning On Trailhead
	Shadow dom=new Shadow(driver);
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement learning=dom.findElementByXPath("//span[text()='Learning']");
	wait.until(ExpectedConditions.visibilityOf(learning));
	learning.click();
	WebElement learn=dom.findElementByXPath("//span[text()='Learning on Trailhead']");
	wait.until(ExpectedConditions.visibilityOf(learn));
	
	Actions builder=new Actions(driver);
	
	builder.moveToElement(learn).perform();
	//Click on Salesforce Certifications
	WebElement certificate=dom.findElementByXPath("//a[text()='Salesforce Certification']");
	Actions builder1=new Actions(driver);
	builder1.scrollToElement(certificate).perform();
	certificate.click();
	//Choose Your Role as Salesforce Architect
	driver.findElement(By.xpath("//div[text()='Architect']")).click();
	
	//Get the Text(Summary) of Salesforce Architect
	String textSummary=driver.findElement(By.xpath("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']")).getText();
	System.out.println("Text(Summary) of Salesforce Architect : "+textSummary);
	
	//Get the List of Salesforce Architect Certifications Available
	List<WebElement> certifications=driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
	System.out.println("List of Salesforce Architect Certifications Available : ");
	for(int i=0;i<certifications.size();i++)
	{
		String architectCertifications=certifications.get(i).getText();
		System.out.println(architectCertifications);
	}
	//Click on Application Architect
	driver.findElement(By.linkText("Application Architect")).click();
	
	//Verify the page displays Application Architect
	String head=driver.findElement(By.xpath("//div[@class='certification-banner_title slds-container--medium slds-container--center slds-text-align--center']")).getText();
	System.out.println("Page heading is "+head);
   
}
}
