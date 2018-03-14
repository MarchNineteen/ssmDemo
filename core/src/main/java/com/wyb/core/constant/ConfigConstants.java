package com.wyb.core.constant;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ConfigConstants
 *  从配置文件中读取 信息
 *  在调用时初始化 初始化之后一直存在内存中
 *  修改后需要重启tomcat
 * @author Kunzite
 */
public class ConfigConstants {

    private static Logger logger = LoggerFactory.getLogger(ConfigConstants.class);

    /*************************
     * image
     **********************************/
    // #前台用户上传图片访问路径
    public static String USERS_IMAGE_CONTEXT_PATH = "";
    // #后台用户上传图片访问路径
    public static String ADMIN_IMAGE_CONTEXT_PATH = "";
    // 后台上传图片地址
    public static String ACTIVITY_ADMIN_UPLOAD_IMAGE_PATH = "";
    // 前台上传图片地址
    public static String ACTIVITY_USERS_UPLOAD_IMAGE_PATH = "";
    //#前台活动web项目的 CONTEXT_PATH
    public static String ACTIVITY_WEB_CONTEXT_PATH = "";
    //#外部图片访问路径
    public static String IMAGE_CONTEXT_PATH = "";

    /************************* image **********************************/


    static {
        getPropertyValue("/config/config_db.properties");
    }

    public static void getPropertyValue(String fileName) {
        try {
            Properties props = new Properties();
            InputStream is = ConfigConstants.class.getClassLoader().getResourceAsStream(fileName);
            Reader reader = new InputStreamReader(is, "UTF-8");
            props.load(reader);
            Map<String, String> map = new HashMap<String, String>();
            ConfigConstants webConstants = new ConfigConstants();
            Enumeration<?> enums = props.propertyNames();
            while (enums.hasMoreElements()) {
                String key = (String) enums.nextElement();
                map.put(key, props.getProperty(key.toUpperCase()));
            }
            logger.debug("配置信息：" + JSONObject.toJSONString(map));
            BeanUtils.copyProperties(webConstants, map);
            is.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setACTIVITY_ADMIN_UPLOAD_IMAGE_PATH(String activityAdminUploadImagePath) {
        ACTIVITY_ADMIN_UPLOAD_IMAGE_PATH = activityAdminUploadImagePath;
    }

    public void setACTIVITY_USERS_UPLOAD_IMAGE_PATH(String activityUsersUploadImagePath) {
        ACTIVITY_USERS_UPLOAD_IMAGE_PATH = activityUsersUploadImagePath;
    }

    public void setUSERS_IMAGE_CONTEXT_PATH(String usersImageContextPath) {
        USERS_IMAGE_CONTEXT_PATH = usersImageContextPath;
    }

    public void setADMIN_IMAGE_CONTEXT_PATH(String adminImageContextPath) {
        ADMIN_IMAGE_CONTEXT_PATH = adminImageContextPath;
    }

    public void setACTIVITY_WEB_CONTEXT_PATH(String activityWebContextPath) {
        ACTIVITY_WEB_CONTEXT_PATH = activityWebContextPath;
    }

    public void setIMAGE_CONTEXT_PATH(String imageContextPath) {
        IMAGE_CONTEXT_PATH = imageContextPath;
    }
}
