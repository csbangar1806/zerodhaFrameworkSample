package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage login;
	
		@BeforeMethod
		
			public void setup() throws IOException
			{
					Initialize();
					 login = new LoginPage();
			}
		
		@Test 			(enabled = false)
		public void varifyTitleTest()
		{
				String result = login.varifyTitle();
				Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", result);
		}
		
		@Test			(enabled = false)
		public void verifykiteLogoTest()
		{
					boolean bl1 = login.verifykiteLogo();
					Assert.assertEquals(bl1, true);
		}
		
		@Test			(enabled = false)
		public void verifyzerodhaTest()
		{
					boolean bl2 = login.verifyzerodhaLogo();
					Assert.assertEquals(bl2,true);
		}
		
		@Test
		public void logInToApptest() throws InterruptedException, IOException
		{
					String nick = login.logInToApp();
				Assert.assertEquals(nick, "Chandrashekhar");
		}
		
		@AfterMethod
		
		public void exit()
		{
					driver.close();
		}	
}
