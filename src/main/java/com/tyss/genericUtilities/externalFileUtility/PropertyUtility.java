package com.tyss.genericUtilities.externalFileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import com.tyss.genericUtilities.Enums.PropertyKeys;


/**
 * This class is provided to utilise data from property file
 * @author User
 *
 */
public class PropertyUtility {
	private Properties prop;
	public PropertyUtility(String filePath) {
		FileInputStream fisProperty = null;
		try {
			fisProperty = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fisProperty);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fisProperty.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public PropertyUtility() {
	}
	@Deprecated
	public void initializePropertyFile(String filePath) {
		FileInputStream fisProperty = null;
		try {
			fisProperty = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fisProperty);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fisProperty.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public String getPropertyData(PropertyKeys key) {
		String keyString = key.name().toLowerCase();
		String value = prop.getProperty(keyString, "Please give proper key '"+keyString+"'").trim();
		return value;
	}


}
