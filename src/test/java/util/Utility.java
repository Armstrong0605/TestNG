package util;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility {

	public static WebDriver driver;
	public static Properties prop;
	
	public void browserLaunch(String url, String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} 
		else if(browser.equalsIgnoreCase("edge")) 
		{
			driver = new EdgeDriver();
		} 
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} 
		else if(browser.equalsIgnoreCase("headless")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		}
		else 
		{
			driver = new ChromeDriver();
		}
		
		URL link = new URL(url); 
		
		HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
		
		httpURLConnection.setConnectTimeout(3000);
		
		httpURLConnection.connect();

		
		if(httpURLConnection.getResponseCode()== 200) 
		{
			System.out.println(url +" - "+ httpURLConnection.getResponseMessage());
			driver.get(url);
		} 
		else 
			
		{
			System.out.println(url +" - "+ httpURLConnection.getResponseMessage());
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public static void readFromPropFile() throws Exception {
		
		FileReader file = new FileReader("C:\\Users\\Jenner\\eclipse-workspace\\TestNG_1\\src\\main\\resources\\credentials.properties");
		
		prop = new Properties();
		
		prop.load(file);
	}
	public void browserClose() 
	{
		driver.close();
	}
	
	public void click(WebElement ele) 
	{
		ele.click();
		
	}
	
	public void sendkeys(WebElement element , String value)
	{
		
		element.sendKeys(value);
	}
	
	public void screenShot(String name) throws IOException {
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Users\\Jenner\\eclipse-workspace\\TestNG_1\\Screen Shot"+name+".png");
		
		FileUtils.copyFile(source, destination);
	}
}