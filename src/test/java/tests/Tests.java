package tests;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.opencsv.CSVWriter;

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
@Test(priority=6)
public void dragAndDrop() throws InterruptedException {
	driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	WebElement sourceElement= driver.findElement(By.xpath("//div[@id='box1']"));
	WebElement targetElement= driver.findElement(By.xpath("//div[@id='box106']"));
	Actions action = new Actions(driver);
	action.moveToElement(sourceElement).clickAndHold().moveToElement(targetElement).release().build().perform();
	Thread.sleep(4000);
}

@Test
public void frame() {
	driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
	driver.switchTo().frame("packageFrame");
	driver.findElement(By.xpath("//a[@title='class in org.openqa.selenium.support.pagefactory']")).click();
	driver.switchTo().defaultContent();
}
@Test
public void dropdown() {
	driver.get("https://semantic-ui.com/modules/dropdown.html");
	driver.findElement(By.xpath("//input[@name='country']/following-sibling::i[@class='dropdown icon']")).click();
	List<WebElement> countries=driver.findElements(By.xpath("//div[text()='Select Country']/following-sibling::div[@class='menu transition visible']/descendant::div"));
	for(WebElement country:countries) {
		System.out.println(country.getText());
	}
}
@Test
public void indeed_accountant() throws IOException, InterruptedException {
	driver.get("https://in.indeed.com/");
	driver.findElement(By.name("q")).sendKeys("accountant");
	driver.findElement(By.name("l")).sendKeys("Delhi");
	driver.findElement(By.xpath("//button[@type='submit']")).click();

	ArrayList<String> salary= new ArrayList<String>();
	List<WebElement> jobs = driver.findElements(By.xpath("//span[@title]"));
	List<WebElement> companies = driver.findElements(By.xpath("//span[@class='companyName']"));
	List<WebElement> locations = driver.findElements(By.xpath("//div[@class='companyLocation']"));
	List<WebElement> jobdescriptions= driver.findElements(By.xpath("//div[@class='job-snippet']"));
	List<WebElement> jobSeenBeacons = driver.findElements(By.xpath("//div[@class='job_seen_beacon']"));
	for (WebElement jobSeenBeacon : jobSeenBeacons) {
	    List<WebElement> salarySnippets = jobSeenBeacon.findElements(By.xpath(".//div[@class='metadata salary-snippet-container']"));
	    if (salarySnippets.size() > 0) {
	    	for(WebElement ss:salarySnippets) {
	    		salary.add(ss.getText());
	       } 
	    }else {
	    	salary.add("Salary not mentioned by company");
	    }
	}
	CSVWriter write = new CSVWriter(new FileWriter("output.csv"));
	for(int i = 0; i<= jobs.size()-1; i++) {
		String[] mylist= {jobs.get(i).getText(), companies.get(i).getText(), locations.get(i).getText(), 
				jobdescriptions.get(i).getText(), salary.get(i)};
		write.writeNext(mylist);
	}
	write.flush();  
	
}


}
