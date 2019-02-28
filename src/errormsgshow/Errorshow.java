package errormsgshow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Errorshow {

	
		public static void main(String[] args) throws InterruptedException, IOException {
			File F =new File("./Driver/gmail.properities");
			FileInputStream fileinput = null;
			try{
				fileinput = new FileInputStream(F);
			}
			catch
			(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			Properties prop = new Properties();
			{
				prop.load(fileinput);
			}
					System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
					WebDriver dv = new ChromeDriver();
					dv.get(prop.getProperty("URL")); 
					dv.manage().window().maximize();// Window open maximize size always open
					Thread.sleep(5000);
					
					dv.findElement(By.xpath(prop.getProperty("Email"))).sendKeys(prop.getProperty("email"));
					Thread.sleep(2000);
					
					dv.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("pass"));
					Thread.sleep(2000);
					dv.findElement(By.xpath(prop.getProperty("Login"))).click();
					Thread.sleep(3000);
					
					dv.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("pass"));
					Thread.sleep(2000);
					
					dv.findElement(By.xpath(prop.getProperty("Button"))).click();
					
					String actul_error = dv.findElement(By.xpath(prop.getProperty("Massage"))).getText();
					String expected_error = prop.getProperty("massage");
					
					System.out.println("Please enter the correct Username and password");
					Thread.sleep(3000);
					
					dv.get(prop.getProperty("Photo"));
					Assert.assertEquals(actul_error, expected_error);
					Thread.sleep(3000);			
					/*Assert.assertTrue(actul_error.contains("Please enter your email."));
					System.out.println("Test Completed");*/

	}

}
