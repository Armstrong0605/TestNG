package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Projectspecification;

public class Homepage extends Projectspecification{

	public Homepage(WebDriver driver) {
		Homepage.driver=driver;
	}
      public login clickSignup() {
		
		click(driver.findElement(By.id("signin2")));
		return new login (driver);
	}
	
	public login clickLogin() {
		
		click(driver.findElement(By.id("login2")));
		return new login (driver);
	}
	
	public Homepage validateLogin() throws Exception {
		
		String text = driver.findElement(By.id("nameofuser")).getText();
		System.out.println(text);
		screenShot("LoginTest_Validation");
		return this;
	}
}