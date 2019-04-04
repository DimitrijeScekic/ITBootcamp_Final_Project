package start;

import java.util.Scanner;

import page.tests.DashboardPageTest;
import page.tests.LogInTest;
import page.tests.RegistrationTest;

public class Glavna { 

	public static void main(String[] args) throws Exception {
		
		// WHILE PETLJA KOJA TREBA DA OBEZBIJEDI PONAVLJANJE ZAHTEVA ZA UNOS SVE DOK SE NE UNESE DOZVOLJENA VRIJEDNOST
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(" \n                                     Web-site IZLET Testing: \n ");
			System.out.println(
					" Type: logInTest or registrationTest or makeNewPostTest or deleteTwoLastPostTest or editLastPostTest ");

			String test = sc.nextLine().toUpperCase();            // PRETVARA ZVA SLOVA U VELIKA
			test = test.replaceAll("\\s", "");                   // BRISE SVA PRAZNA POLJA U STRINGU
			
			switch (test) {

			case "LOGINTEST":
				// WHILE PETLJA KOJA TREBA DA OBEZBIJEDI PONAVLJANJE ZAHTEVA ZA UNOS SVE DOK SE NE UNESE DOZVOLJENA VRIJEDNOST
				while (true) {
					System.out.println("Type MANUAL or AUTOMATIC ");
					String option = sc.nextLine().toUpperCase();
					if (option.equals("MANUAL")) {
						LogInTest.logIn();
					} else if (option.equals("AUTOMATIC")) {
						LogInTest.logInExcelAll();
					} else {
						System.out.println("Invalid input");
						continue;
					}
					break;
				}

			case "REGISTRATIONTEST":
				// WHILE PETLJA KOJA TREBA DA OBEZBIJEDI PONAVLJANJE ZAHTEVA ZA UNOS SVE DOK SE NE UNESE DOZVOLJENA VRIJEDNOST
				while (true) {
					System.out.println("Type MANUAL or AUTOMATIC ");
					String option2 = sc.nextLine().toUpperCase();
					if (option2.equals("MANUAL")) {
						RegistrationTest.registration();
					} else if (option2.equals("AUTOMATIC")) {
						RegistrationTest.registrationExcelAll();
					} else {
						System.out.println("Invalid input");
						continue;
					}
					break;
				}

			case "MAKENEWPOSTTEST":
				// WHILE PETLJA KOJA TREBA DA OBEZBIJEDI PONAVLJANJE ZAHTEVA ZA UNOS SVE DOK SE NE UNESE DOZVOLJENA VRIJEDNOST
				while (true) {
					System.out.println("Type MANUAL or AUTOMATIC ");
					String option3 = sc.nextLine().toUpperCase();
					if (option3.equals("MANUAL")) {
						DashboardPageTest.makeNewPost();
						Thread.sleep(3000);
						DashboardPageTest.makeNewPost();
					} else if (option3.equals("AUTOMATIC")) {
						DashboardPageTest.makeNewPostExcel();
						DashboardPageTest.makeNewPostExcel();
					} else {
						System.out.println("Invalid input");
						continue;
					}
					break;
				}

			case "EDITLASTPOSTTEST":

				DashboardPageTest.editLastPost();

				break;

			case "DELETETWOLASTPOSTTEST":

				DashboardPageTest.deleteTwoLastPost();

				break;

			default:
				System.out.println("Invalid input");
				continue;
			}
			sc.close();
			break;
		}

	}

}
