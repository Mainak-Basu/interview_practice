package tests;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
@Test(priority=0, enabled=false)
public void search_name() {
	Search_Name g = new Search_Name(driver);
	g.searchbox.sendKeys("Mainak");
	g.searchbox.sendKeys(Keys.ENTER);
	g.getresult();
}
@Test(priority=1, enabled=false)
public void search_company() throws InterruptedException, AWTException {
	Search_company c = new Search_company(driver);
	c.search_company();
	c.find_noc();
}
@Test(priority=2, enabled=false)
public void get_table() {
	driver.get("https://www.w3schools.com/html/html_tables.asp");
	Tables t=new Tables(driver);
	t.get_table();
}
@Test(priority=3, enabled=false)
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


@Test(priority=4, enabled=false)
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
@Test(priority=5, enabled=false)
public void newtab() throws AWTException, InterruptedException {
	Tables t=new Tables(driver);
	t.open_new_tab();
	}
@Test(priority=6, enabled=false)
public void dragAndDrop() throws InterruptedException {
	driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	WebElement sourceElement= driver.findElement(By.xpath("//div[@id='box1']"));
	WebElement targetElement= driver.findElement(By.xpath("//div[@id='box106']"));
	Actions action = new Actions(driver);
	action.moveToElement(sourceElement).clickAndHold().moveToElement(targetElement).release().build().perform();
	Thread.sleep(4000);
}

@Test(enabled=false)
public void frame() {
	driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
	driver.switchTo().frame("packageFrame");
	driver.findElement(By.xpath("//a[@title='class in org.openqa.selenium.support.pagefactory']")).click();
	driver.switchTo().defaultContent();
}
@Test( enabled=false)
public void dropdown() {
	driver.get("https://semantic-ui.com/modules/dropdown.html");
	driver.findElement(By.xpath("//input[@name='country']/following-sibling::i[@class='dropdown icon']")).click();
	List<WebElement> countries=driver.findElements(By.xpath("//div[text()='Select Country']/following-sibling::div[@class='menu transition visible']/descendant::div"));
	for(WebElement country:countries) {
		System.out.println(country.getText());
	}
}
@Test(enabled=false)
public void indeed_accountant() throws IOException, InterruptedException {
    int pages = 5;

    driver.get("https://in.indeed.com/");
    driver.findElement(By.name("q")).sendKeys("accountant");
    driver.findElement(By.name("l")).sendKeys("Delhi");
    driver.findElement(By.xpath("//button[@type='submit']")).click();

    ArrayList<String> salary = new ArrayList<String>();
    ArrayList<String> jobtitle = new ArrayList<String>();
    ArrayList<String> jobdesc = new ArrayList<String>();
    ArrayList<String> cname = new ArrayList<String>();
    ArrayList<String> location = new ArrayList<String>();
    
   
    for (int i = 0; i < pages; i++) {
    	List<WebElement> jobs = driver.findElements(By.xpath("//span[@title]"));
    	List<WebElement> companies = driver.findElements(By.xpath("//span[@class='companyName']"));
    	List<WebElement> locations = driver.findElements(By.xpath("//div[@class='companyLocation']"));
    	List<WebElement> jobdescriptions = driver.findElements(By.xpath("//div[@class='job-snippet']"));
    	List<WebElement> jobSeenBeacons = driver.findElements(By.xpath("//div[@class='job_seen_beacon']"));
        for (WebElement jobSeenBeacon : jobSeenBeacons) {
            List<WebElement> salarySnippets = jobSeenBeacon.findElements(By.xpath(".//div[@class='metadata salary-snippet-container']"));
            if (salarySnippets.size() > 0) {
                for (WebElement ss : salarySnippets) {
                    salary.add(ss.getText());
                   }
            } else {
                salary.add("Salary not mentioned by company");
               }
        }
        for(WebElement jd: jobdescriptions) {
        	jobdesc.add(jd.getText());
        }
        for(WebElement l: locations) {
        	location.add(l.getText());
        }
        for(WebElement c: companies) {
        	cname.add(c.getText());
        }
        for(WebElement j: jobs) {
        	jobtitle.add(j.getText());
        }
        WebElement element = driver.findElement(By.xpath("//a[@aria-label='Next Page']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
    CSVWriter write = new CSVWriter(new FileWriter("output.csv"));
    for (int j = 0; j <= salary.size() - 1; j++) {
        String[] mylist = {salary.get(j), jobdesc.get(j), jobtitle.get(j),cname.get(j),location.get(j)};
        write.writeNext(mylist);
    }
    write.flush(); 
}

@Test( enabled=false)
public void spellchecker() {
	String filePath = "C:\\Users\\Fleek\\Downloads\\Assignment.pdf";
    Set<String> words = new HashSet<String>();
    try {
        PDDocument document = PDDocument.load(new File(filePath));
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        String[] tokens = text.split("[^a-zA-Z]+"); // split text into words
        for (String token : tokens) {
            words.add(token); // add each word to the Set
        }
        document.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    String dicfilePath = "C:\\Users\\Fleek\\Downloads\\english-words-master\\english-words-master\\words.txt";
    Set<String> dicwords = new HashSet<String>();
    try (BufferedReader br = new BufferedReader(new FileReader(dicfilePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] dictokens = line.split("\\s+"); // split line into words
            for (String dictoken : dictokens) {
                dicwords.add(dictoken); // add each word to the Set
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
   for (String word : words) {
        boolean found = false;
        for (String dicword : dicwords) {
            if (dicword.equalsIgnoreCase(word)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(word + " is misspelled");
        }
    }
}


@Test(enabled=false)
public void t1() throws InterruptedException {
	System.out.println("t1 starts");
	Thread.sleep(5000);
	System.out.println("t1 ends");
	long threadId = Thread.currentThread().hashCode();
    System.out.println("Thread number: " + threadId);
}

@Test(enabled=false)
public void t2() throws InterruptedException {
	System.out.println("t2 starts");
	Thread.sleep(5000);
	System.out.println("t2 ends");
	
	long threadId = Thread.currentThread().hashCode();
    System.out.println("Thread number: " + threadId);
}
@Test(enabled=false)
public void t3() throws InterruptedException {
	System.out.println("t3 starts");
	Thread.sleep(5000);
	System.out.println("t3 endss");
	long threadId = Thread.currentThread().hashCode();
    System.out.println("Thread number: " + threadId);
}
@Test(enabled=false)
public void excel() throws IOException, InterruptedException {
	driver.get("https://practicetestautomation.com/practice-test-login/");
	String file=".\\src\\main\\Excellsheet\\sheet2.xlsx"; 
	
	FileInputStream finput = new FileInputStream(file);
	
	
	@SuppressWarnings("resource")
	XSSFWorkbook workbook = new XSSFWorkbook(finput); 
	XSSFSheet sheet = workbook.getSheet("sheet2");
	
	int rowcount=sheet.getLastRowNum();
	for(int i=1; i<=rowcount; i++) {
		XSSFCell username = sheet.getRow(i).getCell(0);
		XSSFCell password = sheet.getRow(i).getCell(1);
	    driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(username.toString());
	    System.out.println(username.toString());
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password.toString());
	    System.out.println(password.toString());
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
	    
	}
}

@Test
public void toggle() throws InterruptedException {
	driver.get("https://www.w3schools.com/howto/howto_css_switch.asp");
	driver.findElement(By.xpath("//div[@class='slider']")).click();
	driver.findElement(By.xpath("//label[@class='switch']/descendant::div[@class='slider']")).click();
	Thread.sleep(5000);
}

}

