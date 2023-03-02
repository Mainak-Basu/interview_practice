package pom_classes;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
}
