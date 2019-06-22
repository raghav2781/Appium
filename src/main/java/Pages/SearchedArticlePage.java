package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ProjectUtility.BaseClass;

public class SearchedArticlePage extends BaseClass {
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc='Add this article to a reading list']")
	private WebElement readingListButton;
	@FindBy(xpath="//android.widget.TextView[@text='My reading list']")
	private WebElement addToReadingList;
	@FindBy(xpath="//android.widget.TextView[@text='Remove from My reading list']")
	private WebElement removeFromReadingList;
	@FindBy(xpath="//android.widget.TextView[@text='Create new']")
	private WebElement createNewList;
	@FindBy(xpath="//android.widget.TextView[@resource-id='org.wikipedia:id/view_page_title_text']")
	private WebElement title;
	@FindBy(xpath="//android.widget.Button[@text='OK']")
	private WebElement okbutton;
	
	
	 public SearchedArticlePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	public void clickOnSaveToReadingList(){
		readingListButton.click();
		
	}
	public void clickOnMyReadingList() throws InterruptedException{
		addToReadingList.click();
		Thread.sleep(7000);
		
	}
	public void removeFromReadingList(){
		removeFromReadingList.click();
		
	}
	public String titleText(){
		return title.getText();
		
	}
	public void landscapeMode(){
		driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	public void portraitMode(){
		driver.rotate(ScreenOrientation.PORTRAIT);
	}
	public void createReadingList(){
		createNewList.click();
	}
	public void clickOnOkButton(){
		okbutton.click();
	}
	public String textOfRemoveMyList(){
		return removeFromReadingList.getText();
	}
	public String textOfCreateNewList(){
		return createNewList.getText();
	}
	

}
