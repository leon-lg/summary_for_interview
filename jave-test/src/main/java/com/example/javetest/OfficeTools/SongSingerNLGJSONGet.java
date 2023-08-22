package com.example.javetest.OfficeTools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class SongSingerNLGJSONGet {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream1 = new FileOutputStream("src/main/resources/music/songSingerNLGMapping.json");
        OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(fileOutputStream1);
        BufferedWriter writer1 = new BufferedWriter(outputStreamWriter1);
        JSONArray object11 = JSONArray.parseObject(new ClassPathResource("raw/songSingerNLGRaw.json").getInputStream(), JSONArray.class);
        int count1 = 0;
        for(Object obj : object11){
            JSONObject singerPair = (JSONObject) obj;
            if(count1 == 0){
                writer1.write("{ \n");
                String format = String.format("\"%s-%s\": \"%s\"", singerPair.getString("歌曲名"), singerPair.getString("歌手名"), singerPair.getString("nlg"));
                writer1.write(format + ", \n");
            }else if(count1 == object11.size() - 1){
                String format = String.format("\"%s-%s\": \"%s\"", singerPair.getString("歌曲名"), singerPair.getString("歌手名"), singerPair.getString("nlg"));
                writer1.write(format + "\n");
                writer1.write("}");
            }else{
                String format = String.format("\"%s-%s\": \"%s\"", singerPair.getString("歌曲名"), singerPair.getString("歌手名"), singerPair.getString("nlg"));
                writer1.write(format + ", \n");
            }
            count1++;
        }
        writer1.close();
    }
}
