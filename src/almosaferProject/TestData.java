package almosaferProject;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestData {
	protected static WebDriver driver;
	String URL = "https://www.almosafer.com/en?ncr=1";
	String ExpectedLanaguge = "en";
	String ExpectedArabicLanguge = "ar";
	String ExpexedCurrency = "SAR";
	String ExpectedContactNumber = "+966554400000";
	Boolean ExpectedQitaflogoDisplayed = true;
	String ExpetedHotelTabSelected = "false";
	Random rand = new Random();

	@BeforeSuite
	public void setup() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null;

		}
	}

	public void defaultConfiguration() {
		driver.get(URL);

	}

}
