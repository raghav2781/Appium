package stepDefination;

import org.testng.Assert;
import Pages.HomePage;
import Pages.SearchedArticlePage;
import ProjectUtility.BaseClass;
import ProjectUtility.Log4J;
import ProjectUtility.ReadFromExcel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Definations {

	Log4J log = new Log4J();

	@Given("^open wikipedia application$")
	public void open_wikipedia_application() throws Throwable {
		try {
			BaseClass.openApplication();
			log.logInfo("'open wikipedia application' executed");
		} catch (Exception e) {
			log.logError("Exception in 'open wikipedia application' ");
			throw e;
		}

	}

	@Given("^click on menu bar$")
	public void click_on_menu_bar() throws Throwable {
		HomePage page = new HomePage();
		try {
			page.menuBar();
			log.logInfo("'click on menu bar' executed");
		} catch (Exception e) {
			log.logError("Exception in 'open wikipedia application'");
			throw e;
		}
	}

	@When("^click on login option$")
	public void click_on_login_option() throws Throwable {
		HomePage page = new HomePage();
		try {
			page.loginOption();
			log.logInfo("'click on login option' executed");
		} catch (Exception e) {
			log.logError("Exception in 'click on login option'");
			throw e;
		}
	}

	@When("^enter username and password$")
	public void enter_username_and_password() throws Throwable {
		HomePage page = new HomePage();
		try {
			page.usenameField(ReadFromExcel.getDataFromExcel("username"));
			page.passwordField(ReadFromExcel.getDataFromExcel("password"));
			log.logInfo("'enter username and password' executed");
		} catch (Exception e) {
			log.logError("Exception in 'enter username and password'");
			throw e;

		}
	}

	@When("^click login button$")
	public void click_login_button() throws InterruptedException {
		HomePage page = new HomePage();
		try {
			page.loginButton();
			log.logInfo("'click login button' executed");
		} catch (Exception e) {
			log.logError("Exception in 'click login button'");
			throw e;
		}
	}

	@Then("^again click on menubar$")
	public void again_click_on_menubar() throws InterruptedException {
		HomePage page = new HomePage();

		try {
			page.menuBar();
			log.logInfo("'again click on menubar' executed");
		} catch (Exception e) {
			log.logError("Exception in 'again click on menubar'");
			throw e;
		}
	}

	@Then("^check text of username in menu bar$")
	public void check_text_of_username_in_menu_bar() {
		HomePage page = new HomePage();
		try {
			Assert.assertEquals(page.usernameText().toLowerCase(),
					ReadFromExcel.getDataFromExcel("username").toLowerCase());
			log.logInfo("'Assertion passed, user logged In successfully '");
		} catch (AssertionError e) {
			log.logError("Assertion Failed'user not able to logged In successfully'-----" + e);
			throw e;
		}
		page.clickOnlogOutButton();
		HomePage.closeDriver();

	}

	@Given("^search article$")
	public void search_article() throws InterruptedException {
		HomePage page = new HomePage();
		try {
			page.searchArticle(ReadFromExcel.getDataFromExcel("article"));
			log.logInfo("'Article searched properly'");
		} catch (Exception e) {
			log.logError("exception in article search" + e);
			throw e;
		}
	}

	@Then("^verify the title in landscape mode$")
	public void verify_the_title_in_landscape_mode() {
		SearchedArticlePage page1 = new SearchedArticlePage();
		page1.landscapeMode();
		try {
			Assert.assertTrue(
					page1.titleText().toLowerCase().contains(ReadFromExcel.getDataFromExcel("article").toLowerCase()));
			log.logInfo("'Assertion passed, title matched '");
		} catch (AssertionError e) {
			log.logError("Assertion Failed'title not matched'" + e);
		}
		page1.portraitMode();
		HomePage.closeDriver();

	}

	@Then("^validate top heading of page$")
	public void validate_top_heading_of_page() throws Throwable {
		SearchedArticlePage page1 = new SearchedArticlePage();
		Assert.assertTrue(
				page1.titleText().toLowerCase().contains(ReadFromExcel.getDataFromExcel("article").toLowerCase()));
		HomePage.closeDriver();
	}

	@Given("^click on AddToReadingList$")
	public void click_on_AddToReadingList() {
		SearchedArticlePage page1 = new SearchedArticlePage();
		page1.clickOnSaveToReadingList();
	}

	@Given("^click on createList$")
	public void click_on_createList() throws Throwable {
		SearchedArticlePage page1 = new SearchedArticlePage();
		page1.createReadingList();
	}

	@Given("^press OK$")
	public void press_OK() throws InterruptedException {
		SearchedArticlePage page1 = new SearchedArticlePage();
		page1.clickOnOkButton();
		Thread.sleep(4000);
	}

	@Given("^verify the added page$")
	public void verify_the_added_page() throws Throwable {
		SearchedArticlePage page1 = new SearchedArticlePage();
		page1.clickOnSaveToReadingList();

		Assert.assertEquals(page1.textOfRemoveMyList(), "Remove from My reading list");
		HomePage.closeDriver();
	}

	@Given("^click on myReadingList$")
	public void click_on_myReadingList() throws Throwable {
		SearchedArticlePage page1 = new SearchedArticlePage();
		page1.clickOnSaveToReadingList();
	}

	@Given("^click on removeArticle from list$")
	public void click_on_removeArticle_from_list() throws Throwable {
		SearchedArticlePage page1 = new SearchedArticlePage();
		page1.removeFromReadingList();
		Thread.sleep(5000);
	}

	@Given("^verify the removing of article from myReadingList$")
	public void verify_the_removing_of_article_from_myReadingList() {
		SearchedArticlePage page1 = new SearchedArticlePage();
		page1.clickOnSaveToReadingList();
		Assert.assertEquals(page1.textOfCreateNewList(), "Create new");
		HomePage.closeDriver();

	}

}
