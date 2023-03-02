package generic_utility;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;

	

	@BeforeSuite
	//to connect to database
	public void bsconfig()
	{
		System.out.println("Connect to Database");
	}
	
	@BeforeClass
	//Launch the browser and navigate to url
	public void bcconfig() throws IOException
	{
		
	
		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
			}
	
	
	
	@AfterClass
	//close the browser
	public void acConfig()
	{
		driver.quit();
	}
	
	@AfterSuite
	//exit from database 
	public void asConfig()
	{
		System.out.println("Database is closed.");
	}

}
