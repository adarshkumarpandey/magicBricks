package pageObjects;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertyValuation {

	WebDriver driver;

	public PropertyValuation(WebDriver driver) {
		this.driver = driver;
	}
     
	//By propertyServices = By.xpath("//*[@class='mb-header__sub__tabs__link js-menu-link' and text()='Property Services']");
	By propertyServices = By.linkText("Property Services");
	By propertyValuation = By
			.xpath("//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[5]/div/div/div[2]/ul/li[1]/a");
	By requestValuationBtn = By.className("prop-service__banner--requestCta prop-service__action--btn btn-red xmedium");
	By propertyValTiltleCheck = By.className("prop-service__pkgGridSec__title");
	By reportDownload = By.className("prop-service__banner--downloadReportCta");

	public void getPropertyServices() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(propertyServices)).click();
	}

	public WebElement getPropertyValuation() {
		return driver.findElement(propertyValuation);
	}

	public void getRequestValuationBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(requestValuationBtn)).click();;
		
	}

	public WebElement getPropertyValTitleCheck() {
		return driver.findElement(propertyValTiltleCheck);
	}
     
	/*
	 * This method will handle new Tab.
	 */
	
	public void handleDriver() {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
		}
	}
 
	public WebElement downloadReport() {
		return driver.findElement(reportDownload);
	}

	/*
	 * This method will search for the file name in Downloads
	 */
	public boolean isReportDownloaded() {

		String fileName = "Property_Valuation_Comprehensive_Report";// Property_Valuation_Comprehensive_Report
		String path = "C:\\Users\\ADARSPAN\\Downloads";

		File dir = new File(path);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().contains(fileName)) {
				return true;
			}

		}
		return false;
	}

}
