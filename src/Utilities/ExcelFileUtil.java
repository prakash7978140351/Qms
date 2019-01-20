package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import CommonFunctionaLibrary.FunctionLibrary;

public class ExcelFileUtil 
{

	public Workbook wb;
	public ExcelFileUtil() throws Exception, Exception, Exception
	{
		FileInputStream fis=new FileInputStream("./TestInputs/inputSheetReg2.xlsx");
	wb=	WorkbookFactory.create(fis);
	}

	public int rowCount(String sheetName)
	{
		return wb.getSheet(sheetName).getLastRowNum();
	}
	
	public int cellCount(String sheetName,int row)
	{
		return wb.getSheet(sheetName).getRow(row).getLastCellNum();
	}

   public String getData(String sheetName,int row,int cell)
   {
	  String data="";
	  
	  if (wb.getSheet(sheetName).getRow(row).getCell(cell).getCellType()==Cell.CELL_TYPE_NUMERIC) {
		 int celldata=(int)wb.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
		data=String.valueOf(celldata);
	}
	  else
	data=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	  
	  return data;
   }

   public void setData(String sheetName,int row,int cell,String str) throws IOException
   {
	   Sheet ws=wb.getSheet(sheetName);
	   Row rw=ws.getRow(row);
	   Cell cw=rw.createCell(cell);
	   cw.setCellValue(str);
	   
	   if (str.equalsIgnoreCase("Pass")) 
	   {
		CellStyle style=wb.createCellStyle();
		Font font=wb.createFont();
		font.setColor(IndexedColors.GREEN.getIndex());
		font.setBoldweight(font.BOLDWEIGHT_BOLD);
		
		style.setFont(font);
		rw.getCell(cell).setCellStyle(style);
	    }
	   else
	   
		   if (str.equalsIgnoreCase("Fail"))
		   {
			
			   CellStyle style=wb.createCellStyle();
			   Font font=wb.createFont();
			   font.setColor(IndexedColors.RED.getIndex());
			   font.setBoldweight(font.BOLDWEIGHT_BOLD);
			   style.setFont(font);
			   rw.getCell(cell).setCellStyle(style);
		}
		   else
			   if (str.equalsIgnoreCase("Not Executed")) 
			   {
				CellStyle style=wb.createCellStyle();
				Font font=wb.createFont();
				font.setColor(IndexedColors.BLUE.getIndex());
				font.setBoldweight(font.BOLDWEIGHT_BOLD);
				style.setFont(font);
				rw.getCell(cell).setCellStyle(style);
			}
	   
	   
	   FileOutputStream fos=new FileOutputStream("./TestOutput/result.xlsx");
	   wb.write(fos);
	   fos.close();
   }

	
}
