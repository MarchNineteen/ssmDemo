<!DOCTYPE html>
<html>
<head>
    <#include "/common/header.ftl"/>
    <title>企业入驻</title>
    <link type="text/css" rel="stylesheet" href="${DOMAIN_PATH}/resources/css/enterprise/enterprise-register.css?${STATIC_VERSION?default('001')}"/>
    <link type="text/css" rel="stylesheet" href="${DOMAIN_PATH}/resources/css/ajax-file-upload.css?${STATIC_VERSION?default('001')}"/>
    <script type="text/javascript" src="${DOMAIN_PATH}/resources/js/common/jquery.validate-1.13.1.js?${STATIC_VERSION?default('001')}"></script>
    <script type="text/javascript" src="${DOMAIN_PATH}/resources/js/common/validate-message-cn.js?${STATIC_VERSION?default('001')}"></script>
    <script type="text/javascript" src="${DOMAIN_PATH}/resources/js/common/jquery.validate.ext.js?${STATIC_VERSION?default('001')}"></script>
    <script type="text/javascript" src="${DOMAIN_PATH}/resources/js/common/ajax-file-upload.js?${STATIC_VERSION?default('001')}"></script>
    <script type="text/javascript" src="${DOMAIN_PATH}/resources/js/common/additional-methods.js?${STATIC_VERSION?default('001')}"></script>
    <script type="text/javascript" src="${DOMAIN_PATH}/resources/js/enterprise/enterprise-register.js?${STATIC_VERSION?default('001')}"></script>
</head>

<body>
<div class="middle">
    <div class="login_box">
        <div class="login_head">
            <p>活动管理平台注册</p>
        </div>
        <form autocomplete="off" action="" method="" id="demoForm">
            <div class="login_bottom">
                <#--<p>-->
                    <#--企业管理员信息-->
                <#--</p>-->
                <p>
                    <input id="enterprise-username" name="enterprise-username" required="required" type="text" placeholder="管理员用户名[字母数字类型]"/>
                    <span>*</span>
                </p>
                <p>
                    <input id="enterprise-password"  name="enterprise-password" required="required" type="password" placeholder="管理员密码"/>
                    <span>*</span>
                </p>
                <p>
                    <input id="enterprise-confirm-password" name="enterprise-confirm-password" required="required" type="password" placeholder="确认密码"/>
                    <span>*</span>
                </p>
                <#--<p>-->
                    <#--企业信息-->
                <#--</p>-->
                <p>
                    <input id="enterprise-name" name="enterprise-name" required="required" type="text" placeholder="公司名称"/>
                    <span>*</span>
                </p>
                <p>
                    <input id="enterprise-address" name="enterprise-address" required="required" type="text" placeholder="公司地址"/>
                    <span>*</span>
                </p>
                <p>
                    <input id="enterprise-tell" name="enterprise-tell" required="required" type="text" placeholder="公司联系电话"/>
                    <span>*</span>
                </p>
                <p>
                    <input id="enterprise-contacts" name="enterprise-contacts" type="text" required="required" placeholder="公司联系人"/>
                    <span>*</span>
                </p>
                <p>
                    <input id="enterprise-contacts-phone" name="enterprise-contacts-phone" type="tel" required="required" placeholder="公司联系人手机号号码"/>
                    <span>*</span>
                </p>
                <p>
                    <input id="enterprise-email" name="enterprise-email" type="text" required="required" placeholder="公司邮箱地址"/>
                    <span>*</span>
                </p>
                <p>
                    <input id="enterprise-record-code" name="enterprise-record-code" type="text" required="required" placeholder="公司组织机构代码证号"/>
                    <span>*</span>
                </p>
                <div class="right_bottom_q-register">
                    <p>
                        <span class="" style="float:left;">
                           营业执照：
                        </span>
                        <span class="upload-register">
                            <img id="upload-image-show" style="width:22rem;height:15rem;" src="${DOMAIN_PATH}/resources/image/upload.png"/>
                        </span>
                    </p>
                    <p>
                        <span class="tip-register" >支持JPG，PNG等格式图片必须小于2M</span>
                    </p>
                </div>
            </div>
            <div class="login_footer">
                <input value="注 册" type="submit"/>
            </div>
        </form>
    </div>
</div>

<#include "/common/bootom.ftl"/>
</body>
</html>