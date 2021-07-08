package framework;

import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(FailedSS.class)
public class flipkart extends ExcelDataProvider {

		@BeforeClass
		public static void initializing() throws InterruptedException{
			setupChrome();	
		}
		
		@Test(dataProvider = "testdata", priority = 0)
		public static void Login(String Username, String Password) throws InterruptedException{
			CheckLogin(Username, Password);
		}
		
		@Test(dataProvider = "locationdata", priority = 1, dependsOnMethods={"Login"})
		public static void Location(String Pincode) throws InterruptedException{
			CheckLocation(Pincode);
		}
		
		@Test(priority = 2, dependsOnMethods={"Location"})
		public static void AddContents() throws InterruptedException{
			Add();
		}
		
		@Test(priority = 3, dependsOnMethods={"Location"})
		public static void RemoveContent() throws InterruptedException{
			Remove();
		}
		
		@AfterClass
		public static void teardown(){
			driver.close();
		}
}

