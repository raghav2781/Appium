package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ProjectUtility.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(xpath = "//android.widget.TextView[@text='Search Wikipedia']")
	private WebElement searchField;
	@FindBy(xpath = "//android.widget.TextView[@content-desc='More options']")
	private WebElement menuBar;
	@FindBy(xpath = "//android.widget.TextView[@text='Log in to Wikipedia']")
	private WebElement loginOption;
	@FindBy(xpath = "//android.widget.EditText[@resource-id='org.wikipedia:id/login_username_text']")
	private WebElement usernameField;
	@FindBy(xpath = "//android.widget.EditText[@password='true']")
	private WebElement passwordField;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='org.wikipedia:id/login_button']")
	private WebElement loginButton;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='org.wikipedia:id/explore_overflow_account_name']")
	private WebElement usernameText;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='org.wikipedia:id/explore_overflow_log_out']")
	private WebElement logoutButton;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void searchArticle(String articleName) throws InterruptedException {
		searchField.click();
		searchField.sendKeys(articleName);
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Thread.sleep(5000);
		try {
			searchField.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {

		}
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Thread.sleep(3000);
		try {
			driver.findElementByXPath("//android.widget.ImageView[@content-desc='Done']").click();
		} catch (NoSuchElementException e) {

		}

	}

	public void menuBar() throws InterruptedException {
		Thread.sleep(2000);
		menuBar.click();

	}

	public void loginOption() {
		loginOption.click();
	}

	public void usenameField(String username) {
		usernameField.sendKeys(username);

	}

	public void passwordField(String password) {
		passwordField.sendKeys(password);
	}

	public void loginButton() {
		loginButton.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc='More options']")));
	}

	public String usernameText() {
		return usernameText.getText();
	}

	public void clickOnlogOutButton() {
		logoutButton.click();

	}

}
