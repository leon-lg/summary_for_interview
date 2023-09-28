package com.example.javetest.OfficeTools;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class SongNLGJSONGet {
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("src/main/resources/raw/songNLG0920.xlsx");
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        int count = 0;
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/music/songNLG0920.json");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        writer.write("{" + "\n");
        String songName = "";
        int startIndex = 0;
        boolean begin = true;

        for (Row row : sheet) {
            if(count == 0){
                count++;
                continue;
            }
//
//            if(count <= 29){
//                System.out.print(row.getCell(0).toString() + "::");
//                System.out.println(row.getCell(1).toString());
//            }
//            count++;
            // 每次遇到第二列不为空的时候，得知改内容为歌曲名
            if(!StringUtils.isEmpty(row.getCell(0).toString())){
                songName = row.getCell(0).toString();
                if(begin){
                    // 第一次实际上不需要添加 "},"
                    writer.write("\"" + songName + "\":{");
                    begin = false;
                }else{
                    // 将"}"的添加放到下一首歌曲的时候
                    writer.write("},\n \"" + songName + "\":{");
                }
                startIndex = 1;
            }
            String keyValue = "";
            if(startIndex != 1){
                // 将","的添加放到下一首歌曲的时候
                keyValue = String.format(",\n \"%s\":\"%s\"", startIndex, row.getCell(1).toString().trim());
            }else{
                //是第一个下标的时候，就不需要在前面添加 ","
                keyValue = String.format("\"%s\":\"%s\"", startIndex, row.getCell(1).toString().trim());
            }
            writer.write(keyValue);
            startIndex++;
        }
        writer.write("}\n");
        writer.write("}");
        workbook.close();
        file.close();
        writer.close();
    }
}
