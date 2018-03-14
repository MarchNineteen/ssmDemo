package com.wyb.utils.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 15019
 * @date 2017/6/26
 */
public class JSONUtil {

    public static Map<String,String> jsonToMap(String json){
        Map<String,String> map = new HashMap<>();
        JSONObject jsonObject = JSONObject.parseObject(json);
        Set<Map.Entry<String, Object>> stringSet = jsonObject.entrySet();
        Iterator iterator = stringSet.iterator();
        while(iterator.hasNext()){
            map.put((String) iterator.next(),jsonObject.getString((String) iterator.next()));
        }
        return map;
    }

    public static void main(String[] args) {
        String json = "{\"patientId\":\"0000247076\",\"cardType\":\"10\",\"cardNo\":\"625466089\",\"platformId\":null,\"tradeMode\":\"DB\",\"tradeModeList\":null,\"accountNo\":\"2451306\",\"cash\":\"100\",\"posTransNo\":\"41\",\"bankTransNo\":\"165625051151\",\"bankDate\":\"0624\",\"bankTime\":\"165705\",\"bankSettlementTime\":null,\"bankCardNo\":\"6222531318351627\",\"posIndexNo\":null,\"sellerAccountNo\":\"302440380627001\",\"inHos\":null,\"name\":\"李冬阳\",\"transNo\":null,\"payAccountNo\":null,\"outTradeNo\":null,\"service\":\"yuantu.wap.recharge.virtual.settlement\",\"hospitalId\":\"703\",\"operId\":\"ZZ07\",\"tradeTime\":\"2017-06-24 16:57:15\",\"flowId\":\"ZZ072017062422332001814\",\"hospCode\":\"\",\"sourceCode\":\"ZZJ\",\"deviceInfo\":\"sd000062\",\"terminalNo\":\"ZZ07\",\"extend\":null,\"deviceMac\":\"00-E0-66-FB-3C-57\",\"deviceIp\":\"192.168.59.36\",\"deviceVersion\":\"YT-550\",\"fundCustodian\":null}";
        Map<String,String> map = new HashMap<>();
        map = jsonToMap(json);
        System.out.println(map.toString());
    }
}
