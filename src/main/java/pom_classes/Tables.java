package pom_classes;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic_utility.BaseClass;

public class Tables extends BaseClass{
	public Tables(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//table[@id='customers']/tbody")
	public WebElement table;
	 @FindAll(@FindBy(xpath = "//table[@id='customers']/descendant::tr"))
	 public List<WebElement> tabledata;

public void get_table() {
	List<String> m = new ArrayList<String>();
	for(WebElement c: tabledata) {
		m.add(c.getText());	
	}
		Set<String> s3 = new LinkedHashSet<String>(m);  
		for(String q2:s3) {
			System.out.print(q2);
			System.out.println();
		}
}
public void open_new_tab() throws AWTException, InterruptedException {
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
