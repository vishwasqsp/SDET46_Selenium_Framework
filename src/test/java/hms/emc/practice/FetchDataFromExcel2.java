package hms.emc.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\Modules.xlsx");
		DataFormatter df = new DataFormatter();
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Data");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String data = df.formatCellValue(cell);
		System.out.println(data);
		wb.close();
		fis.close();	
	}
}
