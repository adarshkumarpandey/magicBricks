package pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This java class will handle Legat Title Check Scenario.
 */

public class LegalTitleCheck {

	WebDriver driver;

	public LegalTitleCheck(WebDriver driver) {
		this.driver = driver;
	}
    
	//By propertyServices = By.xpath("//*[@class='mb-header__sub__tabs__link js-menu-link' and text()='Property Services']");
	By propertyServices = By.linkText("Property Services");
	By legalTitleCheck = By
			.xpath("//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[5]/div/div/div[2]/ul/li[2]/a");
	By verifyPropertyDocs = By.xpath("//*[@id=\"verifyPropertyDocumentsA\"]/a");
	By propertyLegalTitle = By.className("prop-service__pkgGridSec__title");

	public void getPropertyServices() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(propertyServices)).click();
	}

	public WebElement getLegalTitleCheck() {

		return driver.findElement(legalTitleCheck);
	}

	public WebElement getVerifyPropertyDocsBtn() {
		return driver.findElement(verifyPropertyDocs);
	}

	public WebElement getPropertyServiceTitle() {
		return driver.findElement(propertyLegalTitle);
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

}
