package tests;
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
@Test(priority=0)
public void search_name() {
	Search_Name g = new Search_Name(driver);
	g.searchbox.sendKeys("Mainak");
	g.searchbox.sendKeys(Keys.ENTER);
	g.getresult();
}
@Test(priority=1)
public void search_company() throws InterruptedException, AWTException {
	Search_company c = new Search_company(driver);
	c.search_company();
	c.find_noc();
}
@Test(priority=2)
public void get_table() {
	driver.get("https://www.w3schools.com/html/html_tables.asp");
	Tables t=new Tables(driver);
	t.get_table();
}
@Test(priority=3)
public void popup() throws AWTException, InterruptedException {
	driver.get("https://the-internet.herokuapp.com/javascript_alerts");
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


@Test(priority=4)
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
@Test(priority=5)
public void newtab() throws AWTException, InterruptedException {
	Tables t=new Tables(driver);
	t.open_new_tab();
	}
}
