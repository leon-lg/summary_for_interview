package com.leonlg.grpc.server.unary;

import com.leonlg.grpc.service.UserServerImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @date: 2022/9/9 10:59
 * @author: leon
 */
public class UserInfoServer {
    private Server server;

    public static void main(String[] args) {
        UserInfoServer userInfoServer = new UserInfoServer();
        userInfoServer.start();
        userInfoServer.blockUtilShutdown();
    }

    private void start(){
        try {
            server = ServerBuilder.forPort(8899)
                    .addService(new UserServerImpl())
                    .build()
                    .start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("grpc server started!!!");
    }
    private void blockUtilShutdown(){
        if(server != null){
            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
