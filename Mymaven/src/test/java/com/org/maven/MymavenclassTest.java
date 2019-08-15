package com.org.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pac.Baseclass;

public class MymavenclassTest extends Baseclass {
	static WebDriver driver;
/**	@Test(priority=1)
	
	public void launch() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo5.intellistant.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='txt_uname']")).sendKeys("yashu");
		driver.findElement(By.xpath("//input[@id='txt_pwd']")).sendKeys("Yashu123@");
		Actions ac=new Actions(driver);
		ac.sendKeys(Keys.ENTER).perform();
		
	}**/
	
		@Test(dataProvider="intellistant",priority=1)

		public void login(String proname,String procode, int price,int barcode, int alert,String loc) throws InterruptedException
		{
			
				Thread.sleep(3000);
				driver.findElement(By.xpath("//li[@id='td1']/following-sibling::li[14]")).click();
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("#Content_Body_lnkProduct")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[text()='Add']")).click();
				driver.findElement(By.cssSelector("#Content_Body_txtProdName")).sendKeys(proname);
				driver.findElement(By.cssSelector("#Content_Body_txtCatalogNumber")).sendKeys(procode);
				Thread.sleep(3000);
				Select sl=new Select(driver.findElement(By.cssSelector("#Content_Body_ddlprodCategory")));
				sl.selectByIndex(1);
				Thread.sleep(3000);
				Select sl1=new Select(driver.findElement(By.xpath("//select[@id='Content_Body_SelUnits']")));
				sl1.selectByIndex(1);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='Content_Body_txtPrice']")).sendKeys(String.valueOf(price));
				driver.findElement(By.xpath("//input[@id='Content_Body_txtBarcode']")).sendKeys(String.valueOf(barcode));
			
				driver.findElement(By.xpath("//input[@id='Content_Body_txtQtylevel']")).sendKeys(String.valueOf(alert));
				driver.findElement(By.xpath("//input[@id='Content_Body_txtUid']")).sendKeys(loc);
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//div[@contenteditable='true'])[2]")).sendKeys("discription");
				driver.findElement(By.cssSelector("#Btn_SavePro")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[text()='OK']")).click();
				Thread.sleep(6000);
				driver.findElement(By.cssSelector("#td_AddProd")).click();
				Thread.sleep(3000);
		}


		@DataProvider(name="intellistant")
		public Object[][] pass()
		{
			Excel1  read=new Excel1 ("E:\\excelfetch.xlsx");
			int rowS=read.rowcount(0);
			Object[][] data=new Object[rowS][6];
			for(int i=0;i<rowS;i++)
			{
				try {
				data[i][0]=read.getdata(0,i,0);
				data[i][1]=read.getdata(0,i,1);
				data[i][2]=	(int)Double.parseDouble(read.getdata(0,i,2));
				data[i][3]= (int)Double.parseDouble(read.getdata(0,i,3));
				data[i][4]=(int)Double.parseDouble(read.getdata(0,i,4));
				data[i][5]=read.getdata(0,i,5);
				//data[i][6]=read.getdata(0,i,6);
			}
				catch(ArrayIndexOutOfBoundsException ee)
				{
					System.out.println(ee.getMessage());
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			return data;
		}

		}





