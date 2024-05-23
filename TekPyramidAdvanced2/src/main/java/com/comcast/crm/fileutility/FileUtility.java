package com.comcast.crm.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.comcast.crm.IConstantPath.IConstantPath;

public class FileUtility {
 
	  public String getDataFromProperties(String key) {
		  String data = null;
		  try {
			FileInputStream fis=new FileInputStream(IConstantPath.CommonPropertis_path);
			Properties property=new Properties();
			try {
				property.load(fis);
				data=property.getProperty(key);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		  return data;
	  }
	
}
