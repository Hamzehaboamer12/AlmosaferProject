package almosaferProject;
import static org.testng.Assert.assertEquals;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePageTestCasses extends TestData {

	public void CheckThelanguageTest() {
		WebElement HtmlTag = driver.findElement(By.tagName("html"));
		String ActualLanguge = HtmlTag.getAttribute("lang");
		Assert.assertEquals(ActualLanguge, ExpectedLanaguge);

	}

	public void CheckTheCurrencyTest() {
		WebElement Currency = driver.findElement(By.xpath("//button[@ data-testid ='Header__CurrencySelector']"));
		String ActualCurrency = Currency.getText();
		Assert.assertEquals(ActualCurrency, ExpexedCurrency);
	}

	public void CheckTheContactNubmerTest() {
		WebElement contactNumber = driver.findElement(By.tagName("strong"));
		String ActualContactNumber = contactNumber.getText();
		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);
	}

	public void CheckQetafLogeIsDesplyedTest() {
		WebElement QitafLogo = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF"));
		Boolean ActualDisplyedQitafLogo = QitafLogo.isDisplayed();
		Assert.assertEquals(ActualDisplyedQitafLogo, ExpectedQitaflogoDisplayed);
	}

	public void checkHotelsTabIsNotSelectedTest() {

		String ActualHotelTabSelected = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"))
				.getAttribute("aria-selected");
		Assert.assertEquals(ActualHotelTabSelected, ExpetedHotelTabSelected);

	}

	public void CheckDepatureAndReturnDateTest() {
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
}
