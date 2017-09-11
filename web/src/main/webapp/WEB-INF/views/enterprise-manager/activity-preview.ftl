<!DOCTYPE html>
<html>
<head>
    <title>预览活动</title>
    <#include "/common/header.ftl"/>
    <link rel="stylesheet" href="${DOMAIN_PATH}/resources/css/enterprise-manager/activity-preview.css${STATIC_VERSION?default('001')}" />
</head>
<body style="width:60rem;">
<#if publishParams??>
<nav>
    <img src="${IMAGE_CONTEXT_PATH}${publishParams.activityCoverImg?default('')}" class="backbtn"/>
    <img src="${IMAGE_CONTEXT_PATH}${publishParams.activityCoverImg?default('')}"width="100%" height="100%" class="nav"/>
	<span class="read">
		<img src="${DOMAIN_PATH}/resources/image/eye.png">&nbsp830
	</span>
</nav>

<div class="nav-bottom">
    <p class="nav-bottom-top">
    <h3>${publishParams.activityTitle?default('')}</h3>
    <small>￥${publishParams.price?default('')}</small>
    </p>
    <p>
        <#list publishParams.typeList as type>
            <span>${type.groupValDesc?default('')}</span>
        </#list>
        <small style="margin-top:0;">0/0</small>
    </p>
</div>
<div class="contact">
    <p>
        <img src="${DOMAIN_PATH}/resources/image/clock.png">
        <span>
            ${publishParams.startTime?string("yyyy-MM-dd HH:mm:ss")} 开始 / ${publishParams.stopTime?string("yyyy-MM-dd HH:mm:ss")} 结束
        </span>
    </p>
    <p>
        <img src="${DOMAIN_PATH}/resources/image/position.png">
        <span>
            ${publishParams.activityAddress?default('')}
        </span>
    </p>
    <p>
        <img src="${DOMAIN_PATH}/resources/image/people.png">
        <span>
            ${publishParams.publishUserPhone?default('')}
        </span>
    </p>
</div>
<div class="host">
    <p>
    <h4>主办方</h4>
    </p>
    <#list publishParams.organizerList as organizer>
        <p>
            <img src="${IMAGE_CONTEXT_PATH}${organizer.orgLogo}">
            <a href="javascript:;">关注</a>
        </p>
    </#list>

</div>
<div class="support2" >
    <p>
    <h4>赞助商</h4>
    </p>
    <p>
        <#list publishParams.sponsorList as sponsor>
            <img src="${IMAGE_CONTEXT_PATH}${sponsor.sponsorLogo}">
        </#list>
    </p>
</div>
<article class="article">
    <p>
    <h4>活动介绍</h4>
    </p>
    <h3>${publishParams.activityTitle?default('')}</h3>
    <p>
        ${publishParams.introduction?default('')}
    </p>
</article>
<div class="support2" >
    <p>
    <h4>
        已报名 <a href="javascript:;">0&nbsp></a>
    </h4>
    </p>
</div>
<a href="javascript:;" class="btn">我要报名</a>
</#if>
</body>
</html>