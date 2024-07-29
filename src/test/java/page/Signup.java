package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Projectspecification;

public class Signup extends Projectspecification{


	public Signup (WebDriver driver) {
		Signup.driver=driver;
	}

	public Signup entername(String name) {
		
		sendkeys(driver.findElement(By.id("sign-username")),name);
		return this;
	}
	
	public Signup enterPassword(String password) {
		
		sendkeys(driver.findElement(By.id("sign-password")),password);
		return this;
	}
	
	public Homepage SignupClick() {
		
		driver.findElement(By.xpath("//button[text()='Sign up']")).click();

		return new Homepage(driver);
	}
	
}