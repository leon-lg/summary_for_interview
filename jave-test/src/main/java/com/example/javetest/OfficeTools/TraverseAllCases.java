package com.example.javetest.OfficeTools;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TraverseAllCases {

    private static List<String> skillsNav = new ArrayList<>();
    private static List<String> skillsFood = new ArrayList<>();
    private static List<String> tasksNav = new ArrayList<>();
    private static List<String> tasksFood = new ArrayList<>();
    private static List<String> branchNodesNav = new ArrayList<>();
    private static List<String> branchNodesFood = new ArrayList<>();

    private static List<String> types = Arrays.asList("柔情女声","活泼女声","知性女声","温柔女声","率真童声","可爱童声","乖巧童声","粤语女声","东北老铁","阳光男声","主播男声","沉稳男声");

    public static void main(String[] args) throws Exception {
//        getAllCases();
        String url = "http://apis.dui.ai/v2/lyra/webhook/map/navigation";
        JSONObject object = JSONObject.parseObject(new ClassPathResource("music/导航Redis.json").getInputStream(), JSONObject.class);
        Set<String> tasks = object.keySet();
        for(String task : tasks){
            Set<String> branchNodes = object.getJSONObject(task).keySet();
            for(String branchNode : branchNodes){
                for(String type : types){
                    JSONObject req = new JSONObject();
                    req.put("skill", "导航");
                    req.put("task", task);
                    req.put("branchNode", branchNode);
                    req.put("value", type);
                    req.put("style", "emotion");
                    String post = HttpUtil.post(url, req.toJSONString());
                    System.out.println();
                    System.out.println(req.toJSONString());
                    System.out.println("NLG播报： " + JSONObject.parseObject(post).getString("NLG"));
                    System.out.println();
                }
            }
        }
        JSONObject objectFood = JSONObject.parseObject(new ClassPathResource("music/食物Redis.json").getInputStream(), JSONObject.class);
        Set<String> tasksFood = objectFood.keySet();
        for(String task : tasksFood){
            Set<String> branchNodes = objectFood.getJSONObject(task).keySet();
            for(String branchNode : branchNodes){
                for(String type : types){
                    JSONObject req = new JSONObject();
                    req.put("skill", "美食");
                    req.put("task", task);
                    req.put("branchNode", branchNode);
                    req.put("value", type);
                    req.put("style", "emotion");
                    String post = HttpUtil.post(url, req.toJSONString());
                    System.out.println();
                    System.out.println(req.toJSONString());
                    System.out.println("NLG播报： " + JSONObject.parseObject(post).getString("NLG"));
                    System.out.println();
                }
            }
        }
    }

    public static void getAllCases() throws Exception {
        FileInputStream file = new FileInputStream("src/main/resources/raw/导航0908.xlsx");
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        int count = 0;
        String extra = "";
        String skill = "";
        String task = "";
        String branchNode = "";

        for(Row row : sheet){
            if(count == 3 && !StringUtils.isEmpty(row.getCell(0).toString())){
                skill = row.getCell(0).toString();
                if("导航".equals(skill)){
                    skillsNav.add(skill);
                }else if("美食".equals(skill)){
                    skillsFood.add(skill);
                }
            }
            if(count == 3 && !StringUtils.isEmpty(row.getCell(1).toString())){
                task = row.getCell(1).toString();
                if("导航".equals(skill)){
                    tasksNav.add(task);
                }else if("美食".equals(skill)){
                    tasksFood.add(task);
                }
            }
            if(count <= 2){
                count++;
                continue;
            }
            if(!StringUtils.isEmpty(row.getCell(3).toString())){
                branchNode = row.getCell(3).toString();
                if("导航".equals(skill)){
                    branchNodesNav.add(branchNode);
                }else if("美食".equals(skill)){
                    branchNodesFood.add(branchNode);
                }
            }
        }
        file.close();
        System.out.println(skillsNav);
        System.out.println(tasksNav);
        System.out.println(branchNodesNav);
        System.out.println(skillsFood);
        System.out.println(tasksFood);
        System.out.println(branchNodesFood);
        System.out.println("=========OVER==========");
    }
}
