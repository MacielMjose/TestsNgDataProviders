package testng;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utilities.Xls_Reader;

import util.TestUtil;

public class GoogleSearchTests {
 
private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	@DataProvider
	private Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData("Planilha1");
		return data;
	}

	@Test(dataProvider = "getTestData")
	public void pesquisaNoGoogle(String termoPesquisa) {
		driver.findElement(
				By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(termoPesquisa);
		driver.findElement(
				By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.ENTER);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}