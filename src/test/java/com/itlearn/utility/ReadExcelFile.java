package com.itlearn.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public static FileInputStream inputstrream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String fileName,String sheetName,int rowNo,int cellNo)
	{
		try
		{
			inputstrream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputstrream);
			sheet = workbook.getSheet(sheetName);
			cell = sheet.getRow(rowNo).getCell(cellNo);
			
			workbook.close();
			
			return cell.getStringCellValue();
			
		}
		catch (Exception e) {
			return "";
		}
	}
	
	public static int getRowCount(String fileName,String sheetName)
	{
		try
		{
			inputstrream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputstrream);
			sheet = workbook.getSheet(sheetName);
			
			//get Total No. of rows
			int totalRows = sheet.getLastRowNum()+1;
			
			workbook.close();
			
			return totalRows;
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	public static int getColoumnCount(String fileName,String sheetName)
	{
		try {
			
			inputstrream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputstrream);
			sheet = workbook.getSheet(sheetName);
			
			//get Total No. of columns
			int totalCols = sheet.getRow(0).getLastCellNum();
			
			workbook.close();
			
			return totalCols;
			
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	public String getStringData(int sheetIndex,int row,int column)
	{
		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column)
	{
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName,int row,int column)
	{
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}

}
