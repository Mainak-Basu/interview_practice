package pom_classes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic_utility.BaseClass;

public class Search_Name extends BaseClass{
	
	public Search_Name(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(name="q")
public WebElement searchbox;
@FindBy(id="icon")
public WebElement icon;
@FindBy(id="result-stats")
public WebElement result;

public void getresult() {
	String s = result.getText();
	String s1="";
	char c[]=s.toCharArray();
	for(int i=0; i<c.length;i++) {
		if(Character.isDigit(c[i])) {
		s1=s1+c[i];
		}
	}
	int n= Integer.parseInt(s1);
	System.out.println(n);
        if(n>50000) {
        	System.out.println("Number of results are more than 50000");
        }
    }
  
}
