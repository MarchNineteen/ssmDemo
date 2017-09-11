<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
</head>
<title>完成报名</title>

<script src="${DOMAIN_PATH}/resources/js/common/jquery.min.js??10003"></script>
<script src="${DOMAIN_PATH}/resources/js/common/remchange.js??10003"></script>
<script src="${DOMAIN_PATH}/resources/js/activity/activity-success.js??10003"></script>
<link rel="stylesheet" href=${DOMAIN_PATH}"/resources/css/common.css??10003"/>

</head>
<body>
<div class="singedupbg1">
    <div class="header">
        <#--<a href="confirm.html" style="text-decoration: none">-->
            <#--<div class="headerreturn">-->
                <#--<div class="headerreturn1">-->
                    <#--<img src="${DOMAIN_PATH}/resources/image/return1.png" width="100%" height="100%"/>-->
                <#--</div>-->
                <#--<div class="headerreturn2">-->
                    <#--<img src="${DOMAIN_PATH}/resources/image/return2.png" width="100%" height="100%"/>-->
                <#--</div>-->
            <#--</div>-->
        <#--</a>-->
        <div class="wybmfont">完成报名</div>
    </div>
    <div class="shape">
        <#--<div class="shape1"><img src="${DOMAIN_PATH}/resources/image/success.png" width="100%" height="100%"/></div>-->
        <div class="thanks">报名成功，感谢您的参与！</div>
    </div>
    <div class="erweimabox">
        <div class="payfontheaded">
            ${activityTitle?default('')}
        </div>
        <div class="erweimapic">
            <img src="${qrcodeUrl?default('二维码')}"/>
        </div>
        <div class="Activitynumber">
                活动识别号<br/>
            ${activityCdkey?default('')}
        </div>
        <div class="Activitynumberdown">
            请妥善保存您的活动识别号
            以便为您进行后续服务
        </div>
        <div class="erweimapicmailfont">如有问题请咨询官方客服邮箱 cosmoscape@163.com</div>
    </div>

    <a href="${DOMAIN_PATH}/activity/detail.html?enterpriseUserId=${enterpriseUserId?default('100001')}&activityId=${activityId?default('')}">
        <div class="nextstep">返回活动介绍</div>
    </a>
</div>
</body>
</html>
