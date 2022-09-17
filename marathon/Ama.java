package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Ama {

		public static void main(String[] args) throws InterruptedException, IOException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://www.amazon.in/");
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
			driver.findElement(By.xpath("//span[text()=' for boys']/parent::div")).click();
			String text = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[1]")).getText();
			String text2 = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[3]")).getText();
			System.out.println(text+text2);
			driver.findElement(By.xpath("(//span[text()='American Tourister'])[3]")).click();
			String text3 = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[1]")).getText();
			String text4 = driver.findElement(By.xpath("(//span[text()='\"bags for boys\"'])")).getText();
			System.out.println(text3+text4);
			driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
			driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
			String bagName = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).getText();
			System.out.println(bagName);
			String discountPrice = driver.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[1]")).getText();
			System.out.println(discountPrice);
			driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			  List<String>bag = new ArrayList<String>(windowHandles);
			driver.switchTo().window(bag.get(1));
			String price = driver.findElement(By.xpath("(//span[text()='₹1,099.00'])[2]")).getText();
			System.out.println(price);
			if(discountPrice.contains("₹1,099")) {
				System.out.println("verified");
			}else {
				System.out.println("not verified");
			}
//			Thread.sleep(5000);
//			 File screenshotAs = driver.getScreenshotAs(OutputType.FILE);//method used to take Screenshot
//			    File target = new File("./report/img.png");	//set the storage path
//			    FileUtils.copyFile(screenshotAs, target);//link the source and target files
//			    System.out.println("CLICKED SNAPSHOT");
			    driver.close();
			
			
			
			
		
			
			    
		}
	}

