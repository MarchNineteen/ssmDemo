<script type="text/javascript" src="${DOMAIN_PATH}/resources/js/enterprise-manager/enterprise-activity-list.js?${STATIC_VERSION?default('001')}"></script>

<!-- 查看企业活动部分 -->
<!-- 主体头部 -->
<#if ActivityList??>
<div class="main-left-body">
    <!-- 主体正文标题 -->
    <h3>活动中心</h3>
    <div class="main-left-body-top">
        <h4>活动列表</h4>
        <#--<form method="post" action="${DOMAIN_PATH}/activity/search/bytime.html" id="search-activity">-->
        <form method="post" action="" >
            <span></span>
            <input  id="starttime2" name="startTime" placeholder="开始时间" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
            <input  id="endtime2"  name="endTime" placeholder="结束时间" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
            <input type="button" name="search" id="search-activity"  value="查询">
        </form>
    </div>
    <!-- 主体部分正文内容 -->
    <div class="left-body2">
        <table class="table2">
            <thead>
            <tr>
                <th>序号</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>活动标题</th>
                <th>活动地址</th>
                <th>限制人数</th>
                <th>活动费用</th>
                <th>发布时间</th>
                <th>截止时间</th>
                <th colspan="2" align="center">操 作</th>
            </tr>
            </thead>
            <tbody>
            <#list ActivityList.content as list >
            <tr>
                <td align="center" title="${list_index}">${list_index+1}</td>
                <td align="center" title="${list.startTime?string("yyyy-MM-dd HH:mm:ss")}">${list.startTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td align="center" title="${list.stopTime?string("yyyy-MM-dd HH:mm:ss")}">${list.stopTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td align="center" title="${list.title}">${list.title}</td>
                <td align="center" title="${list.address}">${list.address}</td>
                <td align="center" title="${list.number}">${list.number}</td>
                <td align="center" title="${list.price}">${list.price}</td>
                <td align="center" title="${list.createTime?string("yyyy-MM-dd HH:mm:ss")}">${list.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td align="center" title="${list.deadTime?string("yyyy-MM-dd HH:mm:ss")}">${list.deadTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td>
                    <a href="${ACTIVITY_WEB_CONTEXT_PATH}/activity/detail.html?enterpriseUserId=${list.enterpriseUserId}&activityId=${list.id}&from=admin">查看详情</a>
                    <a href="${DOMAIN_PATH}/activity/apply/user.html?enterpriseUserId=${list.enterpriseUserId}&activityId=${list.id}" class="showpeople">查看报名用户</a>
                    <a href="${DOMAIN_PATH}/activity/applyToExcel.html?enterpriseUserId=${list.enterpriseUserId}&activityId=${list.id}">下载报名用户</a>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>
</#if>
<!-- 查看企业活动部分结束 -->
