package com.example.javetest;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class JaveTestApplicationTests {

    @Test
    void contextLoads() throws Exception {
        FileInputStream file = new FileInputStream("D:\\git\\summary_for_interview\\jave-test\\src\\test\\resources\\交规.xlsx");
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\git\\summary_for_interview\\jave-test\\src\\test\\resources\\交规01.json");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        writer.write("{" + "\n");

        int count = 0;
        for (Row row : sheet) {
            if(count == 0){
                count++;
                continue;
            }
            String tmp = "";
            if(row.getCell(3).toString().contains("-")){
                tmp = row.getCell(3).toString();
            }else{
                tmp = tmp + Math.round(Float.parseFloat(row.getCell(3).toString()));
            }
            String res = String.format("\"%s\":\"%s\"", row.getCell(0).toString(), Math.round(Float.parseFloat(row.getCell(2).toString())) + ":" + tmp);
            if(count != sheet.getLastRowNum()){
                writer.write(res + ", \n");
            }else{
                writer.write(res + "\n");
            }
            count++;
        }
        writer.write("}" + "\n");
        writer.close();
    }

}
