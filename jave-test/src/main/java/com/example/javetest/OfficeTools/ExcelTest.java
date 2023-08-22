package com.example.javetest.OfficeTools;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

public class ExcelTest {
    /**
     * 对于已有的xsl文件，转换成json文件
     * @param args
     * @throws InvalidFormatException
     */
    public static void main(String[] args) throws Exception {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/raw/singerNLGRaw.xlsx");
            XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            int count = 0;
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/music/singerNameNLGMapping.json");
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
                if(!row.getCell(0).toString().isEmpty()){
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
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//
//
//        FileInputStream file = new FileInputStream("D:\\git\\summary_for_interview\\jave-test\\src\\test\\resources\\交规.xlsx");
//        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(file);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        FileOutputStream fileOutputStream = new FileOutputStream("D:\\git\\summary_for_interview\\jave-test\\src\\test\\resources\\交规01.json");
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
//        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
//        writer.write("{" + "\n");
//
//        int count = 0;
//        for (Row row : sheet) {
//            if(count == 0){
//                count++;
//                continue;
//            }
//            String res = String.format("\"%s\":\"%s\"", row.getCell(0).toString(), Double.valueOf(row.getCell(2).toString()) + ":" + row.getCell(3).toString());
//            if(count != sheet.getLastRowNum()){
//                writer.write(res + ", \n");
//            }else{
//                writer.write(res + "\n");
//            }
//            count++;
//        }
//        writer.write("}" + "\n");
//        writer.close();

//        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/singerNameNLGMapping.json");
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
//        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
//        JSONArray object1 = JSONArray.parseObject(new ClassPathResource("singerMultiState.json").getInputStream(), JSONArray.class);
//        int count = 0;
//        for(Object obj : object1){
//            JSONObject singerPair = (JSONObject) obj;
//            if(count == 0){
//                writer.write("{ \n");
//                String format = String.format("\"%s\": \"%s\"", singerPair.getString("歌手名称"), singerPair.getString("singerDescribe"));
//                writer.write(format + ", \n");
//            }else if(count == object1.size() - 1){
//                String format = String.format("\"%s\": \"%s\"", singerPair.getString("歌手名称"), singerPair.getString("singerDescribe"));
//                writer.write(format + "\n");
//                writer.write("}");
//            }else{
//                String format = String.format("\"%s\": \"%s\"", singerPair.getString("歌手名称"), singerPair.getString("singerDescribe"));
//                writer.write(format + ", \n");
//            }
//            count++;
//        }
//        writer.close();

//        FileOutputStream fileOutputStream1 = new FileOutputStream("src/main/resources/music/songSingerNLGMapping.json");
//        OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(fileOutputStream1);
//        BufferedWriter writer1 = new BufferedWriter(outputStreamWriter1);
//        JSONArray object11 = JSONArray.parseObject(new ClassPathResource("songSingerNLGRaw.json").getInputStream(), JSONArray.class);
//        int count1 = 0;
//        for(Object obj : object11){
//            JSONObject singerPair = (JSONObject) obj;
//            if(count1 == 0){
//                writer1.write("{ \n");
//                String format = String.format("\"%s-%s\": \"%s\"", singerPair.getString("歌曲名"), singerPair.getString("歌手名"), singerPair.getString("nlg"));
//                writer1.write(format + ", \n");
//            }else if(count1 == object11.size() - 1){
//                String format = String.format("\"%s-%s\": \"%s\"", singerPair.getString("歌曲名"), singerPair.getString("歌手名"), singerPair.getString("nlg"));
//                writer1.write(format + "\n");
//                writer1.write("}");
//            }else{
//                String format = String.format("\"%s-%s\": \"%s\"", singerPair.getString("歌曲名"), singerPair.getString("歌手名"), singerPair.getString("nlg"));
//                writer1.write(format + ", \n");
//            }
//            count1++;
//        }
//        writer1.close();
    }

}
