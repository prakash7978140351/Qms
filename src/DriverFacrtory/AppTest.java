package DriverFacrtory;

import org.testng.annotations.Test;

public class AppTest 
{

	@Test
	public void startTest()
	
	{
		DriverScript ds=new DriverScript();
		try {
			ds.kickStart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
