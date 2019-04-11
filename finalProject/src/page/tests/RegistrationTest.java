package page.tests;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.RegLogPage;
import start.GUImain;
import utility.Config;
import utility.ExcelUtils;

public class RegistrationTest {


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
			String email_regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			b = emailaddress.matches(email_regex);
		} while (!b);

		String password;
		boolean bp = false;
		do {
			System.out.println(
					"Enter password which must contains 6 to 20 characters string with at least one digit, one upper case letter, one lower case letter and one special symbol (“@#$%?!”)");
			password = sc.nextLine();

			String password_regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%?!]).{6,20})";
			bp = password.matches(password_regex);
		} while (!bp);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		RegLogPage.sendKeys(driver, RegLogPage.FIRST_NAME_REG, firstName);
		Thread.sleep(1000);
		RegLogPage.sendKeys(driver, RegLogPage.LAST_NAME_REG, lastName);
		Thread.sleep(1000);
		RegLogPage.sendKeys(driver, RegLogPage.USER_NAME_REG, userName);
		Thread.sleep(1000);
		RegLogPage.sendKeys(driver, RegLogPage.EMAIL_REG, emailaddress);
		Thread.sleep(1000);
		RegLogPage.sendKeys(driver, RegLogPage.PASSWORD_REG, password);
		Thread.sleep(1000);
		RegLogPage.clickRegister(driver);
		Thread.sleep(3000);
		sc.close();
		driver.close();
	}
	
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

			String password_regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%?!]).{6,20})";
			bp = password.matches(password_regex);
		} while (!bp);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		RegLogPage.sendKeys(driver, RegLogPage.FIRST_NAME_REG, firstName);
		Thread.sleep(1000);
		RegLogPage.sendKeys(driver, RegLogPage.LAST_NAME_REG, lastName);
		Thread.sleep(1000);
		RegLogPage.sendKeys(driver, RegLogPage.USER_NAME_REG, userName);
		Thread.sleep(1000);
		RegLogPage.sendKeys(driver, RegLogPage.EMAIL_REG, emailaddress);
		Thread.sleep(1000);
		RegLogPage.sendKeys(driver, RegLogPage.PASSWORD_REG, password);
		Thread.sleep(1000);
		RegLogPage.clickRegister(driver);
		Thread.sleep(3000);
		driver.close();
	}

	public static void registrationExcel() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		String data;

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

		data = ExcelUtils.getCellData(1, 0);
		RegLogPage.sendKeys(driver, RegLogPage.FIRST_NAME_REG, data);
		Thread.sleep(1000);
		data = ExcelUtils.getCellData(1, 1);
		RegLogPage.sendKeys(driver, RegLogPage.LAST_NAME_REG, data);
		Thread.sleep(1000);
		data = ExcelUtils.getCellData(1, 2);
		RegLogPage.sendKeys(driver, RegLogPage.USER_NAME_REG, data);
		Thread.sleep(1000);
		data = ExcelUtils.getCellData(1, 3);
		RegLogPage.sendKeys(driver, RegLogPage.EMAIL_REG, data);
		Thread.sleep(1000);
		data = ExcelUtils.getCellData(1, 4);
		RegLogPage.sendKeys(driver, RegLogPage.PASSWORD_REG, data);
		Thread.sleep(1000);
		RegLogPage.clickRegister(driver);
		;

	}

	public static void registrationExcelAll() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

		int rowcount = ExcelUtils.getExcelWSheet().getLastRowNum();

		String fields[][] = new String[rowcount + 1][5];

		for (int j = 1; j <= rowcount; j++) { 

			for (int i = 0; i < 5; i++) { 

				fields[j][i] = ExcelUtils.getCellData(j, i);
			}
			RegLogPage.sendKeys(driver, RegLogPage.FIRST_NAME_REG, fields[j][0]);
			Thread.sleep(1000);
			RegLogPage.sendKeys(driver, RegLogPage.LAST_NAME_REG, fields[j][1]);
			Thread.sleep(1000);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME_REG, fields[j][2]);
			Thread.sleep(1000);
			RegLogPage.sendKeys(driver, RegLogPage.EMAIL_REG, fields[j][3]);
			Thread.sleep(1000);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD_REG, fields[j][4]);
			Thread.sleep(1000);
			RegLogPage.clickRegister(driver);
			Thread.sleep(3000);
		}
		driver.close();
	}

}
