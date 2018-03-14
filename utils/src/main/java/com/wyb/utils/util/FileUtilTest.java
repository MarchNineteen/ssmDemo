package com.wyb.utils.util;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 * @author 15019
 * @date 2017/3/28
 */
public class FileUtilTest {

    /**
     *  文件上传
     * @throws IOException
     */
    public static void upload() throws IOException {
        byte[] buffer = new byte[1024];//保存每次读取的信息
        int len = 0;//保存每次读取的数组的长度
        File file = new File("E:\\1.txt");
//        File file = new File("E:","test.xlsx");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bf = new BufferedInputStream(fileInputStream);
        FileOutputStream outputStream = new FileOutputStream("E://2.txt");
        BufferedOutputStream bfos=  new BufferedOutputStream(outputStream) ;
        while ((bf.read(buffer))>0){
            bfos.write(buffer);
            bfos.flush();
        }
        fileInputStream.close();
        outputStream.close();
        bf.close();
        bfos.close();
    }

    /**
     *  下载到 指定目录
     * @param source
     * @param target
     * @throws IOException
     */
    public static void download(String source,String target) throws IOException {
        byte[] buff = new byte[1024];
        int len = 0;//保存每次读取的数组的长度
        System.out.println(target);
        //输入流
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(target));
        while ((len = is.read(buff))>0){
            os.write(buff,0,len);
        }
        is.close();
        os.flush();
        os.close();
    }

    /**
     *  下载到浏览器
     * @param source
     * @param response
     * @return
     * @throws IOException
     */
    public static void downloadToClient(String source, HttpServletResponse response) throws IOException {
        byte[] buff = new byte[1024];
        int len = 0;//保存每次读取的数组的长度

        //输入流
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream os = new BufferedOutputStream(response.getOutputStream());
        while ((len = is.read(buff))>0){
            os.write(buff,0,len);
        }
        is.close();
        os.flush();
        os.close();
    }
}
