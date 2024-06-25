package almosaferProject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {

	WebDriver driver = new ChromeDriver();
	String URL = "https://www.almosafer.com/en?ncr=1";
	String ExpectedLanaguge = "en";
	String ExpectedArabicLanguge = "ar";
	String ExpexedCurrency = "SAR";
	String ExpectedContactNumber = "+966554400000";
	Boolean ExpectedQitaflogoDisplayed = true;
	String ExpetedHotelTabSelected = "false";
	Random rand = new Random();

	@BeforeTest
	public void mySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Test(enabled = false)
	public void CheckThelanguage() {

		WebElement HtmlTag = driver.findElement(By.tagName("html"));
		String ActualLanguge = HtmlTag.getAttribute("lang");
		Assert.assertEquals(ActualLanguge, ExpectedLanaguge);

	}

	@Test(enabled = false)
	public void CheckTheCurrency() {

		WebElement Currency = driver.findElement(By.xpath("//button[@ data-testid ='Header__CurrencySelector']"));
		String ActualCurrency = Currency.getText();
		Assert.assertEquals(ActualCurrency, ExpexedCurrency);

	}

	@Test(enabled = false)
	public void CheckTheContactNubmer() {

		WebElement contactNumber = driver.findElement(By.tagName("strong"));
		String ActualContactNumber = contactNumber.getText();
		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);

	}

	@Test(enabled = false)
	public void CheckQetafLogeIsDesplyed() {

		WebElement QitafLogo = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF"));
		Boolean ActualDisplyedQitafLogo = QitafLogo.isDisplayed();
		Assert.assertEquals(ActualDisplyedQitafLogo, ExpectedQitaflogoDisplayed);

	}

	@Test(enabled = false)
	public void checkHotelsTabIsNotSelected() {

		String ActualHotelTabSelected = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"))
				.getAttribute("aria-selected");
		Assert.assertEquals(ActualHotelTabSelected, ExpetedHotelTabSelected);

	}

	@Test(enabled = false)
	public void CheckDepatureAndReturnDate() {
		LocalDate Today = LocalDate.now();
		// System.out.println(Today);
		Today.getDayOfMonth();
		int ExpectedDepatureDate = Today.plusDays(1).getDayOfMonth();
		int ExpectedReturnDate = Today.plusDays(2).getDayOfMonth();
		int ActualDepatureDate = Integer.parseInt(driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"))
				.getText());
		int ActualReturnDate = Integer.parseInt(driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"))
				.getText());
//		System.out.println(ActualDepatureDate);
//		System.out.println(ActualReturnDate);

		Assert.assertEquals(ActualDepatureDate, ExpectedDepatureDate);
		Assert.assertEquals(ActualReturnDate, ExpectedReturnDate);

	}

	@Test(priority = 1)
	public void ChangeTheLanguageOfTheWebSiteRandomly() {

		String[] websiteUrl = { "https://www.almosafer.com/en?ncr=1", "https://www.almosafer.com/ar?ncr=1" };

		int randomIndex = rand.nextInt(websiteUrl.length);
		driver.get(websiteUrl[randomIndex]);

		if (driver.getCurrentUrl().contains("en")) {
			WebElement HtmlTag = driver.findElement(By.tagName("html"));
			String ActualEnLanguage = HtmlTag.getAttribute("lang");
			assertEquals(ActualEnLanguage, ExpectedLanaguge);
			System.out.println(ActualEnLanguage);

		} else if (driver.getCurrentUrl().contains("ar")) {
			WebElement HtmlTag = driver.findElement(By.tagName("html"));
			String ActualarLanguage = HtmlTag.getAttribute("lang");
			assertEquals(ActualarLanguage, ExpectedArabicLanguge);
			System.out.println(ActualarLanguage);
		}

	}

	@Test(priority = 2)
	public void searchForHotelsRandomly() {
		driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).click();
		WebElement SearchHotel = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));

		String[] EnglishCities = { "Dubai", "Jeddah", "Riyadh" };
		String[] ArabicCities = { "دبي", "جدة" };

		if (driver.getCurrentUrl().contains("en")) {
			int RandomIndext = rand.nextInt(EnglishCities.length);
			SearchHotel.sendKeys(EnglishCities[RandomIndext]);

		} else if (driver.getCurrentUrl().contains("ar")) {
			int RandomIndext = rand.nextInt(ArabicCities.length);
			SearchHotel.sendKeys(ArabicCities[RandomIndext]);
		}

	}

	@Test(priority = 3)
	public void SelectNumberOfPeople() {

		WebElement SelectorElement = driver
				.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));

		Select Selector = new Select(SelectorElement);
		int randomIndex = rand.nextInt(2);
		Selector.selectByIndex(randomIndex);

		driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk")).click();
	}

	@Test(priority = 4)

	public void checkPageFullyLoaded() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement resultTab = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[@data-testid ='HotelSearchResult__resultsFoundCount']")));

		Assert.assertEquals(resultTab.getText().contains("found") || resultTab.getText().contains("وجدنا"), true);

	}

	@Test(priority = 5)

	public void sortItems() {

		WebElement lowestPriceButton = driver
				.findElement(By.xpath("//button[@data-testid ='HotelSearchResult__sort__LOWEST_PRICE']"));
		lowestPriceButton.click();

		WebElement priceContainer = driver.findElement(By.cssSelector(".sc-htpNat.KtFsv.col-9"));
		List<WebElement> price = priceContainer.findElements(By.className("Price__Value"));
		int firtPrice = Integer.parseInt(price.get(0).getText());
		int lastPrice = Integer.parseInt(price.get(price.size() - 1).getText());

		Assert.assertEquals(firtPrice < lastPrice, true);

	}
}
