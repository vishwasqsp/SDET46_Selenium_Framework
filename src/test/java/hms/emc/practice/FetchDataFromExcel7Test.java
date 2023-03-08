package hms.emc.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel7Test 
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		String expectedTestscriptName = "AddingDoctorSpecialisationDoctorEDitDoctorDeleteDoctorTest";
		String expectedKey = "DoctorSpecialisation";
		
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\Modules.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Admin");
		int rowCount = sheet.getLastRowNum();
		List<String> dataList = new ArrayList<>();
		
		for (int i = 1; i <= rowCount; i++) 
		{
			
			String testscriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			//System.out.println(testscriptName);
			if(testscriptName.equalsIgnoreCase(expectedTestscriptName))
			{
				for(int j = 0; j< sheet.getRow(i).getLastCellNum(); j++)
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					//System.out.println(key);
					if(key.equalsIgnoreCase(expectedKey))
					{
						
						for (int k = i+1; ; k++) 
						{
							String data = df.formatCellValue(sheet.getRow(k).getCell(j));
							if(data.equals(""))
							{
								break;
							}
							else
							{
								dataList.add(data);
							}
						
						}
						break;
					}
					
				}
				break;
			}
		
		
	}
		System.out.println(dataList);
		wb.close();
		fis.close();
}
}
