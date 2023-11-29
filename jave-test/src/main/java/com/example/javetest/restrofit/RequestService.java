package com.example.javetest.restrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface RequestService {

    //Call还可以替换成RXJava2中的Single使用
    @POST("chatTransparent")
    Call<ChatCompletionRespTmp> getLLMResult(@Body ChatCompletionTmp chatCompletionTmp);
}
