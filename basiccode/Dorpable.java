package basiccode;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dorpable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();


		driver.get("http://www.leafground.com/pages/Dropdown.html");

		WebElement dd =  driver.findElement(By.xpath("//div[@class='example'][6]//select"));
		Select dd1= new Select(dd);
		List<WebElement> options = dd1.getOptions();
	for (int i =0; i <=options.size()-1; i++) {
		if( i==1||i==2) {
		
		options.get(i).click();
			}
		}
		List<String> list = new ArrayList<String>();
	for (WebElement each : options) {
			String text3= each.getText();
		list.add(text3);
		
			
		}
		
	   System.out.println(list);	
		
	}

}
