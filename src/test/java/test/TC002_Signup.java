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
import page.Signup;


public class TC002_Signup extends Projectspecification{

	@BeforeTest
	public void setup() throws Exception {
		
		readFromPropFile();
	}
	
	@Test
	public void validSignupTest() throws Exception {
		

		Homepage obj = new Homepage(driver);
		Signup obj2 = new Signup(driver);
		
		obj.clickSignup();
		obj2.entername(prop.getProperty("Validusername"));
		obj2.enterPassword(prop.getProperty("Validpassword"));
		obj2.SignupClick();
		
	}
}