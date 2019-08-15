package com.page.pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.extensions.pac.*; 
import com.constants.pac.*;

public class Loginpage {
	
	WebDriver driver;
	
	@FindBy(id="txt_uname")
	 WebElement usrtext;
	@FindBy(id="txt_pwd")
	 WebElement usrpass;
	@FindBy (id="btn_submit")
	 WebElement loginbutton;
	@FindBy(xpath="//title[text()='IntelliStant    Your Intelligent Assistant']")
	WebElement title;
	
	public void login() {
		usrtext.sendKeys(Constants.usrname);
		usrpass.sendKeys(Constants.passwrd);
		loginbutton.click();
	}

}
