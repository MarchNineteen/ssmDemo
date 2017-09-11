<script type="text/javascript" src="${DOMAIN_PATH}/resources/js/enterprise-manager/enterprise-modify-password.js?${STATIC_VERSION?default('001')}"></script>

<!-- 修改密码部分 -->
<div class="main-left-body">
    <!-- 主体正文标题 -->
    <h3>修改密码</h3>
    <!-- 主体部分正文内容 -->
    <div class="left-body">
        <h4>修改密码</h4>
        <form method="post" action="" id="changepsw">
            <p class="row">
                <span>*</span>
                <label for="old-password">原始密码：</label>
                <input id="old-password" type="password" name="old_password" required="required" autofocus >
            </p>
            <p class="row">
                <span>*</span>
                <label for="new-password">&nbsp新 密 码：</label>
                <input id="new-password" type="password" name="new_password" required="required" >
            </p>
            <p class="row">
                <span>*</span>
                <label  for="confirm-password">确认密码：</label>
                <input id="confirm-password" type="password" name="confirm_password" required="required" >
            </p>
            <input id="update-password-btn" type="button" value="保存" class="btn">
        </form>
    </div>
</div>
<!-- 修改密码部分结束 -->