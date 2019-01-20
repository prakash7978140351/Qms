package CommonFunctionaLibrary;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.PropertyFileUtil;

public class FunctionLibrary 
{
	public static WebDriver driver;
	public static WebDriver openBrowser(String browser)
	{
		if (browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./CommonJarFiles/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
			if (browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./CommonJarFiles/chromedriver.exe");
				driver=new ChromeDriver();
				
			}
			else
				if (browser.equalsIgnoreCase("ie")) 
				{
					System.setProperty("webdriver.ie.driver", "");
					driver=new InternetExplorerDriver();
				}
return driver;
}
	
	
	//test run functionLibrary
	//*******************************************
	
/*	public static WebDriver openBrowser(WebDriver driver) throws IOException, Exception
	{
		if (PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./CommonJarFiles/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
			if (PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./CommonJarFiles/chromedriver.exe");
				driver=new ChromeDriver();
				
			}
			else
				if (PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("ie")) 
				{
					System.setProperty("webdriver.ie.driver", "");
					driver=new InternetExplorerDriver();
				}
return driver;
}//openBrowser
	*/
//***********************************
	
	
	public static void lunchApp() throws Exception
	{
		driver.manage().window().maximize();
		driver.get(PropertyFileUtil.getValueForKey("URL3"));
	}//lunchApp

	
	//For closing all browser.
	public static  void tearDown()
	{
		driver.quit();
	}//tearDown
	
	
	//for closing the currently active browser

	public static void closeApp()
	{
		driver.close();
	}//closeApp

	
	//enter text into text Box
	public static void typeAction(WebDriver driver,String locatorType,String locatorValue,String data)
	{
	if (locatorType.equalsIgnoreCase("id")) 
	{
		driver.findElement(By.id(locatorValue)).clear();
		driver.findElement(By.id(locatorValue)).sendKeys(data);
	}	
	else
		if (locatorType.equalsIgnoreCase("name")) 
		{
			driver.findElement(By.name(locatorValue)).clear();
			driver.findElement(By.name(locatorValue)).sendKeys(data);
		}
		else
			if (locatorType.equalsIgnoreCase("xpath")) 
			{
			driver.findElement(By.xpath(locatorValue)).clear();
			driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			}
			else
				if (locatorType.equalsIgnoreCase("cssSelector")) 
				{
					driver.findElement(By.cssSelector(locatorValue)).clear();
					driver.findElement(By.cssSelector(locatorValue)).sendKeys(data);
				}
				else
					if (locatorType.equalsIgnoreCase("linkText")) 
					{
						driver.findElement(By.linkText(locatorValue)).clear();
						driver.findElement(By.linkText(locatorValue)).sendKeys(data);
					}
					else
						if (locatorType.equalsIgnoreCase("partialLinkText"))
						{
							driver.findElement(By.partialLinkText(locatorValue)).clear();
							driver.findElement(By.partialLinkText(locatorValue)).sendKeys(data);
						}
						else
							if (locatorType.equalsIgnoreCase("tagName"))
							{
								driver.findElement(By.tagName(locatorValue)).clear();
								driver.findElement(By.tagName(locatorValue)).sendKeys(data);
							}
							else
								if (locatorType.equalsIgnoreCase("className")) 
								{
									driver.findElement(By.className(locatorValue)).clear();
									driver.findElement(By.className(locatorValue)).sendKeys(data);
								}
	}//typeAction
   
	//Click on webElement
	public static void clickAction(WebDriver driver,String locatorType,String locatorValue)
	{
	if (locatorType.equalsIgnoreCase("id"))
	{
		driver.findElement(By.id(locatorValue)).click();
	}	
	else
		if (locatorType.equalsIgnoreCase("name")) 
		{
			driver.findElement(By.name(locatorValue)).click();
		}
		else
			if (locatorType.equalsIgnoreCase("xpath")) 
			{
			driver.findElement(By.xpath(locatorValue)).click();
			}
			else
				if (locatorType.equalsIgnoreCase("cssSelector")) 
				{
					driver.findElement(By.cssSelector(locatorValue)).click();
				}
				else
					if (locatorType.equalsIgnoreCase("linkText")) 
					{
						driver.findElement(By.linkText(locatorValue)).click();
					}
					else
						if (locatorType.equalsIgnoreCase("partialLinkText")) 
						{
							driver.findElement(By.partialLinkText(locatorValue)).click();
						}
						else
							if (locatorType.equalsIgnoreCase("tagName")) 
							{
								driver.findElement(By.tagName(locatorValue)).click();
							}
							else
								if (locatorType.equalsIgnoreCase("className"))
								{
									driver.findElement(By.className(locatorValue)).click();
								}
	}//clickAction
   
	 public static void normal_wait(String time)throws Exception
	 {
		 Thread.sleep(Integer.parseInt(time));	 
		 }//normal_wait


	  public static void waitForElement(WebDriver driver,String locatorType,String locatorValue,String time)

	  {
		  WebDriverWait wait=new WebDriverWait(driver, Integer.parseInt(time));
		  if (locatorType.equalsIgnoreCase("id"))
		  {
			
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));		 
		}else
			if (locatorType.equalsIgnoreCase("name"))
			  {
				
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));		 
			}
			else
				if (locatorType.equalsIgnoreCase("xapth"))
				  {
					
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));		 
				}
				else
					if (locatorType.equalsIgnoreCase("cssSelector"))
					  {
						
						  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));		 
					}
					
	  }//waitForElement
  
	  public static void verifyTitle(WebDriver driver,String expdata)
	  {
		String act_data=driver.getTitle();
		Assert.assertEquals(expdata, act_data);
				
	  }

	  public static void verifyUrl(WebDriver driver,String  exp_url)
	  {
		  String act_url=driver.getCurrentUrl();
		  Assert.assertEquals(exp_url, act_url);
	  }

	  
	  public static  void verticalScroll(String pixel)
	  {
		  // you just specify the pixel how much pixel u want to down
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+Integer.parseInt(pixel)+" )");
	  }
	  
	  public static void horizontalScroll(String pixel)
	  {
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy("+Integer.parseInt(pixel)+",0)");
	  }
	  
	  public static void moveToElement(String locatortype,String locatorvalue)
	  {
		  WebElement element;
		  Actions act=new Actions(driver);
		  if (locatortype.equalsIgnoreCase("id")) {
			
			  element=driver.findElement(By.id(locatorvalue));
			  act.moveToElement(element);
			  act.perform();
		}

		  else
			  if (locatortype.equalsIgnoreCase("name")) {
					
				  element=driver.findElement(By.name(locatorvalue));
				  act.moveToElement(element);
				  act.perform();
			}
			  else
				  if (locatortype.equalsIgnoreCase("xapth")) {
						
					  element=driver.findElement(By.xpath(locatorvalue));
					  act.moveToElement(element);
					  act.perform();
				}
				  else
					  if (locatortype.equalsIgnoreCase("cssSelector")) {
							
						  element=driver.findElement(By.cssSelector(locatorvalue));
						  act.moveToElement(element);
						  act.perform();
					}
	  }
	  
	  
	  public static String generateDate()
	  {
		  Date date=new Date();
		  SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss");
		return  sdf.format(date);
		  
	  }
	  
	  
