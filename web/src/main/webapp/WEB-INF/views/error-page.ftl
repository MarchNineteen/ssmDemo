<#include "/common/header.ftl"/>
<title>很抱歉，访问出错</title>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=f8c43a4483efebe3ead455c78e8b24d8"></script>
<link rel="stylesheet" href="${CONTEXT_PATH}/resources/css/error-page.css?${STATIC_VERSION?default('1001')}"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>很抱歉，访问出错！</title>
</head>
<body>

<div id="page" style="border-style:dashed;border-color:#e4e4e4;line-height:30px;background:no-repeat right;">
    <h1>抱歉，您本次访问发生了错误~~~~</h1>
    <h2>Sorry, this visit an error has occurred. </h2>
    <font color="#666666">您本次操作发生错误,可能是您错误操作造成！</font><br><br>
    <font color="#666666">${webResult.data?default('错误信息...')}</font><br>
    <font color="#666666">${webResult.message?default('错误信息...')}</font><br>
    <div class="button">
        <a href="${DOMAIN_PATH}/WEB-INF/views/common/index.html" title="去活动列表" target="_self">去活动列表</a>
    </div>
    <div class="button">
        <a href="javascript:window.history.go(-1);" title="返回上一页" target="_self">返回上一页</a>
    </div>
</div>

</body>
</html>