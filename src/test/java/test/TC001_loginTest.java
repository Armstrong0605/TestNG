package test;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecification;
import page.Homepage;
import page.login;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecification;
import page.Homepage;
import page.login;

public class TC001_loginTest extends Projectspecification{

	@BeforeTest
	public void setup() throws Exception {
		
		readFromPropFile();
	}
	
	@Test
	public void validLoginTest() throws Exception {
		

		Homepage obj = new Homepage(driver);
		login obj1 = new login(driver);
		
		obj.clickLogin();
		obj1.enterEmail(prop.getProperty("Validusername"));
		obj1.enterPassword(prop.getProperty("Validpassword"));
		obj1.loginClick();
		obj.validateLogin();
	}
}