package framework;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import framework.ExcelUtils;

public class ExcelDataProvider {
	static String projectPath;
	static WebDriver driver;
	static WebDriver fdriver;
	
	public static void setupChrome() throws InterruptedException {
		projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		}
	
	public static void setupFirefox() throws InterruptedException {
		projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
		fdriver = new FirefoxDriver();
		
		fdriver.manage().window().maximize();
		fdriver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		}
	
	public static void CheckLogin(String Username, String Password) throws InterruptedException{
		WebElement U = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		Thread.sleep(2000);
		U.click();
		U.sendKeys(Username);
		WebElement P = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
		Thread.sleep(2000);
		P.click();
		P.sendKeys(Password);
		P.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		Boolean result = driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")).isDisplayed();
		System.out.println(result);
		Thread.sleep(5000);
	}
	
	public static void FCheckLogin(String Username1, String Password1) throws InterruptedException{
		WebElement U = fdriver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		Thread.sleep(2000);
		U.click();
		U.sendKeys(Username1);
		WebElement P = fdriver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
		Thread.sleep(2000);
		P.click();
		P.sendKeys(Password1);
		P.sendKeys(Keys.RETURN);
		Thread.sleep(5000);
	}
	
	public static void CheckLocation(String Pincode) throws InterruptedException{
		WebElement cart = driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[5]/div/div/a/span"));
		cart.click();
		Thread.sleep(2000);
		WebElement pincode = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/div[1]/div[1]/div[1]/div[2]/div/div[2]/input"));
		pincode.click();
		pincode.sendKeys(Pincode);
		pincode.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		Boolean result = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/ul[1]/li/div")).isDisplayed();
		System.out.println(result);
	}
	
	public static void FCheckLocation(String Pincode) throws InterruptedException{
		WebElement cart = fdriver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[5]/div/div/a/span"));
		cart.click();
		Thread.sleep(2000);
		WebElement pincode = fdriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[1]/div[1]/div[2]/div/div[2]/input"));
		pincode.click();
		pincode.sendKeys(Pincode);
		pincode.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		Boolean result = fdriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/ul[1]/li/div")).isDisplayed();
		System.out.println(result);
	}
	
	public static void Add() throws InterruptedException{
		WebElement add = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/div/button[2]"));
		add.click();
		Thread.sleep(2000);
	}
	
	public static void FAdd() throws InterruptedException{
		WebElement add = fdriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/div/button[2]"));
		add.click();
		Thread.sleep(2000);
	}
	
	public static void Remove() throws InterruptedException{
		WebElement remove = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]"));
		Thread.sleep(2000);
		remove.click();
		Thread.sleep(2000);
		WebElement confirm = driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[3]/div/div[2]"));
		Thread.sleep(2000);
		confirm.click();
	}
	
	public static void FRemove() throws InterruptedException{
		WebElement remove = fdriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[1]"));
		Thread.sleep(2000);
		remove.click();
		Thread.sleep(2000);
		/*WebElement confirm = fdriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div[2]"));
		Thread.sleep(2000);
		confirm.click();*/
	}
	
	public void failed(String arg0){
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(projectPath+"\\Screenshots\\"+arg0+".png"));
			System.out.println(arg0);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	
	@DataProvider(name="testdata")
	public Object[][] getdata(){
		String projectPath = System.getProperty("user.dir");
		Object[][] data = testdata(projectPath +"\\Data\\data.xlsx","Sheet1");
		return data;
	}
	
	@DataProvider(name="locationdata")
	public Object[][] data(){
		String projectPath = System.getProperty("user.dir");
		Object[][] data = locdata(projectPath +"\\Data\\data.xlsx","Sheet2");
		return data;
	}
	
	public Object[][] testdata(String excelpath, String sheet){
		ExcelUtils excel = new ExcelUtils(excelpath,sheet);
		int RowCount = excel.getRowNo();
		int ColCount = excel.getColumnNo();
		
		Object Data[][] = new Object[RowCount-1][ColCount];
		
		for(int i=1; i<RowCount; i++){
			for(int j=0;j<ColCount; j++){
				String celldata = excel.getCellDataString(i, j);
				System.out.print(celldata+" | ");
				Data[i-1][j] = celldata;
			}
			System.out.println();
		}
		return Data;
	}
	
	public Object[][] locdata(String excelpath, String sheet){
		ExcelUtils excel = new ExcelUtils(excelpath,sheet);
		int RowCount = excel.getRowNo();
		int ColCount = excel.getColumnNo();
		
		Object Data[][] = new Object[RowCount-1][ColCount];
		
		for(int i=1; i<RowCount; i++){
			for(int j=0;j<ColCount; j++){
				String celldata = excel.getCellDataNumeric(i, j);
				System.out.print(celldata);
				Data[i-1][j] = celldata;
			}
			System.out.println();
		}
		return Data;
	}

}