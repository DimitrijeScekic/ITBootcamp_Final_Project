package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage {	
	
	public static WebElement getElement(WebDriver driver, By element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement wb = wait.until(ExpectedConditions.elementToBeClickable(element));
		return wb;
	}

	public static void sendKeys(WebDriver driver, By element, String value) {
		getElement(driver, element).sendKeys(value);
		;
	}

	public static WebElement getMakePost(WebDriver driver) {
		WebElement element = driver.findElement(MAKE_A_POST_BUTTON);
		return element;
	}

	public static void clickMakePostButton(WebDriver driver) {
		getMakePost(driver).click();
	}

	public static WebElement getSavePostButton(WebDriver driver) {
		WebElement element = driver.findElement(POST_BUTTON);
		return element;
	}

	public static void clickSavePostButton(WebDriver driver) {
		getSavePostButton(driver).click();
	}

	public static WebElement getLogoutButton(WebDriver driver) {
		WebElement element = driver.findElement(LOGOUT_BUTTON);
		return element;
	}

	public static void clickLogoutButton(WebDriver driver) {
		getLogoutButton(driver).click();
	}

	public static WebElement getBrowseButton(WebDriver driver) {
		WebElement element = driver.findElement(BROWSE_BUTTON);
		return element;
	}

	public static void insertFiles(WebDriver driver, String input) {
		driver.findElement(By.id("image")).sendKeys(input);
	}

	public static WebElement getTravelType(WebDriver driver) {
		WebElement element = driver.findElement(TRAVEL_TYPE);
		return element;
	}

	public static void clickTravelType(WebDriver driver) {
		getTravelType(driver).click();

	}

	public static void setTravelType(WebDriver driver, String input) {
		Select travelType = new Select(driver.findElement(TRAVEL_TYPE));
		travelType.selectByVisibleText(input);
	}

	public static WebElement getMenuPostButton(WebDriver driver) {
		WebElement element = driver.findElement(MENU_POST_BUTTON);
		return element;
	}

	public static void postMenuButton(WebDriver driver) {
		List<WebElement> menu = driver.findElements(MENU_POST_BUTTON);
		menu.get(0).click();
	}

	public static void editPostButton(WebDriver driver) {
		postMenuButton(driver);
		List<WebElement> edit = driver.findElements(EDIT_POST_BUTTON);
		edit.get(0).click();
	}
	
	public static void editPostDescription(WebDriver driver, String value) {
		WebElement element = driver.findElement(TRAVEL_DESCRIPTION_CHANGE);
			element.clear();
			element.sendKeys(value);
	}
	
	public static WebElement getPostChangeSave(WebDriver driver) {
		WebElement element = driver.findElement(POST_CHANGE_SAVE);
		return element;
	}

	public static void clickPostChangeSave(WebDriver driver) {
		getPostChangeSave(driver).click();
	}
	
	public static void deletePostButton(WebDriver driver) {
		postMenuButton(driver);
		List<WebElement> delete = driver.findElements(DELETE_POST_BUTTON);
		delete.get(0).click();
	}
	
	public static final By MAKE_A_POST_BUTTON = By.xpath("//a[contains(text(),'Make a post')]");
	public static final By LOGOUT_BUTTON = By.xpath("//a[@id='logoutBtn']");
	public static final By POST_NAME = By.xpath("//input[@placeholder='Naziv']");
	public static final By TRAVEL_LOCATION = By.xpath("//input[@placeholder='Lokacija']");
	public static final By BROWSE_BUTTON = By.xpath("//label[@class='custom-file-upload']");
	public static final By TRAVEL_TYPE = By.xpath("//select[@name='transport']");
	public static final By TRAVEL_DESCRIPTION = By.xpath("//textarea[@placeholder='Opis']");
	public static final By POST_BUTTON = By.xpath("//input[@value='Post']");
	public static final By MENU_POST_BUTTON = By.className("fa-ellipsis-v");
	public static final By DELETE_POST_BUTTON = By.className("fa-trash-alt");
	public static final By EDIT_POST_BUTTON = By.className("fa-edit");
	public static final By TRAVEL_DESCRIPTION_CHANGE = By.xpath("//textarea[@id='description']");
	public static final By POST_CHANGE_SAVE = By.xpath("//div[@class='popupEdit']//input[@value='Post']");

}
