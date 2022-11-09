package swaqwebsite;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Homepage {

	public static void main(String[] args) throws InterruptedException {
		
	       System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
	       WebDriver driver = new ChromeDriver();
	       
          driver.get("https://www.saucedemo.com/");
	       
	       String user_name = "standard_user";
	       String pass_word = "secret_sauce";

	       driver.get("https://www.saucedemo.com/");
	       driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(user_name);
	       Thread.sleep(1000);
	       driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass_word);
	       driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	       
	       List<WebElement> addToCart = driver.findElements(By.className("btn"));
	       for(int i = 0 ; i<addToCart.size() ; i++) {

	    	   addToCart.get(i).click();
	    	   
	    	   
	       }
	           String actual_count = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getText();
	           int expected_count = 6;
	           
	           int actualCount = Integer.parseInt(actual_count);
	           
	           Assert.assertEquals(actualCount, expected_count);
	           
	           
	           
	       }
	       

	}


