package com.wyb.utils.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 发送电子邮件
 */
public class MailUtil {

    private static final String from = "jayfengyi@126.com";
    private static final String fromName = "测试公司";
    private static final String charSet = "utf-8";
    private static final String username = "jayfengyi@126.com";
    private static final String password = "jay625237";

    private static Map<String, String> hostMap = new HashMap<String, String>();

    static {
        // 126
        hostMap.put("smtp.126", "smtp.126.com");
        // qq
        hostMap.put("smtp.qq", "smtp.qq.com");
        // 163
        hostMap.put("smtp.163", "smtp.163.com");
        // sina
        hostMap.put("smtp.sina", "smtp.sina.com.cn");
        // tom
        hostMap.put("smtp.tom", "smtp.tom.com");
        // 263
        hostMap.put("smtp.263", "smtp.263.net");
        // yahoo
        hostMap.put("smtp.yahoo", "smtp.mail.yahoo.com");
        // hotmail
        hostMap.put("smtp.hotmail", "smtp.live.com");
        // gmail
        hostMap.put("smtp.gmail", "smtp.gmail.com");
        hostMap.put("smtp.port.gmail", "465");
    }

    private static String getHost(String email) throws Exception {
        Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
        Matcher matcher = pattern.matcher(email);
        String key = "unSupportEmail";
        if (matcher.find()) {
            key = "smtp." + matcher.group(1);
        }
        if (hostMap.containsKey(key)) {
            return hostMap.get(key);
        } else {
            throw new Exception("unSupportEmail");
        }
    }

    private static int getSmtpPort(String email) throws Exception {
        Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
        Matcher matcher = pattern.matcher(email);
        String key = "unSupportEmail";
        if (matcher.find()) {
            key = "smtp.port." + matcher.group(1);
        }
        if (hostMap.containsKey(key)) {
            return Integer.parseInt(hostMap.get(key));
        } else {
            return 25;
        }
    }

    /**
     * 发送普通邮件
     *
     * @param toMailAddr 收信人地址
     * @param subject    email主题
     * @param message    发送email信息
     */
    public static void sendSimpleMail(String toMailAddr,
                                      String subject,
                                      String message) {
        HtmlEmail hemail = new HtmlEmail();
        try {
            hemail.setHostName(getHost(from));
            hemail.setSmtpPort(getSmtpPort(from));
            hemail.setCharset(charSet);
            hemail.addTo(toMailAddr);
            hemail.setFrom(from, fromName);
            hemail.setAuthentication(username, password);
            hemail.setSubject(subject);
            hemail.setMsg(message);
            hemail.send();
            System.out.println("email send true!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("email send error!");
        }

    }

    public static void sendHtmlEmail(String[] toAddr,
                                     String subject,
                                     String filePath) {
        try {
            HtmlEmail hemail = new HtmlEmail();
            hemail.setHostName(getHost(from));
            hemail.setSmtpPort(getSmtpPort(from));
            hemail.setCharset(charSet);
            hemail.setFrom(from, fromName);
            hemail.setAuthentication(username, password);
            hemail.setSubject(subject);
            hemail.addTo(toAddr);
            hemail.setMsg(FileUtil.readFile(filePath));
            hemail.send();
            System.out.println("email send true!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("email send error!");
        }
    }


    /**
     * 发送模板邮件
     *
     * @param toAddr 收信人地址
     * @param subject    email主题
     * @param paramsMap  模板参数map
     * @param ftlPath   模板文件路径
     */
    public static void sendFtlEMail(
                                   String subject,
                                   String ftlPath,
                                   String [] toAddr,
                                   Map<String, String> paramsMap) {

        String temFtlPath = ftlPath.replace("\\", "/");
        temFtlPath = temFtlPath.substring(0,temFtlPath.lastIndexOf("/"));

        ftlPath = ftlPath.replace("\\", "/");
        String ftlName = ftlPath.substring(ftlPath.lastIndexOf("/") + 1);
        Template template = null;
        Configuration freeMarkerConfig = null;
        HtmlEmail hemail = new HtmlEmail();
        try {
            hemail.setHostName(getHost(from));
            hemail.setSmtpPort(getSmtpPort(from));
            hemail.setCharset(charSet);
            hemail.addTo(toAddr);
            hemail.setFrom(from, fromName);
            hemail.setAuthentication(username, password);
            hemail.setSubject(subject);
            freeMarkerConfig = new Configuration();
            freeMarkerConfig.setDirectoryForTemplateLoading(new File(temFtlPath));
            // 获取模板
            template = freeMarkerConfig.getTemplate(ftlName, new Locale("Zh_cn"), "UTF-8");
            // 模板内容转换为string
            String htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(template, paramsMap);
            System.out.println(htmlText);
            hemail.setMsg(htmlText);
            hemail.send();
            System.out.println("email send true!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("email send error!");
        }
    }


}