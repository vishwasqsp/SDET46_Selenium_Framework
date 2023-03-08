package hms.emc.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchAllDataPresentInExcel 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\Modules.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Data1");
		int rowCount = sheet.getLastRowNum();	
		for (int i = 1; i <=rowCount; i++) 
		{
			short cellCount = sheet.getRow(i).getLastCellNum();
			//System.out.println(cellCount);
			for (int j = 0; j < cellCount; j++) 
			{
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
			}
		}
	}
}
