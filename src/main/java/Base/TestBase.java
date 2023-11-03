package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {

	public static WebDriver driver ;
	
		public String readPropFile(String value) throws IOException
		{
					Properties pop = new Properties();
					FileInputStream file = new FileInputStream("C:\\Users\\rahul\\eclipse-workspace\\SampleZerodhaframework01\\src\\main\\java\\Config\\config.properties");
					pop.load(file);
					return pop.getProperty(value);
		}
		public void Initialize() throws IOException
		{
			String browserName = readPropFile("browser");
			if(browserName.equalsIgnoreCase("chrome"))
			{
						ChromeOptions op = new ChromeOptions();
						op.addArguments("---disable-notifications");
			
						System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
						driver = new ChromeDriver(op);
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
							FirefoxOptions opt1 = new FirefoxOptions();
							opt1.addArguments("--disable-notifications");
	
							System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
							driver = new FirefoxDriver(opt1);			
			}
			else
			{
					EdgeOptions opt2 = new EdgeOptions();
					opt2.addArguments("--disable-notifications");
					
					System.setProperty("webdriver.msedge.driver","Edgedriver.exe");
					 driver = new EdgeDriver(opt2);
			}
			
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
//				driver.get("https://kite.zerodha.com/");	
				driver.get(readPropFile("url"));	
		}
		
		public String readExcelfile(int rNum,int cNum) throws EncryptedDocumentException, IOException 
		{
					FileInputStream file = new FileInputStream("C:\\Users\\rahul\\eclipse-workspace\\SampleZerodhaframework01\\TestData\\TestExcelData.xlsx");
					Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
				String result = excel.getRow(rNum).getCell(cNum).getStringCellValue();
				return result;
		}
}
