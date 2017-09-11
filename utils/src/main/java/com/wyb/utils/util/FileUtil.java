package com.wyb.utils.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.UUID;

public class FileUtil {


    public static final String separator = "/";

    private static final Logger logger = Logger.getLogger(FileUtil.class);

    public static void writeFile(String filePath, String context) {
        FileOutputStream outSTr = null;
        BufferedOutputStream Buff = null;
        try {
            File downloadFile = new File(filePath);
            downloadFile.getParentFile().mkdirs();
            if (!downloadFile.exists()) {
                downloadFile.createNewFile();
            }
            outSTr = new FileOutputStream(downloadFile);
            Buff = new BufferedOutputStream(outSTr);
            long begin0 = System.currentTimeMillis();
            Buff.write(context.getBytes());
            Buff.flush();
            Buff.close();
            long end0 = System.currentTimeMillis();
            System.out.println("BufferedOutputStream执行耗时:" + (end0 - begin0) + " 豪秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Buff.close();
                outSTr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @SuppressWarnings("resource")
    public static String readFile(String filePath) {
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(new File(filePath)), "UTF-8");//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            StringBuffer sb = new StringBuffer("");
            while ((lineTxt = bufferedReader.readLine()) != null) {
                sb.append(lineTxt);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param inputStream
     * @param rootDir
     * @param originalFilename
     * @param overWriter
     * @return
     */
    public static String saveFile(FileInputStream inputStream, String rootDir, String originalFilename, boolean overWriter) {
        //拿到输出流，同时重命名上传的文件
        if (StringUtils.isBlank(originalFilename) || inputStream == null) {
            throw new NullPointerException("save file and file name is not blank...");
        }
        String _prefix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String _fileName = overWriter ? StringUtils.join(UUID.randomUUID().toString().replaceAll("-", ""), ".", _prefix) : originalFilename;
        String _relativePath = StringUtils.join(FileUtil.separator, DateUtil.formatSimple(new Date(), DateUtil.FORMAT_YYYYMMDD), _fileName);
        String _savePath = StringUtils.join(rootDir, _relativePath);
        try {
            File writeFile = new File(_savePath);
            if (!writeFile.getParentFile().exists()) {
                writeFile.mkdirs();
            }
            FileOutputStream os = new FileOutputStream(writeFile);
            //拿到上传文件的输入流
            //以写字节的方式写文件
            int b = 0;
            while ((b = inputStream.read()) != -1) {
                os.write(b);
            }
            os.flush();
            os.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("文件保存失败.." + e);
        }
        return _relativePath;
    }


    /**
     * @param multipartFile
     * @param rootDir
     * @param originalFilename
     * @param overWriter
     * @return
     */
    public static String saveFile(MultipartFile multipartFile, String originalFilename, String rootDir, String parentDir, boolean overWriter) {
        //拿到输出流，同时重命名上传的文件
        if (StringUtils.isBlank(originalFilename) || multipartFile == null) {
            throw new NullPointerException("save file and file name is not blank...");
        }
        String _prefix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String _fileName = overWriter ? StringUtils.join(UUID.randomUUID().toString().replaceAll("-", ""), ".", _prefix) : originalFilename;
        String _relativePath = StringUtils.join(FileUtil.separator, DateUtil.formatSimple(new Date(), DateUtil.FORMAT_YYYYMMDD), FileUtil.separator, _fileName);
        if (StringUtils.isNotBlank(parentDir)) {
            _relativePath = StringUtils.join(FileUtil.separator, parentDir, _relativePath);
        }
        String _savePath = StringUtils.join(rootDir, _relativePath);
        try {
            File writeFile = new File(_savePath);
            if (!writeFile.getParentFile().exists()) {
                writeFile.mkdirs();
            }
            multipartFile.transferTo(writeFile);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("文件保存失败.." + e);
        }
        return _relativePath;
    }



}
