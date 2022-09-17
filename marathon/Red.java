package marathon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Red {

	public static void main(String[] args)throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();  
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		//Launch the url https://www.redbus.in/
		driver.get("https://www.redbus.in/");
		Thread.sleep(2000);
		
		//Enter From -Madiwala Bangalore
		WebElement from = driver.findElement(By.xpath("//input[@data-message='Please enter a source city']"));
		from.sendKeys("Madiwala Bangalore");
		Thread.sleep(20000);//set the sleep time to 20000
		
		//Handle the Alert
		//Alert alert = driver.switchTo().alert();
		//alert.dismiss();
		
		
		//Enter To Koyambedu Chennai
		WebElement to = driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']"));
		to.sendKeys("Koyambedu Chennai");
		Thread.sleep(20000);
		
		//Select the Date 10-Jun-2022
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.tagName("table"));
		driver.findElement(By.xpath("//td[text()='22']")).click();//select the date that is to be in future
		Thread.sleep(20000);
		
		//Click Search buses
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(20000);
		
		//Click After 6pm under Departure time
		driver.findElement(By.xpath("//label[@for='dtAfter 6 pm'][1]")).click();
		Thread.sleep(20000);
		
		//Click Sleeper under Bus types
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER'][1]")).click();
		Thread.sleep(20000);
		
		//Select the Primo
		driver.findElement(By.xpath("//li[@class='bannerTiles fl'][1]")).click();
		Thread.sleep(20000);
		
		//Get the number of buses found

		List<WebElement> buses = driver.findElements(By.xpath("(//div[contains(@class,'travels lh-24 f-bold d-color')])"));
		driver.executeScript("window.scrollBy(0,1000)");  
		for (WebElement list : buses) {
			
			String text = list.getText();
			System.out.println("Name of Buses:" +text);
			
		}
		

	
		Thread.sleep(20000);
		
		
		//Get the Bus fare and sort them in ascending order
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='fare d-block']//span"));
		for (int i = 0; i < list.size(); i++) {
			String fare = list.get(i).getText();
			System.out.println(fare);
			//list.sort(fare);
			
			}
		
			
		
		
}
	}


