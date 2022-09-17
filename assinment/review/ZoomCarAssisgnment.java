package assinment.review;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomCarAssisgnment {


	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.zoomcar.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//div[@class='multiselect__select']")).click();
		driver.findElement(By.xpath("(//li[@class='multiselect__element'])[3]/span/span")).click();

		driver.findElement(By.xpath("(//div[@class='multiselect__select'])[2]")).click();
		driver.findElement(By.xpath("(//span[text()='Chennai'])")).click();

		driver.findElement(By.xpath("//button[@class='city-lightbox__confirm-button']")).click();

		driver.findElement(By.xpath("(//div[@class='tab-content'])[2]//span")).click();

		driver.findElement(By.xpath("//div[@class='ride-time']")).click();

		driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]/td"));

		List<WebElement> columns = driver.findElements(By.tagName("td"));
		for (WebElement cell : columns) {

			if (cell.getText().equals("20")) {
				cell.click();
				break;
			}
		}

		WebElement findElement = driver.findElement(By.xpath("(//div[@class='button-wrapper'])[2]/button"));
		driver.executeScript("arguments[0].scrollIntoView();", findElement);

		driver.executeScript("arguments[0].click();", findElement);

		try {
			driver.findElement(By.xpath("//div[@class='actions']/button")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(2000);
		WebElement findElement2 = driver.findElement(By.xpath("//div[@class='button-wrapper']/button"));
		findElement2.click();

		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='car-name-location ellipsis']"));
		// int size = findElements.size();
		List<String> lis = new ArrayList<String>();
		for (WebElement webElement : findElements) {
			String text = webElement.getText();
			lis.add(text);
		}
		Set<String> set = new TreeSet<String>(lis);
		System.out.println("Car names :   " + set);

		List<WebElement> findElements2 = driver.findElements(By.xpath("//div[@class='price-bar d-f ai-c ta-c']"));
		List<Integer> num = new ArrayList<Integer>();
		for (WebElement webElement1 : findElements2) {
			String text = webElement1.getText();

			String replaceAll = text.replaceAll("[^0-9]", "");

			int parseInt = Integer.parseInt(replaceAll);

			num.add(parseInt);

		}

		Set<Integer> set1 = new TreeSet<Integer>(num);
		System.out.println("Price list :   " + set1);
		List<Integer> lis2 = new ArrayList<Integer>(set1);
		System.out.println("The least value is   " + lis2.get(0));

		
	}

}
