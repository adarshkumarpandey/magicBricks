package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LegalTitleCheck;
import pageObjects.PostAd;
import pageObjects.PropertyValuation;
import pageObjects.Vastu;
import resources.Base;
import resources.ScreenCaptureUtil;

public class StepDefinations extends Base {

	PostAd postAd;

	@Test
	@When("user click on Sell and Select Post Property")
	public void user_click_on_sell_and_select_post_property() throws Exception {

		driver = initializeDriver();
		postAd = new PostAd(driver);
		Thread.sleep(3000);
		postAd.getSell();
		postAd.getPostProperty().click();
		postAd.handleDriver();
		ScreenCaptureUtil.captureScreenshot(driver, "\\PostAd1");

	}

	@Test
	@When("user is able to select Free Ad Package")
	public void user_is_able_to_select_free_ad_package() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(3000);
		postAd.getFreeTabSelect().click();
		ScreenCaptureUtil.captureScreenshot(driver, "\\PostAd2");

	}

	@When("user select Sale option")
	public void user_select_sale_option() {

		// postAd.getForSale().click();
		ScreenCaptureUtil.captureScreenshot(driver, "\\PostAd3");

	}

	@Test
	@When("user select Property Type")
	public void user_select_property_type() throws Exception {

		postAd.getSelectPropertyType();
		System.out.println("select property done");
		ScreenCaptureUtil.captureScreenshot(driver, "\\PostAd4");

	}

	@Test
	@When("user enters the Property Location details")
	public void user_enters_the_property_location_details() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");
		ScreenCaptureUtil.captureScreenshot(driver, "\\PostAd5");

	}

	@Test
	@When("user select the Property Features")
	public void user_select_the_property_features() {
		postAd.getBedrooms().click();
		postAd.getBalconies().click();
		postAd.getFloorNo().click();
		postAd.getTotalFloors().click();
		postAd.getFurnishedStatus().click();
		postAd.getBathrooms().click();
		ScreenCaptureUtil.captureScreenshot(driver, "\\PostAd6");

	}

	@Test
	@When("user click on Continue to Post")
	public void user_click_on_continue_to_post() {

		System.out.println("Continue to post");
		ScreenCaptureUtil.captureScreenshot(driver, "\\PostAd7");

	}

	@Test
	@Then("user is able to post a add")
	public void user_is_able_to_post_a_add() {

		System.out.println("Landed on post property page");
		ScreenCaptureUtil.captureScreenshot(driver, "\\PostAd8");

	}

	PropertyValuation pv;

	@Test
	@When("^user click on Property Services and select Property Valuation$")
	public void user_click_on_property_services_and_select_property_valuation() throws Exception {

		driver = initializeDriver();
		pv = new PropertyValuation(driver);
		Thread.sleep(3000);
		pv.getPropertyServices();
		pv.getPropertyValuation().click();
		pv.handleDriver();
		ScreenCaptureUtil.captureScreenshot(driver, "\\PropertyServices1");
	}

	@Test
	@And("^user click on Request a Valuation$")
	public void user_click_on_request_a_valuation() throws Exception {
		Thread.sleep(3000);
		// pv.getRequestValuationBtn();
		ScreenCaptureUtil.captureScreenshot(driver, "\\PropertyServices2");

	}

	@Test
	@Then("^user redirected to Packages for Property Valuation Services$")
	public void user_redirected_to_packages_for_property_valuation_services() throws InterruptedException {

		String actual = pv.getPropertyValTitleCheck().getText();
		String expected = "Property Valuation Services";
		System.out.println(actual);
		Assert.assertEquals("Error in getting Property Valuation title", expected, actual);
		Thread.sleep(2000);
		pv.downloadReport().click();
		System.out.println("Clicked on report");
		Assert.assertEquals("Error while downloading Sample Report for Property Valuation", true,
				pv.isReportDownloaded());
		System.out.println("report downloaded");
		ScreenCaptureUtil.captureScreenshot(driver, "\\PropertyServices3");

	}

	@Test
	@Then("^user click on Download Sample Report of Property Valuation$")
	public void user_click_on_download_sample_report_of_property_valuation() {

		// pv.downloadReport().click();
		ScreenCaptureUtil.captureScreenshot(driver, "\\PropertyServices4");
	}

	@Test
	@Then("^A sample report should get downloaded for Property Valuation$")
	public void a_sample_report_should_get_downloaded_for_property_valuation() {
		/*
		 * Assert.
		 * assertEquals("Error while downloading Sample Report for Property Valuation",
		 * true, pv.isReportDownloaded());
		 */

		ScreenCaptureUtil.captureScreenshot(driver, "\\PropertyServices5");

	}

	LegalTitleCheck ltc;

	@Test
	@When("^user click on Property Services and select Legal Title Check$")
	public void user_click_on_property_services_and_select_legal_title_check() throws Exception {

		driver = initializeDriver();
		ltc = new LegalTitleCheck(driver);
		Thread.sleep(3000);
		ltc.getPropertyServices();
		ltc.getLegalTitleCheck().click();
		ScreenCaptureUtil.captureScreenshot(driver, "\\LegalTitleCheck1");

	}

	@Test
	@And("^user click on Verify Property Documents$")
	public void user_click_on_verify_property_documents() {
		ltc.handleDriver();
		// ltc.getVerifyPropertyDocsBtn().click();
		ScreenCaptureUtil.captureScreenshot(driver, "\\LegalTitleCheck2");

	}

	@Test
	@Then("^user redirects to Packages for Property Legal Title Check$")
	public void user_redirects_to_packages_for_property_legal_title_check() {
		String actualTitle = ltc.getPropertyServiceTitle().getText();
		String expected = "Packages for Property Legal Title Check";
		System.out.println(actualTitle);
		Assert.assertEquals("Error in getting Property Valuation title", expected, actualTitle);
		ScreenCaptureUtil.captureScreenshot(driver, "\\LegalTitleCheck3");
	}

	Vastu vastu;

	@Test
	@When("^user click on Property Services and select Vastu$")
	public void user_click_on_property_services_and_select_vastu() throws Exception {

		driver = initializeDriver();
		vastu = new Vastu(driver);
		Thread.sleep(3000);
		vastu.getPropertyServices();
		vastu.getVastu().click();
		ScreenCaptureUtil.captureScreenshot(driver, "\\vastu1");
	}

	@Test
	@And("user is able to Select Consultant")
	public void user_is_able_to_select_consultant() throws InterruptedException {
		vastu.handleDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		vastu.getConsultant();
		ScreenCaptureUtil.captureScreenshot(driver, "\\vastu2");

	}

	@Test
	@And("^user is able to view details of Consultant$")
	public void user_is_able_to_view_details_of_consultant() throws InterruptedException {
		String actual = vastu.getConsultantDetails().getText();
		String expected = "Abhinandan Kumar: 15 mins Trial Pack - Telephonic";
		System.out.println(actual);
		Assert.assertEquals("Error in getting Consultant Details", expected, actual);

		Thread.sleep(2000);
		vastu.getReportDownload().click();
		 Thread.sleep(2000);
		Assert.assertEquals("Error while downloading Sample Report for Property Valuation", true,
				vastu.isReportDownloaded());
		System.out.println("Report downloaded succesfully");
		ScreenCaptureUtil.captureScreenshot(driver, "\\vastu3");

	}

	@Test
	@And("^user is able to download sample report of Consultant$")
	public void user_is_able_to_download_sample_report_of_consultant() throws InterruptedException {
		/*
		 * Thread.sleep(5000); vastu.getReportDownload().click(); Thread.sleep(2000);
		 * Assert.
		 * assertEquals("Error while downloading Sample Report for Property Valuation",
		 * true, vastu.isReportDownloaded());
		 * System.out.println("Report downloaded succesfully");
		 */
		ScreenCaptureUtil.captureScreenshot(driver, "\\vastu4");
	}

	@Test
	@Then("^A sample report should get downloaded of Consultant$")
	public void a_sample_report_should_get_downloaded_of_consultant() {

		/*
		 * Assert.
		 * assertEquals("Error while downloading Sample Report for Property Valuation",
		 * true, vastu.isReportDownloaded());
		 */
		ScreenCaptureUtil.captureScreenshot(driver, "\\vastu5");
	}

}
