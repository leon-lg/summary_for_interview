package com.leonlg.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @date: 2022/9/11 19:37
 * @author: leon
 */
public class ByteArrayRel {
    public static void main(String[] args) throws IOException {

        //字节数组输出流，利用一个内部字节数组来保存数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(9);
        while(byteArrayOutputStream.size() != 5){
            byteArrayOutputStream.write(System.in.read());
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
        for(int i = 0; i < bytes.length; i++) {
            System.out.print((char)bytes[i] + " ");
        }
        System.out.println();

        //字节数据输入流，需要一个字节数据入参
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int len;
        while((len = byteArrayInputStream.read()) != -1){
            System.out.println((char)len);
        }
        byteArrayInputStream.reset();
    }
}
