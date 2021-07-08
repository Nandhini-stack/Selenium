package framework;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelpath, String sheetname){
		try {
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getRowNo(){
		int rcount = 0;
		try {		
			rcount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row number =" +rcount);
			workbook.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rcount;
	}
	
	public int getColumnNo(){
		int ccount = 0;
		try {		
			ccount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Column number =" +ccount);
			workbook.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	return ccount;
	}
	
	public String getCellDataString(int rno, int cno){
		String celldata = null ;
		try {
			celldata = sheet.getRow(rno).getCell(cno).getStringCellValue();
			workbook.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return celldata;
	}
	
	public String getCellDataNumeric(int rno, int cno){
		String celldata = null ;
		try {
			celldata = sheet.getRow(rno).getCell(cno).getRawValue();
			workbook.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return celldata;
	}

}