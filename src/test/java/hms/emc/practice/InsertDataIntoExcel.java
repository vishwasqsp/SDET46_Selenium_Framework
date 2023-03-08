package hms.emc.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\Modules.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Data");
		Row row = sheet.getRow(2);
		Cell cell = row.createCell(2);
		cell.setCellValue("Executed");
		FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\Modules.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
	}

}
