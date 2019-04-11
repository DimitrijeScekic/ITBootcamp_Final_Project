package start;

import java.util.Scanner;

import page.tests.DashboardPageTest;
import page.tests.LogInTest;
import page.tests.RegistrationTest;

public class Main {

	public static void main(String[] args) throws Exception {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(" \n                                     Web-site IZLET Testing: \n ");
			System.out.println(
					" Type: logInTest or registrationTest or makeNewPostTest or deleteTwoLastPostTest or editLastPostTest ");

			String test = sc.nextLine().toUpperCase();
			test = test.replaceAll("\\s", "");

			switch (test) {

			case "LOGINTEST":
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
