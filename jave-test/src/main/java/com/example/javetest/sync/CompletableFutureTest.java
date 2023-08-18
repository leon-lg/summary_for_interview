package com.example.javetest.sync;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is a CompletableFutureTest");
        });
        future.get(2, TimeUnit.SECONDS);


        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        String str = future1.get();
        System.out.println(str);

        CompletableFuture<Void> finalFuture = future1.thenAcceptAsync((obj) -> {
            if (obj.contains(":")) {
                System.out.println("thenAccept::" + obj);
            }
        });

        CompletableFuture<Integer> res = future.thenApplyAsync((voi) -> {
            System.out.println(voi + "::");
            return 123;
        });
        System.out.println(res.get());
    }
}
