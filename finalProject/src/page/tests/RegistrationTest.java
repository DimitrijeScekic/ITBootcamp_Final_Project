package page.tests;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.MainPage;
import start.GUImain;
import utility.Config;
import utility.ExcelUtils;

// U OVOJ KLASI NALAZE SE TEST METODE ZA MANUELNO I AUTOMATSKO (ISCITAVANJEM PODATAKA IZ EXCEL TABELE) TESTIRANJE FUNKCIJE REGISTROVANJA NA SAJT IZLET

public class RegistrationTest {

	// METODA ZA MANUELNO TESTIRANJE REGISTRATION FUNKCIJE SAJTA.
	// PREKO SKENERA UNOSI TRAZENE PODATKE A ZATIM SALJE ZAHTEV ZA REGISTRACIJU
	// JEDNOG KORISNIKA

	public static void registration() throws Exception {

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name:");
		String firstName = sc.nextLine();
		System.out.println("Enter last name:");
		String lastName = sc.nextLine();
		System.out.println("Enter user name:");
		String userName = sc.nextLine();

		String emailaddress;
		boolean b = false;
		do {
			System.out.println("Enter email address ex:xyz@gmail.com");
			emailaddress = sc.nextLine();
			// OBEZBEDJIVANJE PRAVILNOG UNOSA EMAIL ADRESE.
			String email_regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			b = emailaddress.matches(email_regex);
		} while (!b);

		String password;
		boolean bp = false;
		do {
			System.out.println(
					"Enter password which must contains 6 to 20 characters string with at least one digit, one upper case letter, one lower case letter and one special symbol (�@#$%?!�)");
			password = sc.nextLine();
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
		sc.close();
		driver.close();
	}
	
	// GUI METODA ZA TESTIRANJE REGISTRATION FUNKCIONALNOSTI SAJTA
	
	public static void registrationGUI() throws Exception {

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
					"Enter password which must contains 6 to 20 characters string with at least one digit, one upper case letter, one lower case letter and one special symbol (�@#$%?!�)",
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
		driver.close();
	}
	
	// METODA ZA TESTIRANJE REGISTRATION FUNKCIJE SAJTA UCITAVANJEM PODATAKA ZA
	// JEDNOG KORISNIKA IZ PRILOZENE EXCEL TABELE

	public static void registrationExcel() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		MainPage.openPage(driver, Config.URL_HOME);

		String data;

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

		data = ExcelUtils.getCellData(1, 0);
		MainPage.sendKeys(driver, MainPage.FIRST_NAME_REG, data);
		Thread.sleep(1000);
		data = ExcelUtils.getCellData(1, 1);
		MainPage.sendKeys(driver, MainPage.LAST_NAME_REG, data);
		Thread.sleep(1000);
		data = ExcelUtils.getCellData(1, 2);
		MainPage.sendKeys(driver, MainPage.USER_NAME_REG, data);
		Thread.sleep(1000);
		data = ExcelUtils.getCellData(1, 3);
		MainPage.sendKeys(driver, MainPage.EMAIL_REG, data);
		Thread.sleep(1000);
		data = ExcelUtils.getCellData(1, 4);
		MainPage.sendKeys(driver, MainPage.PASSWORD_REG, data);
		Thread.sleep(1000);
		MainPage.clickRegister(driver);
		;

	}

	// METODA ZA TESTIRANJE REGISTRATION FUNKCIJE SAJTA UCITAVANJEM PODATAKA SVIH
	// KORISNIKA IZ PRILOZENE EXCEL TABELE

	public static void registrationExcelAll() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		MainPage.openPage(driver, Config.URL_HOME);

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

		int rowcount = ExcelUtils.getExcelWSheet().getLastRowNum();

		String fields[][] = new String[rowcount + 1][5];

		for (int j = 1; j <= rowcount; j++) { // PETLJA KOJA UCITAVA SVE REDOVE EXCEL TABELE

			for (int i = 0; i < 5; i++) { // PETLJA KOJA UCITAVA SVE KOLONE EXCEL TABELE

				fields[j][i] = ExcelUtils.getCellData(j, i);
			}
			MainPage.sendKeys(driver, MainPage.FIRST_NAME_REG, fields[j][0]);
			Thread.sleep(1000);
			MainPage.sendKeys(driver, MainPage.LAST_NAME_REG, fields[j][1]);
			Thread.sleep(1000);
			MainPage.sendKeys(driver, MainPage.USER_NAME_REG, fields[j][2]);
			Thread.sleep(1000);
			MainPage.sendKeys(driver, MainPage.EMAIL_REG, fields[j][3]);
			Thread.sleep(1000);
			MainPage.sendKeys(driver, MainPage.PASSWORD_REG, fields[j][4]);
			Thread.sleep(1000);
			MainPage.clickRegister(driver);
			Thread.sleep(3000);
		}
		driver.close();
	}

}
