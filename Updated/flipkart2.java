package framework;

import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(FailedSS.class)
public class flipkart2 extends ExcelDataProvider {

		@BeforeClass
		public static void initializing() throws InterruptedException{
			setupFirefox();
		}
		
		@Test(dataProvider = "testdata", priority = 0)
		public static void Login(String Username, String Password) throws InterruptedException{
			FCheckLogin(Username, Password);
		}
		
		@Test(dataProvider = "locationdata", priority = 1, dependsOnMethods={"Login"})
		public static void Location(String Pincode) throws InterruptedException{
			FCheckLocation(Pincode);
		}
		
		@Test(priority = 2, dependsOnMethods={"Location"})
		public static void AddContents() throws InterruptedException{
			FAdd();
		}
		
		@Test(priority = 3, dependsOnMethods={"Location"})
		public static void RemoveContent() throws InterruptedException{
			FRemove();
		}	
		
		@AfterClass
		public static void teardown(){
			fdriver.close();
		}
}


