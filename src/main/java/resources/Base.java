package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\ADARSPAN\\eclipse-workspace\\MagicBricks\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		String loginUrl = prop.getProperty("loginUrl");
		String Url = prop.getProperty("url");
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");
		String chromeDriverPath = prop.getProperty("chromeDriverPath");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			
			// execute in chrome driver
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(loginUrl);
			driver.findElement(By.xpath("//input[@id='emailOrMobile']")).sendKeys(email);
			driver.findElement(By.id("btnStep1")).click();
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			driver.findElement(By.id("btnLogin")).click();
			driver.get(Url);
			
		}

		else {
			System.out.println("Invalid Driver name");
		}
        
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
}
