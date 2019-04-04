package page.tests;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.DashboardPage;
import page.objects.MainPage;
import utility.Config;
import utility.ExcelUtils;

//U OVOJ KLASI NALAZE SE TEST METODE ZA MANUELNO I AUTOMATSKO (ISCITAVANJEM PODATAKA IZ EXCEL TABELE) 
//FUNKCIONALNO TESTIRANJE STRANICE DASHBOARD SAJTA IZLET

public class DashboardPageTest {
	
	//METODA ZA MANUELNO TESTIRANJE FUNKCIJE PRAVLJENJA NOVOG POSTA STRANICE UCITAVANJEM TRAZENIH PODATAKA SA SKENERA

	public static void makeNewPost() throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter post name:");
		String postName = sc.nextLine();
		System.out.println("Enter location:");
		String location = sc.nextLine();
		System.out.println("Enter path for image:");
		String path = sc.nextLine();
		String type;
		// WHILE PETLJA KOJA TREBA DA OBEZBIJEDI PONAVLJANJE ZAHTEVA ZA UNOS SVE DOK SE NE UNESE DOZVOLJENA VRIJEDNOST
		while(true) {
		System.out.println("Enter travel type: Bicycle,Walk,Car,Motorbike or Bus");
		type = sc.nextLine().toLowerCase();
		if(type.equals("bicycle") || type.equals("walk") || type.equals("motorbike") || type.equals("bus") || type.equals("car") )
		// VRACA NAZIV PREVOZNOG SREDSTVA SA POCETNIM VELIKIM I OSTALIM MALIM SLOVIMA BEZ OBZIRA NA NACIN UNOSA
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

	//METODA ZA AUTOMATSKO TESTIRANJE FUNKCIJE PRAVLJENJA NOVOG POSTA STRANICE UCITAVANJEM TRAZENIH PODATAKA IZ PRILOZENOG EXCEL FAJLA NASUMICNIM ODABIROM
	
	public static void makeNewPostExcel() throws Exception {

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

		DashboardPage.clickMakePostButton(driver);

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME2);

		int size = 100;
		int rando = (int) (Math.random() * (size + 1)); // METODA ZA NASUMICNI ODABIR

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

	//METODA ZA MANUELNO TESTIRANJE FUNKCIJE NAKNADNOG MENJANJA POSTA STRANICE UCITAVANJEM TRAZENIH PODATAKA SA SKENERA
	
	public static void editLastPost() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new description:");
		String newPostDescriptionText = sc.nextLine();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		MainPage.openPage(driver, Config.URL_HOME);

		try {
			String data;

			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			MainPage.sendKeys(driver, MainPage.USER_NAME, data);
			Thread.sleep(1000);

			data = ExcelUtils.getCellData(1, 4);
			MainPage.sendKeys(driver, MainPage.PASSWORD, data);
			Thread.sleep(1000);

			MainPage.clickLogIn(driver);

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

	//POMOCNA METODA ZA AUTOMATSKO KREIRANJE 2 NOVA POSTA UCITAVANJEM TRAZENIH PODATAKA IZ PRILOZENOG EXCEL FAJLA NASUMICNIM ODABIROM
	// SLUZI KAO POMOCNA METODA METODI  deleteTwoLastPost(), 
	//ZATO STO TREBA DA NAPRAVI TEST NEZAVISNIM JER NE MOZETE IZBRISATI POSTOVE KOJI NISU NI NAPRAVLJENI
	// PA U TOM SLUCAJU SAM TEST NE BI MOGAO DA SE IZVRSI 
	
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

	//POMOCNA METODA ZA AUTOMATSKO BRISANJE 2 NAJNOVIJA POSTA
	
	public static void deleteTwoLastPost() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		MainPage.openPage(driver, Config.URL_HOME);

		try {
			String data;

			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			MainPage.sendKeys(driver, MainPage.USER_NAME, data);
			Thread.sleep(1000);

			data = ExcelUtils.getCellData(1, 4);
			MainPage.sendKeys(driver, MainPage.PASSWORD, data);
			Thread.sleep(1000);

			MainPage.clickLogIn(driver);
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
