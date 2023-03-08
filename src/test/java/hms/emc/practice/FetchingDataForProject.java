package hms.emc.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataForProject {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String expectedTestscriptName = "AddingDoctorSpecialisationDoctorEDitDoctorDeleteDoctorTest";
		String expectedKey = "Names";

		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src\\main\\resources\\testData\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		String value = "";
		for (int i = 1; i <= rowCount; i++) 
		{
			String testscriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			System.out.println(testscriptName);
			if(testscriptName.equalsIgnoreCase(expectedTestscriptName))
			{
				for(int j = 0; j< sheet.getRow(i).getLastCellNum(); j++)
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					//System.out.println(key);
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


