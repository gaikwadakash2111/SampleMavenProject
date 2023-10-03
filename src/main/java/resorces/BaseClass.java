package resorces;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public void driverInitialize() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\sampleMavenProject\\src\\main\\java\\resorces\\data.properties");
	
	    Properties prop=new Properties();
	    
	    prop.load(fis);
	    
	    String browserName=prop.getProperty("browser");
	    
	    if(browserName.equalsIgnoreCase("chrome"))
	    {
	    	driver=new ChromeDriver();
	    }
	    
	    else if(browserName.equalsIgnoreCase("edge"))
	    {
	    	driver=new EdgeDriver();
	    }
	    
	    else if(browserName.equalsIgnoreCase("firefox"))
	    {
	    	driver=new FirefoxDriver();
	    }
	}

}
