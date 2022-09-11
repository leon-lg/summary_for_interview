package com.leonlg.grpc.server.serverStreaming;

import io.grpc.ManagedChannelBuilder;

/**
 * @date: 2022/9/9 15:49
 * @author: leon
 */
public class ServerStreaming {
    public static void main(String[] args) {
        ManagedChannelBuilder<?> channel = ManagedChannelBuilder.forAddress("localhost", 8899);
    }
}
