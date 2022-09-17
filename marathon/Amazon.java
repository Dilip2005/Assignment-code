package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
	Thread.sleep(2000);
	
	//driver.findElement(By.xpath("(//span[text()=' for boys'])[2]")).click();    
Thread.sleep(4000);
		String text = driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText();
		if(text.equals("1-48 of over 30,000 results for")) {
			System.out.println("Text Matched"+text+"Bags for boys");
		}else {
			System.out.println("Not Matched");
		}
		Thread.sleep(2000);
	driver.findElement(By.xpath("(//span[text()='American Tourister'])[3]")).click();
	//driver.findElement(By.xpath("//li[@id='p_89/American Touriste']/span/a/div/label/i")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[@id='p_89/Generic']/span/a/span")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Featured']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
	
	driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base')])[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("submit.add-to-cart")).click();
	
			
	}

}
