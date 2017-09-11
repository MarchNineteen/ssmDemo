<script type="text/javascript" src="${DOMAIN_PATH}/resources/js/enterprise-manager/enterprise-user.js?${STATIC_VERSION?default('001')}"></script>


<!-- 用户管理部分 -->
<!-- 主体头部 -->
<#if EnterpriseAdminUserList??>
<div class="main-left-body" >
    <!-- 主体正文标题 -->
    <h3>添加管理用户</h3>
    <input type="submit" value="添加用户" class="addUserBtn">
    <!-- 主体部分正文内容 -->
    <div class="left-body">
        <table border="0" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <th>序号</th>
                <th>用户名</th>
                <th>手机号</th>
                <th>角 色</th>
                <th>操 作</th>
            </tr>
            </thead>
            <tbody>
                <#list EnterpriseAdminUserList as list>
                <tr>
                    <td align="center" title="${list_index}">${list_index+1}</td>
                    <td align="center" title="${list.username}">${list.username}</td>
                    <td align="center" title="${list.phone}">${list.phone}</td>
                    <td align="center" title="${list.userLevel}">
                        <#if (list.userLevel> 0)>
                            <font color="red"> 管理员</font>
                        <#else><font color="blue">超级管理员</font>
                        </#if>
                    </td>
                    <td>
                        <a class="edit" data-id = "${list.id}">编辑</a>
                        <a class="delEnterpriseUser" data-id="${list.id}">删除</a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
<!-- 弹窗2制作 -->

<div class="addUserPage editpage">
    <p class="addUserPagetop">
        <span>编辑用户</span>
        <img src="${DOMAIN_PATH}/resources/image/close2.png" class="hideBtn">
    </p>
    <form method="post" action="" id="editUser">

    <input name="id" value="" type="hidden">
        <p class="row">
            <label for="username2">用户名 </label>
            <input id="username2" type="text" name="username"  required="required" autofocus>
        </p>
        <p class="row">
            <label for="telephone2">手机号</label>
            <input id="telephone2" type="tel" name="telephone"   required="required">
        </p>
        <p class="row">
            <label  for="password2">密&nbsp&nbsp&nbsp码</label>
            <input id="password2" type="password" name="password"   required="required">
        </p>
        <input type="button" value="确定修改" id ="update-user-btu" class="confirmAddBtn">
    </form>
</div>


<!-- 弹窗1制作 -->
<div class="addUserPage addpage">
    <p class="addUserPagetop">
        <span>添加用户</span>
        <img src="${DOMAIN_PATH}/resources/image/close2.png" class="hideBtn">
    </p>
    <form method="post" action="" id="addUser">
        <p class="row">
            <label for="username">用户名 </label>
            <input id="username" type="text" name="username" required="required" autofocus>
        </p>
        <p class="row">
            <label for="telephone">手机号</label>
            <input id="telephone" type="tel" name="telephone" required="required" >
        </p>
        <p class="row">
            <label  for="password">密&nbsp&nbsp&nbsp码</label>
            <input id="password" type="password" name="password" required="required" >
        </p>
        <input type="button" value="确定添加" id = "addAdmin-btn" class="confirmAddBtn">
    </form>
</div>

</#if>
<!-- 用户管理部分结束 -->