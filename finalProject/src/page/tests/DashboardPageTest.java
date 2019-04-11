package page.tests;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.DashboardPage;
import page.objects.RegLogPage;
import start.GUImain;
import utility.Config;
import utility.ExcelUtils;



public class DashboardPageTest {
	

	public static void makeNewPost() throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter post name:");
		String postName = sc.nextLine();
		System.out.println("Enter location:");
		String location = sc.nextLine();
		System.out.println("Enter path for image:");
		String path = sc.nextLine();
		String type;
		
		while(true) {
		System.out.println("Enter travel type: Bicycle,Walk,Car,Motorbike or Bus");
		type = sc.nextLine().toLowerCase();
		if(type.equals("bicycle") || type.equals("walk") || type.equals("motorbike") || type.equals("bus") || type.equals("car") )
	
		type = type.substring(0,1).toUpperCase() + type.substring(1).toLowerCase();  
		else {
		System.out.println("Invalid input");
		continue;
		}
		break;
	}
	
		System.out.println("Enter description text:");
		String description = sc.nextLine();
		sc.close();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			RegLogPage.openPage(driver, Config.URL_HOME);

			String data;
			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);
			Thread.sleep(1000);

			data = ExcelUtils.getCellData(1, 4);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);
			Thread.sleep(1000);

			RegLogPage.clickLogIn(driver);

			DashboardPage.clickMakePostButton(driver);
			DashboardPage.sendKeys(driver, DashboardPage.POST_NAME, postName);
			DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_LOCATION, location);
			DashboardPage.insertFiles(driver, path);
			DashboardPage.getTravelType(driver);
			DashboardPage.setTravelType(driver, type);
			DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_DESCRIPTION, description);
			DashboardPage.clickSavePostButton(driver);
			
			driver.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public static void makeNewPostGUI() throws InterruptedException {
		
		GUImain frame = new GUImain();

		String postName = (String) JOptionPane.showInputDialog(frame, "Enter post name:",
				JOptionPane.INPUT_VALUE_PROPERTY);
		String location = (String) JOptionPane.showInputDialog(frame, "Enter location:",
				JOptionPane.INPUT_VALUE_PROPERTY);
		//String imagePath = (String) JOptionPane.showInputDialog(frame, "Enter path for image:",
				//JOptionPane.INPUT_VALUE_PROPERTY);
		
		String type;
		while(true) {
		String travelType = (String) JOptionPane.showInputDialog(frame, "Enter travel type: Bicycle,Walk,Car,Motorbike or Bus",
				JOptionPane.INPUT_VALUE_PROPERTY);
		type = travelType.toLowerCase();
		if(type.equals("bicycle") || type.equals("walk") || type.equals("motorbike") || type.equals("bus") || type.equals("car") )

		type = type.substring(0,1).toUpperCase() + type.substring(1).toLowerCase();  
		else {
		continue;
		}
		break;
	}
		String description = (String) JOptionPane.showInputDialog(frame, "Enter description text:",
				JOptionPane.INPUT_VALUE_PROPERTY);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			RegLogPage.openPage(driver, Config.URL_HOME);

			String data;
			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);
			Thread.sleep(1000);

			data = ExcelUtils.getCellData(1, 4);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);
			Thread.sleep(1000);

			RegLogPage.clickLogIn(driver);

			DashboardPage.clickMakePostButton(driver);
			DashboardPage.sendKeys(driver, DashboardPage.POST_NAME, postName);
			DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_LOCATION, location);
		//	DashboardPage.insertFiles(driver, imagePath);
			DashboardPage.getTravelType(driver);
			DashboardPage.setTravelType(driver, type);
			DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_DESCRIPTION, description);
			DashboardPage.clickSavePostButton(driver);
			
			driver.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public static void makeNewPostExcel() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		String data;
		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

		data = ExcelUtils.getCellData(1, 2);
		RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);
		Thread.sleep(1000);

		data = ExcelUtils.getCellData(1, 4);
		RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);
		Thread.sleep(1000);

		RegLogPage.clickLogIn(driver);

		DashboardPage.clickMakePostButton(driver);

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME2);

		int size = 100;
		int rando = (int) (Math.random() * (size + 1)); 

		data = ExcelUtils.getCellData(rando, 1);
		DashboardPage.sendKeys(driver, DashboardPage.POST_NAME, data);
		data = ExcelUtils.getCellData(rando, 2);
		DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_LOCATION, data);
		DashboardPage.insertFiles(driver, Config.BROWSE_INPUT);
		DashboardPage.getTravelType(driver);
		DashboardPage.setTravelType(driver, "Bicycle");
		data = ExcelUtils.getCellData(rando, 0);
		DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_DESCRIPTION, data);
		DashboardPage.clickSavePostButton(driver);
		DashboardPage.clickLogoutButton(driver);
		driver.close();
	}
	
	public static void editLastPostExcelGUI() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		String data;
		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

		data = ExcelUtils.getCellData(1, 2);
		RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);
		Thread.sleep(1000);

		data = ExcelUtils.getCellData(1, 4);
		RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);
		Thread.sleep(1000);

		RegLogPage.clickLogIn(driver);

		DashboardPage.editPostButton(driver);

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME2);

		int size = 100;
		int rando = (int) (Math.random() * (size + 1)); // METODA ZA NASUMICNI ODABIR
        data = ExcelUtils.getCellData(rando, 0);
		DashboardPage.editPostDescription(driver,data);
		//DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_DESCRIPTION, data);
		DashboardPage.clickPostChangeSave(driver);
		DashboardPage.clickLogoutButton(driver);
		driver.close();
	}
	
	public static void editLastPost() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new description:");
		String newPostDescriptionText = sc.nextLine();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		try {
			String data;

			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);
			Thread.sleep(1000);

			data = ExcelUtils.getCellData(1, 4);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);
			Thread.sleep(1000);

			RegLogPage.clickLogIn(driver);

			DashboardPage.editPostButton(driver);

			DashboardPage.editPostDescription(driver, newPostDescriptionText);
			Thread.sleep(2000);
			DashboardPage.clickPostChangeSave(driver);
			Thread.sleep(2000);
			sc.close();
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void editLastPostGUI() {
		
		GUImain frame = new GUImain();

		String newPostDescriptionText = (String) JOptionPane.showInputDialog(frame, "Enter description text:",
				JOptionPane.INPUT_VALUE_PROPERTY);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		try {
			String data;

			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);
			Thread.sleep(1000);

			data = ExcelUtils.getCellData(1, 4);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);
			Thread.sleep(1000);

			RegLogPage.clickLogIn(driver);

			DashboardPage.editPostButton(driver);

			DashboardPage.editPostDescription(driver, newPostDescriptionText);
			Thread.sleep(2000);
			DashboardPage.clickPostChangeSave(driver);
			Thread.sleep(2000);
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void makeTwoPostExcel(WebDriver driver) {

		try {
			for (int i = 0; i < 2; i++) {
				DashboardPage.clickMakePostButton(driver);

				ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME2);
				String data;
				int size = 100;
				int rando = (int) (Math.random() * (size + 1));

				data = ExcelUtils.getCellData(rando, 1);
				DashboardPage.sendKeys(driver, DashboardPage.POST_NAME, data);
				data = ExcelUtils.getCellData(rando, 2);
				DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_LOCATION, data);
				DashboardPage.insertFiles(driver, Config.BROWSE_INPUT);
				DashboardPage.getTravelType(driver);
				DashboardPage.setTravelType(driver, "Bicycle");
				data = ExcelUtils.getCellData(rando, 0);
				DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_DESCRIPTION, data);
				DashboardPage.clickSavePostButton(driver);
				Thread.sleep(2000);
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTwoLastPost() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		try {
			String data;

			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);
			Thread.sleep(1000);

			data = ExcelUtils.getCellData(1, 4);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);
			Thread.sleep(1000);

			RegLogPage.clickLogIn(driver);
			makeTwoPostExcel(driver);

			for (int i = 0; i < 2; i++) {
				DashboardPage.deletePostButton(driver);
				Thread.sleep(2000);
			}
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
