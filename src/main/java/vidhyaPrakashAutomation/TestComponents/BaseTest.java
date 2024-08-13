package vidhyaPrakashAutomation.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;




public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	
public BaseTest(){
	// TODO Auto-generated constructor stub
	String configPath = System.getProperty("user.dir")+"\\src\\main\\java\\vidhyaPrakashAutomation\\config\\config.properties";
	try {
		prop =new Properties();
		FileInputStream fis = new FileInputStream(configPath);
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}	


	public static void initializeWebDriver() throws Exception{
		String browserName =  System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		if(browserName.equals("Chrome"))
		{
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*",
					"disable-extensions",
					"--start-maximized");
			driver = new ChromeDriver(opt);
		}else if (browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}else if (browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.manage().window().minimize();
		
		driver.get(prop.getProperty("URL"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	/*
	 * @BeforeTest public void launchApplication() throws Exception {
	 * initializeWebDriver(); }
	 */
}
