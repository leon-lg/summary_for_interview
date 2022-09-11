package com.leonlg.io;

import java.io.*;

/**
 * @date: 2022/9/11 20:03
 * @author: leon
 * @description 下面是关于io读取文件的两种不同方式
 */
public class InputTestOutStream {
    public static void main(String[] args) throws IOException {
        //1.输入流
        FileInputStream fio = new FileInputStream("input.txt");

        //(1)使用字符读取的方法
//        int len;
//        while((len = fio.read()) != -1){
//            System.out.print((char)len);
//        }

        //(2)使用字节数组的方法
        byte[] bytes = new byte[1024];
        int len;
        while((len = fio.read(bytes)) != -1){
            System.out.print(new String(bytes, 0, len));
        }
        System.out.println();
        System.out.println("over");

        //(3)使用ByteArrayInputStream()方法
        ByteArrayInputStream bis = new ByteArrayInputStream("wangliang".getBytes());
        int len0;
        while((len0 = bis.read()) != -1){
            System.out.print((char)len0 + " ");
        }
        System.out.println("++++++");

        //2.输出流

        //(1)如果是输入中文，使用这个会出现编码异常
//        FileOutputStream fos = new FileOutputStream("output.txt");
//        fos.write(System.in.read());

        //(2)输入中文时使用FileWriter
//        FileWriter fileWriter = new FileWriter("output.txt");
//        fileWriter.write(System.in.read());
        FileOutputStream fos = new FileOutputStream("output.txt");
        byte[] b = "这是中文".getBytes();
        fos.write(b);
        System.out.println("over!!");

        //(3)使用ByteArrayOutputStream
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write("wangliang".getBytes());
        bos.toByteArray();
    }
}
