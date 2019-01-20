package DriverFacrtory;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonFunctionaLibrary.FunctionLibrary;
import Utilities.ExcelFileUtil;

public class DriverScript {

	public WebDriver driver;
	 ExtentReports reports;
	 ExtentTest logger;
	public void kickStart() throws Exception 
	{

		ExcelFileUtil excel = new ExcelFileUtil();

		for (int i = 1; i <=excel.rowCount("MainScreen"); i++)
		{
			String moduleStatus = "";
			if (excel.getData("MainScreen", i, 2).equalsIgnoreCase("Y")) 
			{

				
				String TCMODULE = excel.getData("MainScreen", i, 1);
				reports=new ExtentReports("./TestReports/"+TCMODULE+".html"+"_"+FunctionLibrary.generateDate());
				logger=reports.startTest(TCMODULE);

				for (int j = 0; j <= excel.rowCount(TCMODULE); j++)
				{
					String Descriptions = excel.getData(TCMODULE, j, 0);
					String Object_Type = excel.getData(TCMODULE, j, 1);
					String Locator_Type = excel.getData(TCMODULE, j, 2);
					String Locator_Value = excel.getData(TCMODULE, j, 3);
					String Test_Data = excel.getData(TCMODULE, j, 4);

					try
					{
					if (Object_Type.equalsIgnoreCase("openBrowser"))
					{
					driver=	FunctionLibrary.openBrowser(Test_Data);
					logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("lunchApp")) 
					{
						FunctionLibrary.lunchApp();
						logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("tearDown")) 
					{
						FunctionLibrary.tearDown();
						logger.log(LogStatus.INFO, Descriptions);
					}
					
					if (Object_Type.equalsIgnoreCase("closeApp")) 
					{
						FunctionLibrary.closeApp();
						logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("typeAction"))
					{
						FunctionLibrary.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("clickAction"))
					{
						FunctionLibrary.clickAction(driver, Locator_Type, Locator_Value);
						logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("normal_wait")) 
					{
						FunctionLibrary.normal_wait(Test_Data);
						logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("waitForElement")) 
					{
						FunctionLibrary.waitForElement(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("verifyTitle")) 
					{
						FunctionLibrary.verifyTitle(driver, Test_Data);
						logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("verifyUrl")) 
					{
						FunctionLibrary.verifyUrl(driver, Test_Data);
						logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("verticalScroll")) 
					{
						FunctionLibrary.verticalScroll(Test_Data);
						logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("horizontalScroll")) 
					{
						FunctionLibrary.horizontalScroll(Test_Data);
						logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("moveToElement")) 
					{
						FunctionLibrary.moveToElement(Locator_Type, Locator_Value);
						logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("dragAndDrop")) 
					{
					FunctionLibrary.dragAndDrop(Locator_Type, Locator_Value, Test_Data);	
					logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("selectfromDropDown")) 
					{
					FunctionLibrary.selectfromDropDown(Locator_Type, Locator_Value, Test_Data);
					logger.log(LogStatus.INFO, Descriptions);
					}
					if (Object_Type.equalsIgnoreCase("questionBank")) 
					{
					FunctionLibrary.questionBank(Test_Data);	
					logger.log(LogStatus.INFO, Descriptions);
					}
  
					excel.setData(TCMODULE, j, 5, "Pass");
					moduleStatus="True";
					
					logger.log(LogStatus.PASS, Descriptions+" Pass");
				
				}catch (Exception e) 
					{
					e.printStackTrace();
					
					excel.setData(TCMODULE, j, 5, "Fail");
					moduleStatus="false";
					
					logger.log(LogStatus.INFO, Descriptions + " Fail");
					
					File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					Files.copy(scr,new File("./ScreenShots/"+Descriptions+"_"+FunctionLibrary.generateDate()+".jpg"));
					//String imagepath=logger.addScreenCapture("./ScreenShots/"+Descriptions+"_"+FunctionLibrary.generateDate()+".jpg");
					logger.log(LogStatus.FAIL,Descriptions+ " fail");
					break;
				}
				catch (AssertionError e) 
					{
                          e.printStackTrace();
                          excel.setData(TCMODULE, j, 5, "Fail");
      					moduleStatus="false";
      					logger.log(LogStatus.INFO, Descriptions + " Fail");
      					File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    					Files.copy(scr,new File("./ScreenShots/"+Descriptions+"_"+FunctionLibrary.generateDate()+".jpg"));
    					//String imagepath=logger.addScreenCapture("./ScreenShots/"+Descriptions+"_"+FunctionLibrary.generateDate()+".jpg");
    					Thread.sleep(2000);
    					logger.log(LogStatus.FAIL,Descriptions+ " fail");
    					//logger.log(LogStatus.FAIL, "TCMODULE", imagepath);
      					break;
                          }
				}//for j loop
				if (moduleStatus.equalsIgnoreCase("True")) 
				{
					System.out.println(moduleStatus+" check the status");
					excel.setData("MainScreen", i, 3, "Pass");
				}
				else{
					excel.setData("MainScreen", i, 3, "Fail");
					System.out.println(moduleStatus+" check the status");

				}
			} 
			else 
			{
				excel.setData("MainScreen", i, 3, "Not Executed");
			}
			reports.endTest(logger);
			reports.flush();
		}

	}

}