package com.example.javetest.OfficeTools;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MapNavigationNLGJSONGet_version02 {

    private static List<String> simpleList = new ArrayList<>();
    private static List<String> jiaLingList = new ArrayList<>();
    private static List<String> linZhiLingList = new ArrayList<>();
    private static List<String> maleList = new ArrayList<>();

    private static String skillIndentationCount = "\t";
    private static String taskIndentationCount = "\t\t";
    private static String branchNodeIndentationCount = "\t\t\t";

    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("src/main/resources/raw/导航1025.xlsx");
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/music/导航1025.json");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        writer.write("{ \n");

            int count = 0;
            String extra = "";
            String skill = "";
            String task = "";
            String branchNode = "";

            for(Row row : sheet){
                if(count == 3 && !StringUtils.isEmpty(row.getCell(0).toString())){
                    if(StringUtils.isNotEmpty(branchNode)){
                        String branchNodeTmp = String.format("\t\t\"%s\":", branchNode);
                        writer.write(branchNodeTmp);
                        String tmp = createJSON(simpleList, jiaLingList, linZhiLingList, maleList);
                        writer.write(tmp);
                        simpleList.clear();
                        jiaLingList.clear();
                        linZhiLingList.clear();
                        maleList.clear();
                        //task收尾
                        String t001 = "\t\t}\n";
                        writer.write(t001);
                        //skill收尾
                        String t002 = "\t\t},\n";
                        writer.write(t002);
                    }

                    skill = row.getCell(0).toString();
                    String t0 = String.format("%s\"%s\":{\n", skillIndentationCount, skill);
                    writer.write(t0);
                    branchNode = "";
                }
                if(count == 3 && !StringUtils.isEmpty(row.getCell(1).toString())){
                    if(StringUtils.isNotEmpty(branchNode)){
                        String branchNodeTmp = String.format("\t\t\"%s\":", branchNode);
                        writer.write(branchNodeTmp);
                        String tmp = createJSON(simpleList, jiaLingList, linZhiLingList, maleList);
                        writer.write(tmp);
                        simpleList.clear();
                        jiaLingList.clear();
                        linZhiLingList.clear();
                        maleList.clear();
                        //task收尾
                        String t001 = "\t\t},\n";
                        writer.write(t001);
                    }

                    task = row.getCell(1).toString();
                    String t1 = String.format("%s\"%s\":{\n", taskIndentationCount, task);
                    writer.write(t1);
                    branchNode = "";
                }
                if(count <= 2){
                    count++;
                    continue;
                }
                if(!StringUtils.isEmpty(row.getCell(3).toString())){
                    //当分支节点不为空的时候，就是另外一个节点开始的标志，需要对四个Map进行归档，归档后四个map进行清空操作
                    //如果此时是首个不为空结点，是不需要归档的，设置标志flag进行判断
                    if(StringUtils.isNotEmpty(branchNode)){
                        //归档
                        String tmp = createJSON(simpleList, jiaLingList, linZhiLingList, maleList);
                        String branchNodeTmp = String.format("%s\"%s\":", branchNodeIndentationCount,  branchNode);
                        writer.write(branchNodeTmp);
                        writer.write(tmp);
                        writer.write(",\n");
                        simpleList.clear();
                        jiaLingList.clear();
                        linZhiLingList.clear();
                        maleList.clear();
                    }
                    branchNode = row.getCell(3).toString();
                }
                if(StringUtils.isNotEmpty(row.getCell(4).toString())){
                    simpleList.add(row.getCell(4).toString());
                }
                if(StringUtils.isNotEmpty(row.getCell(5).toString())){
                    jiaLingList.add(row.getCell(5).toString());
                }
                if(StringUtils.isNotEmpty(row.getCell(6).toString())){
                    linZhiLingList.add(row.getCell(6).toString());
                }
                if(StringUtils.isNotEmpty(row.getCell(7).toString())){
                    maleList.add(row.getCell(7).toString());
                }
            }
            String branchNodeTmp = String.format("\t\t\"%s\":", branchNode);
            writer.write(branchNodeTmp);
            String tmp = createJSON(simpleList, jiaLingList, linZhiLingList, maleList);
            writer.write(tmp);
            writer.write("\n");

        //task
        writer.write("\t\t}\n");
        //skill
        writer.write("\t}\n");
        //final
        writer.write("}\n");

        writer.close();
        file.close();

        System.out.println("=========OVER==========");
    }

    private static String getIndentation(int count){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < count; i++){
            res.append("\t");
        }
        return res.toString();
    }

    private static String createJSON(List<String> simpleList, List<String> jiaLingList, List<String> linZhiLingList, List<String> maleList) {
        String result = "";

        //开始
        result += "{\n";

        if(!simpleList.isEmpty()){
            result += getNodeJSON(simpleList, "极简");
        }

        if(!jiaLingList.isEmpty()){
            result += ",\n";
            result += getNodeJSON(jiaLingList, "贾玲");
        }

        if(!linZhiLingList.isEmpty()){
            result += ",\n";
            result += getNodeJSON(linZhiLingList, "林志玲");
        }

        if(!maleList.isEmpty()){
            result += ",\n";
            result += getNodeJSON(maleList, "男");
        }

        //结尾
        result += "\t\t\t}";

        return result;
    }
    private static String getNodeJSON(List<String> list, String nodeName){
        String result = "";
        result += String.format("\t\t\t\"%s\":", nodeName);
        result += "{\n";
        for(int i = 1; i <= list.size(); i++){
            result += String.format("\t\t\t\t\"%s\":\"%s\"", i, list.get(i - 1));
            if(i != list.size()) result += ",\n";
        }
        result += "\n\t\t\t}";
        return result;
    }
}
