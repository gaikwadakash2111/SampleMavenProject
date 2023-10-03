package testCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CapturingScreenshots {
	
	@Test
	public void sc() throws InterruptedException, IOException
	{
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://mvnrepository.com/artifact/commons-io/commons-io/2.13.0");
	
	    driver.manage().window().maximize();
	    
	    Thread.sleep(3000);
	    
	    TakesScreenshot srcShot=(TakesScreenshot)driver;
	    
	    File src=srcShot.getScreenshotAs(OutputType.FILE);
	    
	    File dest=new File("C:\\Users\\user\\Desktop\\screenshots\\sc1.png");
	    
	    FileUtils.copyFile(src, dest);
	    
	    driver.close();
	}

}
