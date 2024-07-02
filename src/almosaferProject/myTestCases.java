package almosaferProject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases extends TestData {

	HomePageTestCasses HomeTest = new HomePageTestCasses();
	HotelPageTest HotelTest = new HotelPageTest();

	@BeforeTest
	public void mySetup() {
		defaultConfiguration();
	}

	@Test(description = "HomePageTest", priority = 1)
	public void CheckThelanguage() {

		HomeTest.CheckThelanguageTest();
	}

	@Test(description = "HomePageTest", priority = 2)
	public void CheckTheCurrency() {

		HomeTest.CheckTheCurrencyTest();

	}

	@Test(description = "HomePageTest", priority = 3)
	public void CheckTheContactNubmer() {

		HomeTest.CheckTheContactNubmerTest();
	}

	@Test(description = "HomePageTest", priority = 4)
	public void CheckQetafLogeIsDesplyed() {

		HomeTest.CheckQetafLogeIsDesplyedTest();

	}

	@Test(description = "HomePageTest", priority = 5)
	public void checkHotelsTabIsNotSelected() {

		HomeTest.checkHotelsTabIsNotSelectedTest();

	}

	@Test(description = "HomePageTest", priority = 6)
	public void CheckDepatureAndReturnDate() {

		HomeTest.CheckDepatureAndReturnDateTest();
	}

	@Test(description = "HomePageTest", priority = 7)
	public void ChangeTheLanguageOfTheWebSiteRandomly() {

		HomeTest.ChangeTheLanguageOfTheWebSiteRandomly();

	}

	@Test(description = "HotelPageTest", priority = 8)
	public void searchForHotelsRandomly() {

		HotelTest.searchForHotelsRandomlyTest();
	}

	@Test(description = "HotelPageTest", priority = 9)
	public void SelectNumberOfPeople() {

		HotelTest.SelectNumberOfPeopleTest();
	}

	@Test(description = "HotelPageTest", priority = 10)

	public void checkPageFullyLoaded() {

		HotelTest.checkPageFullyLoadedTest();
	}

	@Test(description = "HotelPageTest", priority = 11)

	public void sortItems() {

		HotelTest.sortItemsTest();

	}
}
