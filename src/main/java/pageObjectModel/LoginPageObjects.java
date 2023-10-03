package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	  public static WebDriver driver;
	
      private By username=By.xpath("//input[@id='username']");
      
      private By password=By.xpath("//input[@id='password']");

      private By login=By.xpath("//input[@id='Login']");
      
      private By errorMessage=By.xpath("//div[@id='error']");
      
      private By TryForFree=By.linkText("Try for Free");
      

      public LoginPageObjects(WebDriver driver2) {
		this.driver=driver2;
	}

	public WebElement enterUsername()
      {
		return driver.findElement(username);
      }
      
      public WebElement enterPassword()
      {
		return driver.findElement(password);
      }
      
      public WebElement clickOnLogin()
      {
		return driver.findElement(login);  
      }
      
      public WebElement getErrorMessage()
      {
		return driver.findElement(errorMessage);
      }
      
      public WebElement clickOnTryforFree()
      {
		return driver.findElement(TryForFree);
      }
      
}
