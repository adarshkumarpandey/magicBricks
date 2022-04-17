package pageObjects;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vastu {
	WebDriver driver;

	public Vastu(WebDriver driver) {
		this.driver = driver;
	}
	
	//By propertyServices = By.xpath("//*[@class='mb-header__sub__tabs__link js-menu-link' and text()='Property Services']");
	By propertyServices = By.linkText("Property Services");
	By vastu = By.xpath("//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[5]/div/div/div[2]/ul/li[5]/a");
	By consultant = By.xpath("//*[@id=\"loadMore\"]/li[1]/div/a/div[1]");
	By consultantDetails = By.className("mkt-place__pdp__header--title");
	// By reportDownload =
	// By.className("mkt-place__pdp__header--sample-report-link");
	By reportDownload = By.xpath("/html/body/div[2]/div/div/div[2]/div[4]/span[1]");

	public void getPropertyServices() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(propertyServices)).click();
	}

	public WebElement getVastu() {
		return driver.findElement(vastu);
	}

	public void getConsultant() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loadMore\"]/li[1]/div/a/div[1]")))
				.click();
	}

	public WebElement getConsultantDetails() { // Abhinandan Kumar - Onsite Consultation with Report
		return driver.findElement(consultantDetails);
	}

	public WebElement getReportDownload() {
		return driver.findElement(reportDownload);
	}

	public void handleDriver() {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
		}
	}

	/*
	 * This method will search for the file name in Downloads
	 */
	public boolean isReportDownloaded() {

		String fileName = "193411_Abhinandan_Sample_Report";// 188191_Sample_Vastu_Report-_Abhinandan
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
