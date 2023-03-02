package tests;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import generic_utility.BaseClass;
import pom_classes.Search_Name;
import pom_classes.Search_company;
import pom_classes.Tables;

public class Tests extends BaseClass{
@Test(enabled=false)
public void search_name() {
	Search_Name g = new Search_Name(driver);
	g.searchbox.sendKeys("Mainak");
	g.searchbox.sendKeys(Keys.ENTER);
	g.getresult();
}
@Test(enabled=false)
public void search_company() throws InterruptedException, AWTException {
	Search_company c = new Search_company(driver);
	c.search_company();
	c.find_noc();
}
@Test(enabled = false)
public void get_table() {
	Tables t=new Tables(driver);
	t.get_table();
}
@Test
public void popup() throws AWTException, InterruptedException {
	// Click a button that triggers the prompt dialog
	WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
	button.click();

	// Wait for the prompt dialog to appear
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.alertIsPresent());

	// Get the alert object
	Alert alert = driver.switchTo().alert();

	// Send keys to the prompt
	alert.sendKeys("Mainak is stronger smarter better");

	// Accept the prompt to submit the text
	alert.accept();

	// Verify the result
	WebElement result = driver.findElement(By.xpath("//p[@id='result']"));

System.out.println(result.getText());

}


@Test
public void iframe() throws InterruptedException {
	driver.get("https://www.w3schools.com/html/html_iframe.asp");
	WebElement iframe = driver.findElement(By.xpath("//iframe[@title='W3Schools HTML Tutorial']"));
	driver.switchTo().frame(iframe);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@class='w3-right w3-btn']")).click();
	Thread.sleep(3000);
	driver.switchTo().parentFrame();
	Thread.sleep(3000);
}
@Test
public void newtab() throws AWTException, InterruptedException {
	
	Robot robot=new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_T);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_T);
Thread.sleep(4000);
	
	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));

	// Navigate to a URL in the new tab
	driver.get("https://www.google.com");
}
}
