package com.example.javetest.OfficeTools;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class CurrencyNameJSON {
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("src/main/resources/raw/货币对照表.xlsx");
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/other/货币对照表.json");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);

        writer.write("{" + "\n");

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(Row row : sheet){
            if(count == 0){
                count++;
                continue;
            }

            Cell cell1 = row.getCell(1);
            Cell cell0 = row.getCell(0);
            String cnName = cell1.toString();
            String enName = cell0.toString();


            String insertContent = String.format("\"%s\":\"%s\"", cnName, enName);
            System.out.println(cnName + "::" + enName);
            sb.append(insertContent);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        writer.write(sb.toString());
        writer.write("\n" + "}");

        workbook.close();
        writer.close();
    }
}
