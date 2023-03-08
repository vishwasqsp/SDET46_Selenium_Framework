package hms.emc.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class FetchDataFromExcel5 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		String expectedTestscriptName = "TestScriptName";
		String expectedKey = "Module";
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\Modules.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("TestCase");
		int rowCount = sheet.getLastRowNum();
		String value = "";
		for (int i = 0; i <= rowCount; i++) 
		{
			String testscriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			System.out.println(testscriptName);
			if(testscriptName.equalsIgnoreCase(expectedTestscriptName))
			{
				for(int j = 0; j< sheet.getRow(i).getLastCellNum(); j++)
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equalsIgnoreCase(expectedKey))
					{
						value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}
				}
				break;
			}
		}
		System.out.println(value);
	}
}
