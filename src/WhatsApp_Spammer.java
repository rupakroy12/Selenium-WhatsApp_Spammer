import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WhatsApp_Spammer {

	public static void main(String args[]) throws Exception {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);

		driver.get("https://web.whatsapp.com/");

		String message;
		String confirm;
		int number;

		Scanner sc = new Scanner(System.in);

		while (true) {

			try {
				System.out.println("Enter Message : ");
				message = sc.nextLine();

				System.out.println("Enter number of messages : ");
				number = sc.nextInt();

				System.out.println("Are You sure, You want to spam  "
						+ driver.findElement(By.xpath("//*[@class=\"_amig\"]")).getText()
						+ " ?");
				System.out.println("Type Y to continue : ");

				sc.nextLine();
				confirm = sc.nextLine();

				if (confirm.equalsIgnoreCase("Y")) {
					for (int i = 1; i <= number; i++) {
						try {
							driver.findElement(By.xpath("(//*[@contenteditable=\"true\" and @role=\"textbox\"])[2]"))
									.sendKeys(message + Keys.ENTER);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					System.out.println(number + " messages sent successfully to "
							+ driver.findElement(By.xpath("//*[@class=\"_amig\"]")).getText());
					System.out.println("___________________________________________");

				} else {
					System.out.println("Sorry, you did not type Y");
					System.out.println("___________________________________________");
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("___________________________________________");

			}

		}

	}
}
