package com.org.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.PushbackInputStream;

import javax.print.DocFlavor.STRING;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Excel1 {
	private static final String CVS_SEPERATOR_CHAR = null;
	WebDriver driver;
	
	XSSFWorkbook  work;
	XSSFSheet sheet;
	public Excel1 ( String path)
	{
		try
		{
			File file=new File(path);
			FileInputStream fis=new FileInputStream(file);
			work=(XSSFWorkbook) WorkbookFactory.create(new PushbackInputStream(fis));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@SuppressWarnings("deprecation")
	public String getdata(int sheetnumber,int row,int  cell)
	{
		 /**sheet=work.getSheetAt(sheetnumber);
		 String data=sheet.getRow(row).getCell(cell).getStringCellValue();
		 return data;
		int a=cell;
		Integer cell1=Integer.valueOf(a);
		switch (cell.getCellType()) {
        case Cell.CELL_TYPE_STRING:
                System.out.print( sheet.getRow(row).getCell(cell).getStringCellValue()+ " ");
                //String lst =row.getCell(j).getStringCellValue();
	            
                break;

        case Cell.CELL_TYPE_NUMERIC:
                System.out.print(sheet.getRow(row).getCell(cell).getNumericCellValue() + " ");
                break;
		}
		 }*/
		
		
		 String cellData = "";
		 
		sheet=work.getSheetAt(sheetnumber);
		Row row1=sheet.getRow(row);
		Cell cell1=row1.getCell(cell);
		    if (cell1== null) {
		        cellData += CVS_SEPERATOR_CHAR;;
		    } else {
		        switch (cell1.getCellType()) {
		          
		            case Cell.CELL_TYPE_STRING:
		                //cellData += cell.getRichStringCellValue() + CVS_SEPERATOR_CHAR;
		            	 cellData = cell1.getStringCellValue();
		                break;
		            case 	Cell.CELL_TYPE_NUMERIC:
		                cellData =cell1.getNumericCellValue()+"" ;
		                break;
		           
		            default:
		                cellData += CVS_SEPERATOR_CHAR;
		                ;
		        }
		    }
		    return cellData;
		}
public int rowcount( int sheetno)
{
	int row=work.getSheetAt(sheetno).getLastRowNum();
	row=row+1;
	return row;
}
}
