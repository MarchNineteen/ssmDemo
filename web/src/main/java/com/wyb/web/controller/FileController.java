package com.wyb.web.controller;

import com.wyb.core.constant.ConfigConstants;
import com.wyb.utils.util.FileUtilTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by wyb on 2017/3/28.
 * 文件上传 相关方法
 */
@Controller
public class FileController {


    /**
     *  原生的文件下载
     *  后台实现思路
     1 得到文件在服务器上存储的绝对路径
     2 将文件读入文件流
     3 判断浏览器代理并设置不同的编码格式
     4 设置响应头
     5 循环取出流中的数据
     6 关闭流
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = "1.txt";
        String url = request.getSession().getServletContext().getRealPath("/upload/"+source);

        //获得浏览器代理信息
         String userAgent = request.getHeader("USER-AGENT");
        //判断浏览器代理并分别设置响应给浏览器的编码格式
        String finalFileName = source;
        if(StringUtils.contains(userAgent, "MSIE")||StringUtils.contains(userAgent,"Trident")){//IE浏览器
            finalFileName = URLEncoder.encode(finalFileName,"UTF8");
            System.out.println("IE浏览器");
        }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
            finalFileName = new String(finalFileName.getBytes(), "ISO8859-1");
        }else{
            finalFileName = URLEncoder.encode(finalFileName,"UTF8");//其他浏览器
        }
        //设置HTTP响应头
        response.reset();//重置 响应头
        long fileLength = new File(url).length();//获取文件长度
        //设置输出的格式
        response.setContentType("application/x-download");//告知浏览器下载文件，而不是直接打开，浏览器默认为打开
        response.addHeader("Content-Disposition" ,"attachment;filename=\"" +finalFileName+ "\"");//下载文件的名称
//        response.setHeader("Content-disposition", "attachment; filename=" + new String(source.getBytes("gb2312"), "ISO8859-1"));
        response.setHeader("Content-Length", String.valueOf(fileLength));//下载文件的长度
        System.out.println(url);

        String target = ConfigConstants.ACTIVITY_ADMIN_UPLOAD_IMAGE_PATH;
        try {
            FileUtilTest.download(url,target);// 下载到指定目录
//            FileUtilTest.downloadToClient(url,response);//下载到浏览器
        } catch (IOException e) {
            System.out.println("下载异常");
            e.printStackTrace();
        }
    }

    /**
     *  下载网络 图片
     * @param filePath
     * @param response
     * @param isOnLine
     * @throws Exception
     */
    public void downLoad(String filePath, HttpServletResponse response, boolean isOnLine) throws Exception {
        File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;

        response.reset(); // 非常重要
        if (isOnLine) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            // 文件名应该编码成UTF-8
        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }

    /**
     *  spring mvc 提供的文件下载
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("downloadBySpringMvc")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
//        String source = "1.txt";
//        String url = request.getSession().getServletContext().getRealPath("/upload/"+source);
        String url = "F:\\下载\\SteamSetup.exe";
        String suffix = url.substring(url.indexOf("."),url.length());
        File file = new File(url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "1"+"."+suffix);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}
