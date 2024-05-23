package com.comcast.crm.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.comcast.crm.IConstantPath.IConstantPath;

public class ExcelUtility {
	
	   
		 public double readDataFromExcelintvalue(String sheet,int row,int cell) {
			 double data=0.0;
			 try {
				 FileInputStream fis=new FileInputStream(IConstantPath.excel_path);
				 Workbook wb=WorkbookFactory.create(fis);
				 Sheet s=wb.getSheet("Sheet1");
				 Row r=s.getRow(row);
				 Cell c=r.getCell(cell);
				 data=c.getNumericCellValue();
				 
//				 XSSFWorkbook wb=new XSSFWorkbook(fis);
//				 XSSFSheet s=wb.getSheet(sheet);
//				 XSSFRow r=s.getRow(row);
//				 XSSFCell c=r.getCell(cell);
//				 DataFormatter formate=new DataFormatter();
//				 data=formate.formatCellValue(c);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 return data;
		 }
	
     
	 public String readDataFromExcel(String sheet,int row,int cell) {
		 String data=null;
		 try {
			 FileInputStream fis=new FileInputStream(IConstantPath.excel_path);
			 Workbook wb=WorkbookFactory.create(fis);
			 Sheet s=wb.getSheet("Sheet1");
			 Row r=s.getRow(row);
			 Cell c=r.getCell(cell);
			 data=c.getStringCellValue();
			 
//			 XSSFWorkbook wb=new XSSFWorkbook(fis);
//			 XSSFSheet s=wb.getSheet(sheet);
//			 XSSFRow r=s.getRow(row);
//			 XSSFCell c=r.getCell(cell);
//			 DataFormatter formate=new DataFormatter();
//			 data=formate.formatCellValue(c);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return data;
	 }
	 
		public void writeDataIntoExcel(String Sheet,int rowNum,int cellNum,String data) 
		{
			try {
				FileInputStream fis=new FileInputStream(IConstantPath.excel_path);
			    Workbook wb=WorkbookFactory.create(fis);
				wb.getSheet(Sheet).getRow(rowNum).createCell(cellNum).setCellValue(data);
				FileOutputStream fos= new FileOutputStream(IConstantPath.excel_path);
				wb.write(fos);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public int getRowCount(String Sheet)
		{
			int rowCount = 0;
			try {
				FileInputStream fis=new FileInputStream(IConstantPath.excel_path);
				Workbook wb=WorkbookFactory.create(fis);
				rowCount=wb.getSheet(Sheet).getLastRowNum();
	
			}catch(Exception e) {
				e.printStackTrace();
			}
			return rowCount;
			
		}
		
		public int getCellCount(String Sheet)
		{
			int cellCount = 0;
			try {
				FileInputStream fis=new FileInputStream(IConstantPath.excel_path);
				Workbook wb=WorkbookFactory.create(fis);
				cellCount=wb.getSheet(Sheet).getRow(0).getLastCellNum();
	
			}catch(Exception e) {
				e.printStackTrace();
			}
			return cellCount;
			
		}
}
