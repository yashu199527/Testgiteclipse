package com.extensions.pac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.base.pac.Baseclass;


public class Extensions extends Baseclass {

	
	public static void clickon(WebElement wb) {
		if(wb.isDisplayed()&& wb.isEnabled()) {
			wb.click();
		}
		
	}
	public static void pageload(int time) {
		Baseclass.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public boolean isAt(String title) {
		
		if(Baseclass.driver.getTitle().equalsIgnoreCase(title))
		
			return true;
		return false;
			
		
	}
	
	

}
