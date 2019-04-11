package page.tests;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.DashboardPage;
import page.objects.MainPage;
import start.GUImain;
import utility.Config;
import utility.ExcelUtils;



public class LogInTest {
	
//METODA ZA MANUELNO TESTIRANJE LOGIN FUNKCIJE SAJTA. 
//NAJPRE SALJE ZAHTEV ZA REGISTRACIJU, ONDA SA ISTIM PODACIMA POKUSAVA DA SE ULOGUJE I NA KRAJU SALJE IZVESTAJ O USPESNOSTI TESTA
	
	public static void logIn() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name:");
		String firstName = sc.nextLine();
		System.out.println("Enter last name:");
		String lastName = sc.nextLine();
		System.out.println("Enter user name:");
		String userName = sc.nextLine();
		System.out.println("Enter email:");
		String email = sc.nextLine();
		System.out.println("Enter password:");
		String password = sc.nextLine();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		MainPage.openPage(driver, Config.URL_HOME);
		
		MainPage.sendKeys(driver, MainPage.FIRST_NAME_REG, firstName);
		Thread.sleep(1000);
		MainPage.sendKeys(driver, MainPage.LAST_NAME_REG, lastName);
		Thread.sleep(1000);
		MainPage.sendKeys(driver, MainPage.USER_NAME_REG, userName);
		Thread.sleep(1000);
		MainPage.sendKeys(driver, MainPage.EMAIL_REG, email);
		Thread.sleep(1000);
		MainPage.sendKeys(driver, MainPage.PASSWORD_REG, password);
		Thread.sleep(1000);
		MainPage.clickRegister(driver);
		Thread.sleep(3000);

		MainPage.sendKeys(driver, MainPage.USER_NAME, userName);
		Thread.sleep(1000);
		MainPage.sendKeys(driver, MainPage.PASSWORD, password);
		Thread.sleep(1000);

		MainPage.clickLogIn(driver);

		if (driver.getCurrentUrl().contains(Config.URL_DASHBOARD)) {
			System.out.println("PASS");
		} else
			System.out.println("FAIL");

		DashboardPage.clickLogoutButton(driver);
		sc.close();
		driver.close();
	}
	
	// GUI METODA ZA TESTIRANJE LOG IN FUNKCIONALNOSTI SAJTA 
	
	public static void logInGUI() throws Exception {

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);
		GUImain frame = new GUImain();

		String firstName = (String) JOptionPane.showInputDialog(frame, "Enter first name:",
				JOptionPane.INPUT_VALUE_PROPERTY);
		String lastName = (String) JOptionPane.showInputDialog(frame, "Enter last name:",
				JOptionPane.INPUT_VALUE_PROPERTY);
		String userName = (String) JOptionPane.showInputDialog(frame, "Enter user name:",
				JOptionPane.INPUT_VALUE_PROPERTY);
		
		String emailaddress;
		boolean b = false;
		do {
			emailaddress = (String) JOptionPane.showInputDialog(frame, "Enter email address ex:xyz@gmail.com",
					JOptionPane.INPUT_VALUE_PROPERTY);
			// OBEZBEDJIVANJE PRAVILNOG UNOSA EMAIL ADRESE.
			String email_regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			b = emailaddress.matches(email_regex);
		} while (!b);

		String password;
		boolean bp = false;
		do {
			password = (String) JOptionPane.showInputDialog(frame,
					"Enter password which must contains 6 to 20 characters string with at least one digit, one upper case letter, one lower case letter and one special symbol (“@#$%?!”)",
					JOptionPane.INPUT_VALUE_PROPERTY);
			// OBEZBEDJIVANJE PRAVILNOG UNOSA PASSWORD-a.
			String password_regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%?!]).{6,20})";
			bp = password.matches(password_regex);
		} while (!bp);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		MainPage.openPage(driver, Config.URL_HOME);

		MainPage.sendKeys(driver, MainPage.FIRST_NAME_REG, firstName);
		Thread.sleep(1000);
		MainPage.sendKeys(driver, MainPage.LAST_NAME_REG, lastName);
		Thread.sleep(1000);
		MainPage.sendKeys(driver, MainPage.USER_NAME_REG, userName);
		Thread.sleep(1000);
		MainPage.sendKeys(driver, MainPage.EMAIL_REG, emailaddress);
		Thread.sleep(1000);
		MainPage.sendKeys(driver, MainPage.PASSWORD_REG, password);
		Thread.sleep(1000);
		MainPage.clickRegister(driver);
		Thread.sleep(3000);

		MainPage.sendKeys(driver, MainPage.USER_NAME, userName);
		Thread.sleep(1000);
		MainPage.sendKeys(driver, MainPage.PASSWORD, password);
		Thread.sleep(1000);

		MainPage.clickLogIn(driver);

		if (driver.getCurrentUrl().contains(Config.URL_DASHBOARD)) {
			System.out.println("PASS");
		} else
			System.out.println("FAIL");

		DashboardPage.clickLogoutButton(driver);
		driver.close();
	}
	
	//METODA ZA TESTIRANJE LOGIN FUNKCIJE SAJTA UCITAVANJEM PODATAKA ZA JEDNOG KORISNIKA IZ PRILOZENE EXCEL TABELE 

	public static void logInExcel() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		MainPage.openPage(driver, Config.URL_HOME);

		String data;
		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

		data = ExcelUtils.getCellData(1, 2);
		MainPage.sendKeys(driver, MainPage.USER_NAME, data);
		Thread.sleep(1000);

		data = ExcelUtils.getCellData(1, 4);
		MainPage.sendKeys(driver, MainPage.PASSWORD, data);
		Thread.sleep(1000);

		MainPage.clickLogIn(driver);

	}
	
	//METODA ZA TESTIRANJE LOGIN FUNKCIJE SAJTA UCITAVANJEM PODATAKA SVIH KORISNIKA IZ PRILOZENE EXCEL TABELE 
	//METODA SA UCITANIM PODACIMA POKUSAVA DA SE ULOGUJE I NA KRAJU SALJE IZVESTAJ O USPESNOSTI TESTA ZA SVAKOG KORISNIKA PONAOSOB

	public static void logInExcelAll() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MainPage.openPage(driver, Config.URL_HOME);

		String data;

		try {
			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			int rowcount = ExcelUtils.getExcelWSheet().getLastRowNum();

			for (int i = 1; i <= rowcount; i++) {

				data = ExcelUtils.getCellData(i, 2);
				MainPage.sendKeys(driver, MainPage.USER_NAME, data);
				Thread.sleep(1000);

				data = ExcelUtils.getCellData(i, 4);
				MainPage.sendKeys(driver, MainPage.PASSWORD, data);
				Thread.sleep(1000);

				MainPage.clickLogIn(driver);
				Thread.sleep(2000);
				String testStatus;
				if (driver.getCurrentUrl().contains(Config.URL_DASHBOARD)) {
					testStatus = "PASS";
				} else {
					testStatus = "FAIL";
					ExcelUtils.setCellData(testStatus, i, 5);
					MainPage.openPage(driver, Config.URL_HOME);
					continue;
				}
								driver.close();
			}
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}

	}

}
