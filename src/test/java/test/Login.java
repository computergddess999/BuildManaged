package test;

import org.testng.annotations.Test;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
   @Test  (priority=2)
	public void negativeLogin()  throws InterruptedException {
	   // WebDriver driver=null;
	   
	   //WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

		driver.get("http://magento.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("email")).sendKeys("computer_gddess@yahoo.com");
		driver.findElement(By.id("pass")).sendKeys("welcome");
		driver.findElement(By.id("send2")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*@id=\"maincontent\"/div[2]/div/div/div")));
		String error = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")).getText();
	    System.out.println("error:   "+error);
		if(error.equals("Invalid login or password."));
		{
			System.out.println("Test case pass");
		}
	   driver.quit();   
	   
   }
 
 
}