package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class DashboardPage extends TestBase{

	// Object Repository
	
		@FindBy (xpath = "//a[@class='dropdown-label']") private WebElement avatarIcon;
		@FindBy (xpath = "//h4[@class='username']") private WebElement username;
		@FindBy (xpath = "//div[@class='email']") private WebElement email;
		
		@FindBy (xpath = "//button[text()='Start investing ']") private WebElement  startInvestBtn;
		@FindBy (xpath = "(//input[@icon='search'])[2]") private WebElement searchBar  ;
		@FindBy (xpath = "//span[@class='tradingsymbol']") private WebElement  selectShare ;
		@FindBy (xpath = "//button[text()='Create GTT ']") private WebElement  createGTTBtn ;
		@FindBy (xpath = "//input[@label='Trigger price']") private WebElement triggerPriceTextBox  ;
		@FindBy (xpath = "//input[@label='Qty.']") private WebElement quantityTextBox  ;
		@FindBy (xpath = "//input[@label='Price']") private WebElement priceTextBox  ;
		@FindBy (xpath = "//button[@class='button-outline cancel']") private WebElement cancelBtn  ;
		
//		@FindBy (xpath = "") private WebElement   ;
//		@FindBy (xpath = "") private WebElement   ;
//		@FindBy (xpath = "") private WebElement   ;
		
		
		
		public DashboardPage() 
		{
					PageFactory.initElements(driver, this);
		}
		
		// Methods
		
		public String varifyUsername() throws InterruptedException
		{
					avatarIcon.click();
					Thread.sleep(2000);
					return username.getText();
		}
		
		public String varifyEmail() throws InterruptedException
		{
					avatarIcon.click();
					Thread.sleep(2000);
					return email.getText();
		}
		
		public void placeGTTOrder() throws InterruptedException, EncryptedDocumentException, IOException
		{
					startInvestBtn.click();
					Thread.sleep(2000);
					
					searchBar.sendKeys(readExcelfile(0, 0));
					Thread.sleep(2000);
					
					selectShare.click();
					Thread.sleep(2000);
					
					createGTTBtn.click();
					Thread.sleep(2000);
					
					triggerPriceTextBox.clear();
					triggerPriceTextBox.sendKeys(readExcelfile(0, 1));
					Thread.sleep(2000);
					
					quantityTextBox.clear();
					quantityTextBox.sendKeys(readExcelfile(0, 2));
					Thread.sleep(2000);
					
					priceTextBox.clear();
					priceTextBox.sendKeys(readExcelfile(0, 3));
					Thread.sleep(2000);
					
					 cancelBtn.click();
					 Thread.sleep(2000);
		}
}
