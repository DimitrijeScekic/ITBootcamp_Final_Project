package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// U OVOJ KLASI NALAZE SE STATICKE PROMENJIVE TYPA By KOJE SU USTVARI PUTANJE KA ELEMENTIMA POCETNE STRANICE SAJTA IZLET.
// TAKODJE, TU SU I POMOCNE METODE ZA PRISTUPANJE I SELEKTOVANJE POMENUTIH ELEMENATA, KAO I ZA SLANJE VREDNOSTI ISTIMA
// KORISTI SE ZA REGISTRATION I LOGIN TESTIRANJE

public class MainPage {
	
	public static void openPage(WebDriver driver, String address) {
		driver.get(address);
	}
	
	public static void navigateTo(WebDriver driver, String address) {
		driver.navigate().to(address);
	}
	
	// ODABIR ELEMENATA NA STRANICI
    public static WebElement getElement (WebDriver driver, By element) {
        WebElement wb=driver.findElement(element);
        return wb;
    }
        
 // SLANJE VREDNOSTI U ODABRANI ELEMENT STRANICE
    public static void sendKeys (WebDriver driver, By element, String data) {
        getElement(driver,element).sendKeys(data);;
       }
	
	public static WebElement getLogIn(WebDriver driver) {
		WebElement element=driver.findElement(LOG_IN_BUTTON);
		return element;		
	}
	
	public static void clickLogIn(WebDriver driver) {
		getLogIn(driver).click();	
	}
	
	public static WebElement getRegister(WebDriver driver) {
		WebElement element=driver.findElement(REGISTER_BUTTON);
		return element;		
	}
	
	public static void clickRegister(WebDriver driver) {
		getRegister(driver).click();		
	}	
	
	public static final By USER_NAME = By.xpath("//input[@placeholder='username']");
	public static final By PASSWORD = By.xpath("//input[@placeholder='password']");
	public static final By LOG_IN_BUTTON = By.xpath("//input[@value='Log in']");
	public static final By FIRST_NAME_REG = By.xpath("//input[@name='firstname']");
	public static final By LAST_NAME_REG = By.xpath("//input[@name='lastname']");
	public static final By USER_NAME_REG = By.xpath("//form[@action='processregister.php']//input[@name='username']");
	public static final By EMAIL_REG = By.xpath("//input[@name='email']");
	public static final By PASSWORD_REG = By.xpath("//form[@action='processregister.php']//input[@name='password']");
	public static final By REGISTER_BUTTON = By.xpath("//input[@id='blue_btn']");
}
