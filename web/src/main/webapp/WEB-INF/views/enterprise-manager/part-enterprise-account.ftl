<script type="text/javascript" src="${DOMAIN_PATH}/resources/js/enterprise-manager/enterprise-account.js?${STATIC_VERSION?default('001')}"></script>

<div class="main-left-body">

        <!-- 主体正文标题 -->
        <h3>企业用户中心</h3>
        <!-- 主体部分正文内容 -->
    <div class="left-body">
            <h4>资金账户</h4>
            <p class="body-title">
                <span>银行账户</span>
            </p>
            <p class="body-input">
                <label for="payee">收款人：</label>
                <input id="payee" type="text" name="payee" required="required" value="${(enterpriseAccountDetail.bankPayee)?default('')}">
            </p>
            <p class="body-input">
                <label for="bank">开户行：</label>
                <input id="bank" type="text" name="bank" required="required" value="${(enterpriseAccountDetail.bankName)?default('')}" >
            </p>

            <p class="body-input">
                <label for="bankadd">开户行地址：</label>
                <input id="bankadd" type="text" name="bankadd" required="required" value="${(enterpriseAccountDetail.bankAddress)?default('')}" />
            </p>
            <p class="body-input">
                <label for="bankid">银行卡账户：</label>
                <input id="bankid" type="text" name="bankid" required="required" value="${(enterpriseAccountDetail.bankAccount)?default('')}" />
            </p>

            <p class="body-title">
                <span>支付宝账户</span>
            </p>
            <p class="body-input">
                <label for="payee2">收款人：</label>
                <input id="payee2" type="text" name="payee2" required="required" value="${(enterpriseAccountDetail.alipayPayee)?default('')}" />
            </p>
            <p class="body-input">
                <label for="bankid2">账号：</label>
                <input id="bankid2" type="text" name="bankid2" required="required" value="${(enterpriseAccountDetail.alipayAccount)?default('')}" />
            </p>
            <p class="body-title">
                <span>微信账户</span>
            </p>
            <p class="body-input">
                <label for="payee3">收款人：</label>
                <input id="payee3" type="text" name="payee3" required="required" value="${(enterpriseAccountDetail.wechatPayee)?default('')}" />
            </p>
            <p class="body-input" >
                <label for="bankid3">账号：</label>
                <input id="bankid3" type="text" name="bankid3" required="required" value="${(enterpriseAccountDetail.wechatAccount)?default('')}"  />
            </p>
        <div id="account" value="<#if enterpriseAccountDetail??>/enterprise/account/update.post<#else >/enterprise/account/save.post</#if>">
        </div>
            <input type="button" value="<#if enterpriseAccountDetail??>修改<#else >保存</#if>" id = "save_account-btn" class="btn" style="margin:3rem 15rem;">
        </div>

</div>