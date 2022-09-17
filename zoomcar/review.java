package zoomcar;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.http.message.BasicListHeaderIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.io.IOException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class review {

		
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//01) Launch Zoomcar.com
		driver.get("https://www.zoomcar.com/in");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//02) Select the country, city and confirm
		driver.findElement(By.xpath("//div[@class='multiselect__tags']")).click();
		driver.findElement(By.xpath("//span[text()='India']")).click();
		Thread.sleep(5000);    
		driver.findElement(By.xpath("(//div[@class='multiselect__tags'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Chennai']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		Thread.sleep(5000);
		//03) Click Airport round trip is selected
		driver.findElement(By.xpath("//span[text()='Airport Round Trip']")).click();
		//04) Click pick up city
		driver.findElement(By.xpath("//div[@class='field field-address']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Current Location')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='field field-address']")).click();
		//08) Select location on Map
		driver.findElement(By.xpath("//div[text()='Select Location on Map']")).click();   
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		WebElement mapMarker = driver.findElement(By.xpath("//img[@src='/img/icons/ic_pin.png']"));
		Thread.sleep(3000); //observe the current location ,after 3 seconds location marker will be moved to new location
		/*All the below will change the location moving the marker */
		builder.moveToElement(mapMarker).click().keyDown(Keys.HOME).dragAndDropBy(mapMarker,567, 255).perform(); 
		// builder.moveToElement(mapMarker).clickAndHold().keyDown(Keys.END). release().dragAndDropBy(mapMarker,550, 108).perform();
		// builder.moveToElement(mapMarker).clickAndHold().keyDown(Keys.PAGE_DOWN). release().dragAndDropBy(mapMarker,600,100).perform();
			}

		
		

			

		
		
	

}