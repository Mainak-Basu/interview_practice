package pom_classes;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_utility.BaseClass;

public class Search_company extends BaseClass{
	
	public Search_company(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="q")
	public WebElement searchbox;
	@FindBy(id="icon")
	public WebElement icon;
	 
	public void search_company() {
		searchbox.clear();
		searchbox.sendKeys("software testing company");
		searchbox.sendKeys(Keys.ENTER);
	}
	public void find_noc() throws AWTException, InterruptedException {
		Robot robot =new Robot();
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_F);
		 robot.keyRelease(KeyEvent.VK_F);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
	        robot.keyPress(KeyEvent.VK_F);
	        robot.keyRelease(KeyEvent.VK_F);
	        robot.keyPress(KeyEvent.VK_L);
	        robot.keyRelease(KeyEvent.VK_L);
	        robot.keyPress(KeyEvent.VK_E);
	        robot.keyRelease(KeyEvent.VK_E);
	        robot.keyPress(KeyEvent.VK_E);
	        robot.keyRelease(KeyEvent.VK_E);
	        robot.keyPress(KeyEvent.VK_K);
	        robot.keyRelease(KeyEvent.VK_K);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	      Thread.sleep(2000);
		 
		
	}
}
