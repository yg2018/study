package org.yg.excel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;

public class HSSFExcelUtil {
    public static void main(String[] args) {
     // 读取xls
     HSSFExcelUtil.readXlsFile("C:\\Users\\yuange\\Desktop\\excel测试冻结列.xls");
     // 创建xls
     HSSFExcelUtil.createXlsFile("C:\\Users\\yuange\\Desktop\\excel测试输出.xls");

    }
    /**
     * 读取指定的excel内容文件
     * @param fileName
     */
    public static void readXlsFile(String fileName){
     File file = new File(fileName);
     try {
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
      HSSFWorkbook workbook = new HSSFWorkbook(bis);
      HSSFSheet sheet = workbook.getSheetAt(0);
      int rownum = sheet.getLastRowNum();
      for (int i = 0; i < rownum; i++) {
       HSSFRow row = sheet.getRow(i);
       StringBuilder rowContent = new StringBuilder("HSSF第"+(i+1)+"行:");
       int lastCellNum = row.getLastCellNum();
       for (int j = 0; j < lastCellNum; j++) {
        HSSFCell cell = row.getCell(j);
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
     HSSFWorkbook workbook = new HSSFWorkbook();
     HSSFSheet sheet = workbook.createSheet();
     for (int i = 0; i < 10; i++) {
      HSSFRow row = sheet.createRow(i);
      for (int j = 0; j < 10; j++) {
       HSSFCell cell = row.createCell(j);
       cell.setCellValue("HSSF"+i);
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
