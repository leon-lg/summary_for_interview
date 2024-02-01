package com.example.javetest.restrofit;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestrofitTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        // Ignore unknown fields
        //当返回的数据中有多余的字段存在时，默认丢弃
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //这个Converter直接决定了传入参数到RequestBody，以及响应参数到ResponseBody的映射方式
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        RequestService requestService = retrofit.create(RequestService.class);

        Message message = new Message(Role.USER, "你叫什么名字");
        List<Message> list = new ArrayList<>();
        list.add(message);
        ChatCompletionTmp chatCompletionTmp = ChatCompletionTmp.builder().messages(list).model("gpt-4").build();

        Call<ChatCompletionRespTmp> listCall = requestService.getLLMResult(chatCompletionTmp);
        Response<ChatCompletionRespTmp> execute = listCall.execute();
        if(execute.isSuccessful()){
            System.out.println(execute.body());
        }
    }
}
