package com.example.javetest.OfficeTools;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SongSingerNLGJSONGet02 {
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("src/main/resources/raw/songSingerNLG1124.xlsx");
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Paths.get("src/main/resources/music/songSingerNLG1124.json"))));
        writer.write("{\n");

        int count = 0;

        String song = "";
        String singer = "";
        String tmp = "";

        boolean flag = true;

        List<String> list = new ArrayList<>();

        for(Row row : sheet){
            if(count == 0){
                count++;
                continue;
            }
            System.out.print("==" + row.getCell(2).toString());
            if(!ObjectUtils.isEmpty(row.getCell(0).toString())){
                song = row.getCell(0).toString();
                System.out.print("==" + row.getCell(0).toString());
            }
            if(!ObjectUtils.isEmpty(row.getCell(1).toString())){
                System.out.print("==" + row.getCell(1).toString());
                if(flag){
                    flag = false;
                }else{
                    //归档
                    writer.write(String.format("\"%s\":{\n", tmp));
                    String resultTmp = getJSONObjectString(list);
                    writer.write(String.format("\"%s\":%s", singer, resultTmp));
                    writer.write("\t},\n");
                    //清空list
                    list.clear();
                }
                tmp = song;
                singer = row.getCell(1).toString();
            }
            list.add(row.getCell(2).toString());
            System.out.println();
        }
        writer.write(String.format("\"%s\":{\n", tmp));
        String resultTmp = getJSONObjectString(list);
        writer.write(String.format("\"%s\":%s", singer, resultTmp));
        writer.write("\t}\n");

        writer.write("}");

        file.close();
        writer.close();
    }

    public static String getJSONObjectString(List<String> list){
        String res = "";
        res += "{\n";
        for(int i = 1; i <= list.size(); i++){
            res += String.format("\"%s\":\"%s\"", i + "", list.get(i - 1));
            if(i != list.size()){
                res += ",\n";
            }
        }

        res += "\t}";
        return res;
    }
}
