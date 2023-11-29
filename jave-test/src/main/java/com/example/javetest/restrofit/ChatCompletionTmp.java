package com.example.javetest.restrofit;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatCompletionTmp implements Serializable {

    /**
     * ID of the model to use.
     */
    private String model;

    /**
     * A list of messages describing the conversation so far.
     */
    private List<Message> messages;
}
