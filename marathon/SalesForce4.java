package marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce4 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Load the url
		driver.get("https://login.salesforce.com/");
		//Maximize the browser
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username and password,click on login button
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		
		//click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		//Switch to the next window using Windowhandle
		Set<String> windows=driver.getWindowHandles();
		List<String> list=new ArrayList<String>(windows);
		driver.switchTo().window(list.get(1));
		
		//click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//Get the title
		System.out.println("Title : "+driver.getTitle());
		
		//Get back to the parent window
		driver.switchTo().window(list.get(0));
		
		//close the browser
		driver.close();
	}

}
