<script type="text/javascript" src="${DOMAIN_PATH}/resources/js/enterprise-manager/enterprise-detail.js?${STATIC_VERSION?default('001')}"></script>

<!-- 查看资料部分 -->
<!-- 主体头部 -->

<#if enterpriseInfoDetail?? || SESSION_ENTERPRISE_LOGIN_USER_KEY??>
    <div class="main-left-body">
        <!-- 主体正文标题 -->
        <h3>企业用户中心</h3>
        <!-- 主体部分正文内容 -->
        <div class="left-body">
            <h4>查看资料</h4>
            <p class="sub-title">
                <a href="#">修改资料</a>
                <a id="save-Enterptise">保存</a>
            </p>
            <p class="body-title">
                <span>基本资料</span>
            </p>
            <p class="body-input">
                <label for="username">用户名：</label>
                <input id="username" type="text" name="username" required="required" value=${SESSION_ENTERPRISE_LOGIN_USER_KEY.userName?default('')}>
                <label for="companyname">公司名称：</label>
                <input id="companyname" type="text" name="companyname" required="required" value=${enterpriseInfoDetail.enterpriseName?default('')} />
            </p>
            <p class="body-input">
                <label for="address">公司地址：</label>
                <input id="address" type="text" name="address" required="required"  value=${enterpriseInfoDetail.enterpriseAddress?default('')}>

                <label for="comtelephone">公司联系电话：</label>
                <input id="comtelephone" name="comtelephone"  required="required" type="tel" value=${enterpriseInfoDetail.enterpriseTell?default('')} />
            </p>

            <p class="body-input">
                <label for="concet">联系人：</label>
                <input id="concet" type="text" name="concet" required="required" value=${enterpriseInfoDetail.enterpriseContacts?default('')} />

                <label for="concettel">联系人号码：</label>
                <input id="concettel" type="tel" name="concettel" required="required" value=${enterpriseInfoDetail.enterpriseContactsPhone?default('')} />
            </p>
            <#--<p class="body-input">-->
                <#--<label for="pay">收款账号：</label>-->
                <#--<input id="pay" type="text" name="pay" required="required" />-->
            <#--</p>-->

            <p class="body-title">
                <span>公司证件</span>

            </p>
            <p class="body-input">
                <label for="comcode">组织机构代码证号：</label>
                <input id="comcode" type="text" name="comcode" required="required" value=${enterpriseInfoDetail.enterpriseRecordCode?default('')} />
                <span>营业执照：</span>
                <img src="${IMAGE_CONTEXT_PATH}${enterpriseInfoDetail.enterpriseLicense?default('')}"/>
            </p>
            <p class="body-title">
                <span>注册时间</span>

            </p>
            <p class="body-time">
                <span>注册时间：</span>
                <time datetime="2016-08-27"">${enterpriseInfoDetail.createTime?string("yyyy-MM-dd HH:mm:ss")}</time>
            </p>
        </div>
    </div>
</#if>
