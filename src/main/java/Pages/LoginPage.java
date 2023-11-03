package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase{

		// Object Repository
	
		@FindBy (xpath = "//img[@alt='Kite']") private WebElement kiteLogo;
		@FindBy (xpath = "//img[@alt='Zerodha']") private WebElement zerodhaLogo;
		
		@FindBy (xpath = "//input[@label='User ID']") private WebElement userIdTextBox;
		@FindBy (xpath = "//input[@id='password']") private WebElement passwordTextBox;
		@FindBy (xpath = "//button[@type='submit']") private WebElement logInBtn;
		
		@FindBy (xpath = "//input[@label='PIN']") private WebElement pinTextBox;
		@FindBy (xpath = "//button[@type='submit']") private WebElement continueBtn;
		
		@FindBy (xpath = "//span[@class='nickname']") private WebElement nicknameLable; 
		
		
		
	
		public LoginPage() 
		{
					PageFactory.initElements(driver, this);
		}
		
	// Methods
		
		public String varifyTitle()
		{
					return driver.getTitle();
		}
		
		public boolean verifykiteLogo()
		{
				return kiteLogo.isDisplayed();
		}
		
		public boolean verifyzerodhaLogo()
		{
			return zerodhaLogo.isDisplayed();
		}
		
		public String logInToApp() throws InterruptedException, IOException
		{
				userIdTextBox.sendKeys(readPropFile("username"));
				passwordTextBox.sendKeys(readPropFile("password"));
				logInBtn.click();
				Thread.sleep(2000);
				
				pinTextBox.sendKeys(readPropFile("pin"));
				continueBtn.click();
				Thread.sleep(5000);
				
				return nicknameLable.getText();
				
				
		}
}
