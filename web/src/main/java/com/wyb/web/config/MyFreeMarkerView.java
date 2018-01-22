package com.wyb.web.config;//package com.wyb.web.config;
//
//import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//
///**
// * freemarker 的类配置   viewClass = 这个类的路径
// */
//
//public class MyFreeMarkerView extends FreeMarkerView {
//
//    @Override
//    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
//        String serverName = request.getServerName();
//        String contextPath = request.getContextPath();
//        int port = request.getServerPort();
//        String webUrl = request.getScheme()+"://"+serverName + ":" + port + contextPath;
//        model.put("DOMAIN_PATH",webUrl);
//        model.put("request.contextPath",contextPath);
//        model.put("IMAGE_CONTEXT_PATH",webUrl + "/activity/picManager");
//        model.put("ACTIVITY_WEB_CONTEXT_PATH","");
//        model.put("STATIC_VERSION", "001");
////        AdminUserVo adminUserVo =  (AdminUserVo)request.getSession(true).getAttribute(WebKeyConstants.SESSION_ENTERPRISE_LOGIN_ADMIN_KEY);
//
////        String key = String.valueOf(request.getSession().getAttribute(WebKeyConstants.SESSION_ENTERPRISE_LOGIN_ADMIN_KEY));
////        if (null != adminUserVo) {
////            model.put("adminUserVo",adminUserVo.getEnterpriseAdminDo());
////        }
//        super.exposeHelpers(model, request);
//    }
//}
