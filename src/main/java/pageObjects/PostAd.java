package pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*
 * This java class will handle PostAd Scenario
 */
public class PostAd {

	WebDriver driver;

	public PostAd(WebDriver driver) {
		this.driver = driver;
	}

	public PostAd() {
	}

	By sell = By.xpath("//*[@class='mb-header__sub__tabs__link js-menu-link' and text()='Sell']");
	By postProperty = By.xpath("//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[3]/div/div/div[1]/ul/li[1]/a");
	By freeTabSelect = By.xpath("//*[@class='mbB2cGrid__btn' and text()='Continue']");
	By forSale = By.xpath("//*[@id='propertyForS']");
	By propertyType = By.xpath("//*[@id='propertyTypeVal' ]");
	By selectPropertyType = By.xpath("//li[text()='Residential House']");
	By cityName = By.xpath("//*[@id=\"quickCity\"]");
	By bedrooms = By.xpath("//*[@class='csF bdOption' and text()=1]");
	By balconies = By.xpath("//*[@class='csF blOption' and text()=0]");
	By floorNo = By.xpath("//*[@class='csF blOption blOptionNowr' and text()=1]");
	By totalFloors = By.xpath("//*[@id=\"totalFloor\"]/span/div[1]/div[1]/ul/li[3]");
	By furnishedStatus = By.xpath("//*[@id=\"furnishedDiv\"]/span/div[1]/div[1]/ul/li[1]");
	By bathrooms = By.xpath("//*[@class='csF btOption' and text()=1]");

	public void getSell() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(sell)).click();
	}

	public WebElement getPostProperty() {
		return driver.findElement(postProperty);
	}

	public WebElement getFreeTabSelect() {

		return driver.findElement(freeTabSelect);
	}

	public WebElement getForSale() {
		return driver.findElement(forSale);
	}

	public void getSelectPropertyType() throws InterruptedException {

		driver.findElement(propertyType).click();
		driver.findElement(selectPropertyType).click();
		Thread.sleep(4000);

	}

	public void getCityName() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(cityName)).sendKeys("Chandigarh", Keys.ENTER);
		
	}

	public WebElement getBedrooms() {
		return driver.findElement(bedrooms);

	}

	public WebElement getBalconies() {

		return driver.findElement(balconies);

	}

	public WebElement getFloorNo() {

		return driver.findElement(floorNo);

	}

	public WebElement getTotalFloors() {

		return driver.findElement(totalFloors);

	}

	public WebElement getFurnishedStatus() {
		return driver.findElement(furnishedStatus);

	}

	public WebElement getBathrooms() {
		return driver.findElement(bathrooms);

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
