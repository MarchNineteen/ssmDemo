<!DOCTYPE html>
<html>
<head>
    <title>企业后台管理</title>
    <#include "/common/header.ftl"/>

    <link rel="stylesheet" href="${DOMAIN_PATH}/resources/plaugin/kindeditor/themes/default/default.css?${STATIC_VERSION?default('001')}"/>
    <link rel="stylesheet" href="${DOMAIN_PATH}/resources/plaugin/kindeditor/plugins/code/prettify.css?${STATIC_VERSION?default('001')}"/>

    <script charset="utf-8" src="${DOMAIN_PATH}/resources/plaugin/kindeditor/kindeditor.js?${STATIC_VERSION?default('001')}"></script>
    <script charset="utf-8" src="${DOMAIN_PATH}/resources/plaugin/kindeditor/lang/zh_CN.js?${STATIC_VERSION?default('001')}"></script>
    <script charset="utf-8" src="${DOMAIN_PATH}/resources/plaugin/kindeditor/plugins/code/prettify.js?${STATIC_VERSION?default('001')}"></script>


    <link rel="stylesheet" href="${DOMAIN_PATH}/resources/plaugin/laydate/need/laydate.css?${STATIC_VERSION?default('001')}"/>
    <script type="text/javascript" src="${DOMAIN_PATH}/resources/plaugin/laydate/laydate.js?${STATIC_VERSION?default('001')}"></script>
    <script type="text/javascript" src="${DOMAIN_PATH}/resources/js/enterprise-manager/enterprise-manager.js?${STATIC_VERSION?default('001')}"></script>
</head>
<body>
<div class="page">
    <!--左侧菜单-->
<#include "/enterprise-manager/part-left.ftl"/>
    <!--  主体-->
    <div class="main-left">
        <!--头部信息-->
    <#include "/enterprise-manager/part-header.ftl"/>

        <!-- 主体头部 -->
        <div class="main-body" id="main-body-div">

        </div>
        <!-- 主体头部 -->
    </div>
</div>
<#include "/common/bootom.ftl"/>


<script>
    var _k = KindEditor.create('#activity-introduction', {
        'filePostName': "imageFiles",
        'uploadJson': DOMAIN_PATH + '/upload/images.post',
        'resizeType': 1,
        'allowPreviewEmoticons': true,
        'allowImageUpload': true,
        afterUpload: function (url, data, name) {
            alert(url + data + name)
            //上传文件后执行的回调函数，必须为3个参数
        }
    });
</script>
</body>
</html>


