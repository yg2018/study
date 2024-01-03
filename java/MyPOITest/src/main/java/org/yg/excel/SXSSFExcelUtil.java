package org.yg.excel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class SXSSFExcelUtil {

    public static void main(String[] args) {
        // 读取xls
        readXlsFile("C:\\Users\\yuange\\Desktop\\excel测试冻结列.xlsx");
        // 创建xls
        createXlsFile("C:\\Users\\yuange\\Desktop\\excel测试输出.xlsx");
    }
    /**
     * 读取指定的excel内容文件
     * @param fileName
     */
    public static void readXlsFile(String fileName){
     File file = new File(fileName);
     try {
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
      XSSFWorkbook wb = new XSSFWorkbook(bis);
      SXSSFWorkbook workbook = new SXSSFWorkbook(wb);
      XSSFSheet sheet = workbook.getXSSFWorkbook().getSheetAt(0);
      int rownum = sheet.getLastRowNum();
      for (int i = 0 ; i < rownum; i++) {
       XSSFRow row = sheet.getRow(i);
       StringBuilder rowContent = new StringBuilder("SXSSF第"+(i+1)+"行:");
       int lastCellNum = row.getLastCellNum();
       for (int j = 0; j < lastCellNum; j++) {
        XSSFCell cell = row.getCell(j);
        rowContent.append(cell.getNumericCellValue()+"    ");
       }
       System.out.println(rowContent);
      }
     } catch (FileNotFoundException e) {
      e.printStackTrace();
     } catch (IOException e) {
      e.printStackTrace();
     }
    }

    /**
     * 创建一个后缀时xls的文件
     * @param fileName
     */
    public static void createXlsFile(String fileName){
     SXSSFWorkbook workbook = new SXSSFWorkbook();
     SXSSFSheet sheet = workbook.createSheet();
     for (int i = 0; i < 10; i++) {
      SXSSFRow row = sheet.createRow(i);
      for (int j = 0; j < 10; j++) {
       SXSSFCell cell = row.createCell(j);
       cell.setCellValue("SXXSF"+i);
      }
     }
     File file = new File(fileName);
     try {
      if(!file.exists()){
       file.createNewFile();
      }
      BufferedOutputStream bos = new BufferedOutputStream(FileUtils.openOutputStream(file));
      workbook.write(bos);
      bos.close();
     } catch (IOException e) {
      throw new RuntimeException(e);
     }
    }
}
