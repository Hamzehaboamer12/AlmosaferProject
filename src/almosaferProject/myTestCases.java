package almosaferProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {

	WebDriver driver = new ChromeDriver();
	String URL = "https://www.almosafer.com/en?ncr=1";
	String ExpectedLanaguge = "en";
	String ExpexedCurrency = "SAR";
	String ExpectedContactNumber = "+966554400000";
	Boolean ExpectedQitaflogoDisplayed = true;
	Boolean ExpetedHotelTabSelected = false;

	@BeforeTest
	public void mySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Test
	public void CheckThelanguage() {

		WebElement HtmlTag = driver.findElement(By.tagName("html"));
		String ActualLanguge = HtmlTag.getAttribute("lang");
		Assert.assertEquals(ActualLanguge, ExpectedLanaguge);

	}

	@Test
	public void CheckTheCurrency() {

		WebElement Currency = driver.findElement(By.xpath("//button[@ data-testid ='Header__CurrencySelector']"));
		String ActualCurrency = Currency.getText();
		Assert.assertEquals(ActualCurrency, ExpexedCurrency);

	}

	@Test
	public void CheckTheContactNubmer() {

		WebElement contactNumber = driver.findElement(By.tagName("strong"));
		String ActualContactNumber = contactNumber.getText();
		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);

	}

	@Test
	public void CheckQetafLogeIsDesplyed() {

		WebElement QitafLogo = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF"));
		Boolean ActualDisplyedQitafLogo = QitafLogo.isDisplayed();
		Assert.assertEquals(ActualDisplyedQitafLogo, ExpectedQitaflogoDisplayed);

	}

	@Test
	public void checkHotelsTabIsNotSelected() {

		WebElement HotelTab = driver.findElement(By.cssSelector(".nav-item.nav-link.active"));
		Boolean ActualHorelTabSelcted = HotelTab.isSelected();
		Assert.assertEquals(ActualHorelTabSelcted, ExpetedHotelTabSelected);
	}

}
