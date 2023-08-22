package com.example.javetest.OfficeTools;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WongFayeJSONGet {
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("src/main/resources/raw/王菲.xlsx");
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        int count = 0;
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/music/王菲.json");
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
            count++;
            // 每次遇到第二列不为空的时候，得知改内容为歌曲名
            if(!row.getCell(1).toString().isEmpty()){
                songName = row.getCell(1).toString();
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
            //照顾到几个比较特殊的行
                if(count <= 310 || count == 312 || count == 313 || count == 314 || count == 315){
                    if(startIndex != 1){
                        // 将","的添加放到下一首歌曲的时候
                        keyValue = String.format(",\n \"%s\":\"%s\"", startIndex, row.getCell(2).toString().trim());
                    }else{
                        //是第一个下标的时候，就不需要在前面添加 ","
                        keyValue = String.format("\"%s\":\"%s\"", startIndex, row.getCell(2).toString().trim());
                    }
                    writer.write(keyValue);
                    startIndex++;
                }else{
                    //没有手动分行的部分需要自行拆解
                    String collectSentence = row.getCell(2).toString();
                    collectSentence = collectSentence.trim();
                    String[] sentences = collectSentence.split("\n");
                    for(String s : sentences){
                        if(s.equals(""))continue;
                        if(startIndex != 1){
                            keyValue = String.format(",\n \"%s\":\"%s\"", startIndex, s);
                        }else{
                            keyValue = String.format("\"%s\":\"%s\"", startIndex, s);
                        }
                        writer.write(keyValue);
                        startIndex++;
                    }
                }
        }
        writer.write("}\n");
        writer.write("}");
        workbook.close();
        file.close();
        writer.close();
    }
}