//	  public static void captureScreen(String filedesc)
//	  {
//		  File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(scr, new File(filedesc));
//	  }
	  
	  
	  public static void getTextDAta(String exp_data)
	  {
		 String act_data=driver.findElement(By.xpath("(//div[@role='alert']//following::div[@class='vh'])[1]")).getText();
		 System.out.println(act_data);
		 if (act_data.contains(exp_data)) {
			 Assert.assertEquals(act_data, exp_data);
		}
		
	  }
	  
	  public static void dragAndDrop(String locatortype,String sourceObj,String destObj)
	  {
		  
		  WebElement src,des;
		  Actions act=new Actions(driver);
		  if (locatortype.equalsIgnoreCase("id")) {
			
			src =driver.findElement(By.id(sourceObj));
			des=driver.findElement(By.id(destObj));
			act.dragAndDrop(src, des);
			act.perform();
		}
		  else
			  if (locatortype.equalsIgnoreCase("xpath")) {
				  src =driver.findElement(By.xpath(sourceObj));
					des=driver.findElement(By.xpath(destObj));
					act.dragAndDrop(src, des);
					act.perform();
			}
			  else
				  if (locatortype.equalsIgnoreCase("name")) {
					  src =driver.findElement(By.name(sourceObj));
						des=driver.findElement(By.name(destObj));
						act.dragAndDrop(src, des);
						act.perform();
				}
				  else
					  if (locatortype.equalsIgnoreCase("className")) {
						  src =driver.findElement(By.className(sourceObj));
							des=driver.findElement(By.className(destObj));
							act.dragAndDrop(src, des);
							act.perform();
					}
					  else
						  if (locatortype.equalsIgnoreCase("className")) {
							  src =driver.findElement(By.className(sourceObj));
								des=driver.findElement(By.className(destObj));
								act.dragAndDrop(src, des);
								act.perform();
						}
	  }//dragAndDrop
	  
	  
	  public static void selectfromDropDown(String locatorType,String locatorValue,String visibleText)
	  {
		  
		  if (locatorType.equalsIgnoreCase("xpath")) {
			Select list=new Select(driver.findElement(By.xpath(locatorValue)));
			//List<WebElement>ls=list.getOptions();
			list.selectByVisibleText(visibleText);
		 	//list.selectByValue(visibleText);
			  			  }
		  else
			  if (locatorType.equalsIgnoreCase("id")) {
					Select list=new Select(driver.findElement(By.id(locatorValue)));
					  list.selectByVisibleText(visibleText);
					  }
			  else
				  if (locatorType.equalsIgnoreCase("name")) {
						Select list=new Select(driver.findElement(By.name(locatorValue)));
						  list.selectByVisibleText(visibleText);
						  }
				  else
					  if (locatorType.equalsIgnoreCase("className")) {
							Select list=new Select(driver.findElement(By.className(locatorValue)));
							  list.selectByVisibleText(visibleText);
							  }
	  }
	  
	  public static void tableValidationBank(String locatorType,String BankName)
	  {
		  if (locatorType.equalsIgnoreCase("Xpath")) 
		  {
			
		}
	  }
	  
	  
	  public static void questionBank(String bank) throws InterruptedException
		{
		 Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Select Bank']")).click();
		List<WebElement> banks=driver.findElements(By.xpath("//li[@class='open ng-star-inserted']/div/span"));
		
		int a=banks.size();
		System.out.println("Bank size "+a);
		
		for (int i = 0; i < a; i++) 
		{
		String bankname=banks.get(i).getText();
		System.out.println(bankname);
		if (bankname.equalsIgnoreCase(bank))
		{
		banks.get(i).click();
		break;
		}
		else 
		if (i==(a-1)) {
			System.out.println("If No bank found >-->> By Default Select First Bank Value");
				banks.get(1).click();
				break;
			
		}
			
		}
		 
		}
	  
	  
	  
	  
	  
	  
	 
	/*public static void main(String[] args) throws Exception {
		
		  FunctionLibrary hj=new FunctionLibrary();
		driver=  hj.openBrowser(driver);
		
		hj.lunchApp();
		//hj.verticalScroll("950")
		//hj.selectfromDropDown("(//select)[1]", "xpath", "Approval workflow");
		
		System.out.println(driver.getTitle());
		WebElement table=driver.findElement(By.xpath("//tbody[@class='tableBody']"));
		
	List<WebElement> rows,colms;
	rows=table.findElements(By.tagName("tr"));
	
	
	System.out.println("row num = "+rows.size());////thead[@class='tableHead']//th[2]
	for (int i = 0; i < rows.size(); i++) 
	{
		colms=rows.get(i).findElements(By.tagName("td"));
		System.out.println(colms.size()+" Column numbers");
		for (int k = 1; k < colms.size(); k++) 
		{
		
		String theads=driver.findElement(By.xpath("//thead[@class='tableHead']//th["+(k)+"]")).getText();
		String col=colms.get(k-1).getText();
				System.out.println(theads+ " ---> "+col);
			
		}
	}
				  			  
	}
	 
	*/
	
}
