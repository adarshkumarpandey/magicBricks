package resources;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/*
 * This java class will handle ScreenShot.
 */
public class ScreenCaptureUtil {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileHandler.copy(source, new File(
					"C:\\Users\\ADARSPAN\\eclipse-workspace\\MagicBricks\\ScreenShots" + screenshotName + ".png"));

			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Couldnt take Screenshot " + e.getMessage());
		}
	}

}
