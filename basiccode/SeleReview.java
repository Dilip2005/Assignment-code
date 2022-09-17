package basiccode;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleReview {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.zoomcar.com/in/bangalore");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.className("placeholder")).click();
		driver.findElement(By.xpath("//h3[text()='Suggested Pick Up Locations']/following::div[1]")).click();
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//span[text()='round trip']/following::span")).click();
		driver.findElement(By.xpath("//td[contains(text(),'27')]")).click();		
		driver.findElement(By.xpath("//td[contains(text(),'27')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Find cars')]")).click();
		Thread.sleep(3000);
		String text1=driver.findElement(By.xpath("//h3[text()='Mini Mini Cooper SD Country Man']")).getText();
		System.out.println(text1);
		Thread.sleep(2000);
		String text=driver.findElement(By.xpath("//h3[text()='Mini Mini Cooper SD Country Man']/following::div[14]")).getText();
	System.out.println(text);
	}
	}


