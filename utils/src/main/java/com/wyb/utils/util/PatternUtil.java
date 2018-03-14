/**
 * Copyright (c) 2015, biezhi 王爵 (biezhi.me@gmail.com)
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wyb.utils.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * 正则工具类
 * 提供验证邮箱、手机号、电话号码、身份证号码、数字等方法
 * @author Kunzite
 */
public final class PatternUtil {

    /**
     * 验证Email
     *
     * @param email email地址，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return false;
        }
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

    /**
     * 验证身份证号码
     *
     * @param idCard 居民身份证号码15位或18位，最后一位可能是数字或字母
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isIdCard(String idCard) {
        if (StringUtils.isBlank(idCard)) {
            return false;
        }
        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
        return Pattern.matches(regex, idCard);
    }

    /**
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
     *
     * @param mobile 移动、联通、电信运营商的号码段
     *               <p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
     *               、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
     *               <p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
     *               <p>电信的号段：133、153、180（未启用）、189</p>
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isMobile(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return false;
        }
        String regex = "(\\+\\d+)?1[34578]\\d{9}$";
        return Pattern.matches(regex, mobile);
    }


    /**
     * 验证固定电话号码
     *
     * @param tellPhone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
     *                  <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
     *                  数字之后是空格分隔的国家（地区）代码。</p>
     *                  <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
     *                  对不使用地区或城市代码的国家（地区），则省略该组件。</p>
     *                  <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p>
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isTellPhone(String tellPhone) {
        if (StringUtils.isBlank(tellPhone)) {
            return false;
        }
        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
        return Pattern.matches(regex, tellPhone);
    }

    /**
     * 验证整数（正整数和负整数）
     *
     * @param digit 一位或多位0-9之间的整数
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isDigit(String digit) {
        if (StringUtils.isBlank(digit)) {
            return false;
        }
        String regex = "\\-?[1-9]\\d+";
        return Pattern.matches(regex, digit);
    }

    /**
     * 验证整数和浮点数（正负整数和正负浮点数）
     *
     * @param decimals 一位或多位0-9之间的浮点数，如：1.23，233.30
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isDecimals(String decimals) {
        if (StringUtils.isBlank(decimals)) {
            return false;
        }
        String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
        return Pattern.matches(regex, decimals);
    }


    /**
     * 验证中文
     *
     * @param chinese 中文字符
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isChinese(String chinese) {
        if (StringUtils.isNotBlank(chinese)) {
            String regex = "^[\u4E00-\u9FA5]+$";
            return Pattern.matches(regex, chinese);
        }
        return false;
    }

    /**
     * 检测是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        if (StringUtils.isNotBlank(str)) {
            String regex = "^[1-9]\\d*$";
            return Pattern.matches(regex, str);
        }
        return false;
    }


    /**
     * 验证日期（年月日）
     *
     * @param birthday 日期，格式：1992-09-03，或1992.09.03
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isBirthday(String birthday) {
        if (StringUtils.isNotBlank(birthday)) {
            String regex = "^(\\d{4})-(\\d{2})-(\\d{2})$";
            return Pattern.matches(regex, birthday);
        }
        return false;
    }

    /**
     * 验证URL地址
     *
     * @param url 格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或 http://www.csdn.net:80
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isURL(String url) {
        if (StringUtils.isNotBlank(url)) {
            String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
            return Pattern.matches(regex, url);
        }
        return false;
    }

    /**
     * 匹配中国邮政编码
     *
     * @param postCode 邮政编码
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isPostcode(String postCode) {
        if (StringUtils.isNotBlank(postCode)) {
            String regex = "[1-9]\\d{5}";
            return Pattern.matches(regex, postCode);
        }
        return false;
    }

    /**
     * 匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)
     *
     * @param ipAddress IPv4标准地址
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isIpAddress(String ipAddress) {
        if (StringUtils.isNotBlank(ipAddress)) {
            String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
            return Pattern.matches(regex, ipAddress);
        }
        return false;
    }

    /**
     * 是否是正确的用户名 6到16位的字母数字组合 字母开头
     *
     * @param sourceVal
     * @return
     */
    public static boolean isUserName(String sourceVal) {
        if (StringUtils.isBlank(sourceVal)) {
            return false;
        }
        String regex = "^[a-zA-Z][0-9A-Za-z]{5,15}$";
        boolean isOk = sourceVal.matches(regex);
        return isOk;
    }


    /**
     * 最大长度验证
     * @param sourceVal
     * @param max
     * @return
     */
    public static boolean MaxLength(String sourceVal,int max) {
        if (StringUtils.isBlank(sourceVal)) {
            return false;
        }
//        String regex = "[\\S]{0,"+max+"}";
//        String regex = "[\\S][\\W]{0,"+max+"}";
        String regex = "[\\s\\S]{0,"+max+"}";
        boolean isOk = sourceVal.matches(regex);
        return isOk;
    }


    /**
     * 6位数字验证码
     * @param sourceVal
     * @return
     */
    public static boolean yzCode(String sourceVal){
        if (StringUtils.isBlank(sourceVal)) {
            return false;
        }
        String regex = "^[0-9]{6}";
        return sourceVal.matches(regex);
    }


    /**
     * 密码校验   6-16 位密码长度
     * @param sourceVal
     * @return
     */
    public static boolean password(String sourceVal){
        if (StringUtils.isBlank(sourceVal)) {
            return false;
        }
        String regex = "^[0-9A-Za-z]{6,16}$";
        return sourceVal.matches(regex);
    }

    /**
     * 中 英 数字
     */
    public static boolean charsetDeal(String sourceVal){
        if (StringUtils.isBlank(sourceVal)) {
            return false;
        }
        String regex = "^[\\u4e00-\\u9fa5a-zA-Z0-9]+$";
        return sourceVal.matches(regex);
    }


}