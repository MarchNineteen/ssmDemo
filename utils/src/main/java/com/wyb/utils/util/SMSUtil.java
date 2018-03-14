package com.wyb.utils.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
//import com.taobao.api.ApiException;
//import com.taobao.api.DefaultTaobaoClient;
//import com.taobao.api.TaobaoClient;
//import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 *
 * @author WYB
 * @date 2016/7/8
 */
public class SMSUtil {
	protected static final Logger logger = Logger.getLogger(SMSUtil.class);
//	public static final String Uid = "135";// 企业id
//	public static final String Account = "hzmgkj";// 发送用户帐号
//	public static final String Password = "mg123456";// 密码
//	public static final String SMS_SEND_URI = "http://sms3.pro-group.com.cn:8888/sms.aspx";

//	public static boolean sendMessage(String tel, String smsText)
//			throws HttpException, IOException {
//		PostMethod post = new PostMethod(SMS_SEND_URI);
//		NameValuePair[] data = { new NameValuePair("action", "send"),// 发送任务命令
//																		// 设置为固定
//				new NameValuePair("userid", Uid),// 企业id
//				new NameValuePair("account", Account),// 发送用户帐号
//				new NameValuePair("password", Password),// 发送帐号密码
//				new NameValuePair("mobile", tel),// 全部被叫号码
//				new NameValuePair("content", smsText),// 发送内容
//				new NameValuePair("sendTime", null),// 定时发送时间
//				new NameValuePair("checkcontent", 0 + ""),// 是否检查内容包含非法关键字
//				new NameValuePair("taskName", null),// 任务名称
//				new NameValuePair("countnumber", 1 + ""),// 号码总数量
//				new NameValuePair("mobilenumber", 1 + ""),// 手机号码数量
//				new NameValuePair("telephonenumber", 0 + ""),// 小灵通或座机号码数
//		};
//		String result = executeMethod(post, data);
//		String[] mm = result.split("<returnstatus>");
//		String[] ss = mm[1].split("</returnstatus>");
//		logger.info("发送短信数量：" + result + "，手机号：" + tel + "信息：" + smsText);
//		post.releaseConnection();
//		if ("Success".equals(ss[0]))
//			return true;
//		return false;
//	}

	@SuppressWarnings("unused")
	private static String executeMethod(PostMethod post, NameValuePair[] data) throws IOException {
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		post.setRequestBody(data);
		HttpClient client = new HttpClient();
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		byte[] b = post.getResponseBody();
		return new String(b, "utf-8");
	}

	private static final String sms_type = "normal";//短信类型


	private static final String url = "http://gw.api.taobao.com/router/rest";//正式环境

	private static final String sandbox_Url = "http://gw.api.taobao.com/router/rest";//沙箱环境

	private static final String appKey = "23533186";//appKey

	private static final String appSecret = "7f9efb4f055c735873f2c2ad2cc0916c";


//	/**
//	 *
//	 * @param sms_param  短信模板变量  	{"code":"1234","product":"alidayu"}
//	 * @param rec_num     短信接收号码
//	 * @param sms_template_code   短信模板ID
//	 * @param extend       公共回传参数
//	 * @param sign       签名
//	 * @return
//	 */
//	public static boolean  sendMessage(String sms_param,String sign,String rec_num,String sms_template_code,String extend){
//		if (StringUtils.isBlank(sms_template_code)) sms_template_code = "SMS_26070325";//默认验证码模板
//		TaobaoClient client = new DefaultTaobaoClient(url, appKey, appSecret);
//		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//		req.setExtend(extend);
//		req.setSmsType(sms_type);
//		req.setSmsFreeSignName(sign);
//		req.setSmsParamString(sms_param);
//		req.setRecNum(rec_num);
//		req.setSmsTemplateCode(sms_
// template_code);
//		AlibabaAliqinFcSmsNumSendResponse rsp = null;
//		try {
//			rsp = client.execute(req);
//		} catch (ApiException e) {
//			e.printStackTrace();
//		}
//		JSONObject jsonObject = JSON.parseObject(rsp.getBody());
//
//		if (null != jsonObject.get("alibaba_aliqin_fc_sms_num_send_response")){//成功返回
//			return true;
//		}
////		if (null == jsonObject.get("error_response")){//错误日志
//			logger.warn(rec_num + ":" + jsonObject.get("error_response")+"\n");
////			//todo 异常处理
////			return false;
////		}
//		return false;
//	}

	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code","111111");
		jsonObject.put("product","磨古科技");
//		sendMessage(JSONObject.toJSONString(jsonObject),"注册验证","18668113982",null,"1");
	}

}