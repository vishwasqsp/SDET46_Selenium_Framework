package com.tyss.genericUtilities.externalFileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is to utilise excel data stored in excel sheet
 * @author User
 *
 */
public class Excelutility 
{
	DataFormatter df;
	Workbook wb;
	public Excelutility() 
	{

	}
	public Excelutility(String fileName)
	{
		try {
			initialize(fileName);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Map<String, String> getData(String sheetName, String expectedTestScriptName)
	{
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		Map<String, String> map = new HashedMap<>();
		for (int i = 1; i <= rowCount; i++) 
		{
			String testscriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testscriptName.equalsIgnoreCase(expectedTestScriptName))
			{
				for(int j = 1; j< sheet.getRow(i).getLastCellNum(); j++)
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
			}
		}
		return map;
	}
	public String getData(String sheetName, String expectedTestScriptName, String expectedKey)
	{
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		String value = "";
		int testScriptCounter = 0;
		int keyCounter = 0;
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equalsIgnoreCase(expectedTestScriptName))
			{
				testScriptCounter++;
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equalsIgnoreCase(expectedKey))
					{
						keyCounter++;
						value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}
				}
				break;

			}
		}
		if(keyCounter==0)
		{
			if(testScriptCounter==0)
			{
				value = "Enter proper testScript Key '"+expectedTestScriptName+"'";
			}
			else
			{
				value = "Enter proper testScript Key '"+expectedKey+"'";
			}
		}
		//System.out.println("Value fetched from excel ==> "+value);
		return value;
	}
	private void initialize(String filePath)
	{
		df =new DataFormatter();
		FileInputStream fisExcel = null;
		try {
			fisExcel = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fisExcel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getData(String sheetName, int rowIndex, int cellIndex)
	{
		String value = df.formatCellValue(wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex));
		return value;
	}
	public void close() throws IOException
	{
		wb.close();
	}
	public void setData(String sheetName, int rowIndex, int cellIndex)
	{
		wb.getSheet(sheetName).getRow(rowIndex).createCell(cellIndex);
	}
	public void saveData(String fileOutputPath) throws FileNotFoundException, IOException
	{
		wb.write(new FileOutputStream(fileOutputPath));
	}
}
