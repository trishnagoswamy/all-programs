//import org.apache.jasper.compiler.Node.SetProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.server.browserlaunchers.GoogleChromeLauncher;


public class Grid {
public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Grid file = new Grid(String);
//System.setProperty("webdriver.chrome.driver","/opt/google/chrome/google-chrome");
System.setProperty("webdriver.chrome.driver","/usr/bin/google-chrome-stable");
driver = new ChromeDriver();
driver.get("http://www.google.com/xhtml");

	}

}
