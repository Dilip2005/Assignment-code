package marathon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Bangalore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Koyambedu, Chennai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
	driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[6]/td[5]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		List<WebElement> buses = driver.findElements(By.xpath("(//div[contains(@class,'travels lh-24 f-bold d-color')])"));
		driver.executeScript("window.scrollBy(0,1000)");  
		for (WebElement list : buses) {
			
			String text = list.getText();
			System.out.println("Name of Buses:" +text);
			
		}
		
	}
	


}
