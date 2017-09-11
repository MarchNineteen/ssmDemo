<#if ApplyUserList?? || ApplyActivity??>
<div class="registrationUser" xmlns="http://www.w3.org/1999/html">
    <div class="registrationUser-top">
        <span>查看报名用户</span>
    </div>
    <div class="registrationUser-middle">
        <p>
            活动标题：<span>${ApplyActivity.title?default('')}</span>
        </p>
        <p>
            报名截止时间：
            <span>${ApplyActivity.deadTime}</span></br>
            活动开始时间：
            <span>${ApplyActivity.startTime}</span></br>
            活动结束时间：
            <span>${ApplyActivity.stopTime}</span></br>
        </p>
        <p>
            活动报名人数：<small>${ApplyActivity.peopleNumber?default('')}/${ApplyActivity.number?default('')}(0表示不限人数)</small></br>
            总金额：￥<number style="color:red;">${ApplyActivity.amount?default('')}</number>
        </p>
    </div>
    <table border="1" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>手机号</th>
            <th>身份证</th>
            <th>邮箱</th>
            <th>学生证号</th>
            <th>备注信息</th>
            <th>签到</th>
            <th>状态</th>
        </tr>
        </thead>
        <tbody>
        <#list ApplyUserList as list>
        <tr>
            <td align="center" title="${list_index}">${list_index+1}</td>
            <td align="center" title="${(list.userName)!}">${list.userName?default('')}</td>
            <td align="center" title="${(list.phone)!}">${(list.phone)?default('')}</td>
            <td align="center" title="${(list.userIdCard)!}">${(list.userIdCard)?default('')}</td>
            <td align="center" title="${(list.email)!}">${(list.email)?default('')}</td>
            <td align="center" title="${(list.studentCard)!}">${(list.studentCard)?default('')}</td>
            <td align="center" title="${(list.remark!)}">${(list.remark)?default('')}</td>
            <td>
                <a href="${DOMAIN_PATH}/activity/sign.html?enterpriseUserId=${list.enterpriseUserId}&activityId=${list.activityId}&phone=${list.phone}"
                   data-callback="backForSign" type="button">签到</a>
            </td>
            <td align="center" title="${list.status}">
                <#if (list.status > 0)>
                    <font color="blue"> 已签到</font>
                <#else><font color="gray">未签到</font>
                </#if>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</#if>