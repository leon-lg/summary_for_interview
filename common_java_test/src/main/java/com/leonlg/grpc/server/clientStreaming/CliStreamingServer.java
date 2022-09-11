package com.leonlg.grpc.server.clientStreaming;

import com.leonlg.grpc.server.unary.UserInfoServer;
import com.leonlg.grpc.service.UserServerImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @date: 2022/9/9 14:59
 * @author: leon
 */
public class CliStreamingServer {

    private Server server;

    public static void main(String[] args) {
        CliStreamingServer cliStreamingServer = new CliStreamingServer();
        cliStreamingServer.start();
        cliStreamingServer.blockUtilShutdown();
    }

    private void start()   {
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

    private void blockUtilShutdown()  {
        if(server != null){
            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
