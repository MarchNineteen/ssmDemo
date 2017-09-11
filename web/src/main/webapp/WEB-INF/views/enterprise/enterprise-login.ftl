<!DOCTYPE html>
<head>
    <#include "/common/header.ftl"/>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${DOMAIN_PATH}/resources/css/select-style.css?${STATIC_VERSION?default('001')}"/>
    <link rel="stylesheet" type="text/css" href="${DOMAIN_PATH}/resources/css/enterprise/enterprise-login.css?${STATIC_VERSION?default('001')}"/>
    <script type="text/javascript" src="${DOMAIN_PATH}/resources/js/common/jquery.cookie.js?${STATIC_VERSION?default('001')}"></script>
    <script type="text/javascript" src="${DOMAIN_PATH}/resources/js/enterprise/enterprise-login.js?${STATIC_VERSION?default('001')}"></script>
</head>
<body>
<div class="middle">
    <div class="login_box">
        <div class="login_head">
            <p>活动管理平台</p>
        </div>
        <form autocomplete="off" action="" method="">
            <div class="login_bottom">
                <p>
                    <select id="company" value="">
                        <#list enterpriseInfoList as enterprise >
                            <option value="${enterprise.enterpriseUserId}">${enterprise.enterpriseName}</option>
                        </#list>
                    </select>
                </p>
                <p>
                    <input id="username" name="username" required="required" type="text" placeholder="用户名"/>
                </p>
                <p>
                    <input id="password" name="password" required="required" type="password" placeholder="密码" />
                </p>
                <p class="keeplogin">
                    <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
                    <label for="loginkeeping">记住账号</label>
                <div class="right_area">
                <!--<a href="###">忘记密码&nbsp</a>|-->
                <a href="${DOMAIN_PATH}/register.html">注册账号</a>
                </div>
                </p>

            </div>
            <div class="login_footer">
                <p class="login_button">
                    <input type="button" id="login-btn" value="登录"/>
                </p>
            </div>
        </form>
    </div>
</div>
</body>
</html>





