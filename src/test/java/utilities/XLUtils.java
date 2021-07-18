package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtils {
    public static FileInputStream fis;
    public static FileOutputStream fos;
    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int getRowCount(String xlFile,String xlSheet) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        worksheet = workbook.getSheet(xlSheet);
        int rowCount = worksheet.getLastRowNum();
        workbook.close();
        fis.close();
        return rowCount;
    }

    public static int getCellCount(String xlFile,String xlSheet, int rowNumber)throws IOException
    {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        worksheet = workbook.getSheet(xlSheet);
        int cellCount = worksheet.getRow(rowNumber).getLastCellNum();
        workbook.close();
        fis.close();
        return cellCount;
    }

    public static String getCellData(String xlFile,String xlSheet, int rowNumber, int colNumber)
            throws IOException
    {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        worksheet = workbook.getSheet(xlSheet);
        row = worksheet.getRow(rowNumber);
        cell = row.getCell(colNumber);
        String data;
        try
        {
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        }
        catch (Exception e)
        {
            data = "";
        }
        workbook.close();
        fis.close();
        return data;
    }

    public static void setCellData(String xlFile,String xlSheet, int rowNumber, int colNumber,String cellData)throws IOException
    {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        worksheet = workbook.getSheet(xlSheet);
        row = worksheet.getRow(rowNumber);

        cell=row.createCell(colNumber);
        cell.setCellValue(cellData);

        fos= new FileOutputStream(xlFile);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
    }

}
