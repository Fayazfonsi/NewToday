package Today;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public class NewTest {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	WebDriverWait wait1;

	@Test(priority = 0)
	public void element() {
		driver.findElement(By.xpath("(//li)[1]")).click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div)[55]")));

		driver.findElement(By.cssSelector("#userName")).sendKeys("Yaz");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("fayazfonsi@gmail.com");

		js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(240,340)");

		wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#submit")));

		driver.findElement(By.cssSelector("#currentAddress")).sendKeys("kovilmeadu, Coimbatore - 641025");

		driver.findElement(By.cssSelector("#permanentAddress")).sendKeys("edayarpaliyam, coimbatore - 641025");
		driver.findElement(By.cssSelector("#submit")).click();

	}

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\chrome driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/elements");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

	}

	@AfterSuite
	public void afterSuite() {
		driver.close();
	}

}
