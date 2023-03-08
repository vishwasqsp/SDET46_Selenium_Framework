package hms.emc.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel6 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\Modules.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Admin");
		int rowCount = sheet.getLastRowNum();
		for (int i = 0; i <= rowCount; i++) 
		{
			String key = df.formatCellValue(sheet.getRow(i).getCell(1));
			System.out.println(key);
		}
		wb.close();
		fis.close();
	}
}
