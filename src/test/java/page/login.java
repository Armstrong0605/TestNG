package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Projectspecification;

public class login extends Projectspecification{


	public login(WebDriver driver) {
		login.driver=driver;
	}

	public login enterEmail(String name) {
		
		sendkeys(driver.findElement(By.id("loginusername")),name);
		return this;
	}
	
	public login enterPassword(String password) {
		
		sendkeys(driver.findElement(By.id("loginpassword")),password);
		return this;
	}
	
	public Homepage loginClick() {
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		return new Homepage(driver);
	}
	
}