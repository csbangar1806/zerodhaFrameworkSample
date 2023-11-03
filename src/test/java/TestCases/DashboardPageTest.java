package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.DashboardPage;
import Pages.LoginPage;

public class DashboardPageTest extends TestBase{

	LoginPage lgIn;
	DashboardPage dash;
	
	@BeforeMethod
	 
		public void setUp() throws IOException, InterruptedException
		{
					Initialize();
					lgIn = new LoginPage();
					lgIn.logInToApp();
					dash = new DashboardPage();
		}
	
	@Test		(enabled = false)
	public void varifyUsernameTest() throws InterruptedException
	{
			String val1 = dash.varifyUsername();
			Assert.assertEquals(val1, "Chandrashekhar Bhaskar Bangar");
	}
	
	@Test		
	public void varifyEmailTest() throws InterruptedException
	{
				String val2 = dash.varifyEmail();
				Assert.assertEquals(val2, "chandrashekharbangar777@gmail.com");
	}
	
	@Test		(enabled = false)
	public void placeGTTOrderTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
					dash.placeGTTOrder();
	}
	
	
	@AfterMethod
	
	public void exit()
	{
		//		driver.close();
		driver.quit();
	}
	
}
