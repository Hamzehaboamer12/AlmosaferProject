package almosaferProject;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HotelPageTest extends TestData {

	public void searchForHotelsRandomlyTest() {
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

	public void SelectNumberOfPeopleTest() {
		WebElement SelectorElement = driver
				.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));

		Select Selector = new Select(SelectorElement);
		int randomIndex = rand.nextInt(2);
		Selector.selectByIndex(randomIndex);

		driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk")).click();

	}

	public void checkPageFullyLoadedTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement resultTab = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[@data-testid ='HotelSearchResult__resultsFoundCount']")));

		Assert.assertEquals(resultTab.getText().contains("found") || resultTab.getText().contains("وجدنا"), true);

	}

	public void sortItemsTest() {
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
