package com.comcast.crm.baseutility1;

import com.comcast.crm.fileutility.ExcelUtility;

public class Check {
    public static void main(String[] args) {
    	ExcelUtility ex=new ExcelUtility();
    	Double s=ex.readDataFromExcelintvalue("Sheet1", 1, 2);
    	System.out.println(s);
	}
}
