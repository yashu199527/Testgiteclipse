package com.page.pac;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.extensions.pac.Extensions;

public class Homepage {
	
		@FindBy(id="dropdownMenuButton")
		WebElement signout;
		@FindBy(xpath="//a[text()='Logout']")
		WebElement log;
		
		public void logout()
		{
			Extensions.pageload(20);
			Extensions.clickon(signout);
			Extensions.clickon(log);
			}

}
