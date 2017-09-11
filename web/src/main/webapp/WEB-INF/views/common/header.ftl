<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<#assign STATIC_VERSION="?10004"/>
<#assign CONTEXT_PATH="${request.contextPath}"/>
<#assign DOMAIN_PATH="${DOMAIN_PATH}"/>
<#assign IMAGE_CONTEXT_PATH="${IMAGE_CONTEXT_PATH}"/>
<#assign ACTIVITY_WEB_CONTEXT_PATH="${ACTIVITY_WEB_CONTEXT_PATH}"/>
<script>
    var CONTEXT_PATH = '${request.contextPath}';
    var DOMAIN_PATH = '${DOMAIN_PATH}';
    var IMAGE_CONTEXT_PATH = '${IMAGE_CONTEXT_PATH}';
    var ACTIVITY_WEB_CONTEXT_PATH = '${ACTIVITY_WEB_CONTEXT_PATH}';
</script>
<link rel="stylesheet" type="text/css" href="${DOMAIN_PATH}/resources/css/common.css${STATIC_VERSION}"/>
<link rel="stylesheet" type="text/css" href="${DOMAIN_PATH}/resources/css/common-style.css${STATIC_VERSION}"/>
<script src="${DOMAIN_PATH}/resources/js/common/jquery-1.7.2.js${STATIC_VERSION}"></script>
<script src="${DOMAIN_PATH}/resources/js/common/common-style-page.js${STATIC_VERSION}"></script>
<script src="${DOMAIN_PATH}/resources/js/common/CommonUtil.js${STATIC_VERSION}"></script>
<script src="${DOMAIN_PATH}/resources/js/common/common-sidebar-fllow.js${STATIC_VERSION}"></script>

<script type="text/javascript" src="${DOMAIN_PATH}/resources/js/common/jquery.validate-1.13.1.js?${STATIC_VERSION?default('001')}"></script>
<script type="text/javascript" src="${DOMAIN_PATH}/resources/js/common/validate-message-cn.js?${STATIC_VERSION?default('001')}"></script>
<script type="text/javascript" src="${DOMAIN_PATH}/resources/js/common/jquery.validate.ext.js?${STATIC_VERSION?default('001')}"></script>
<script type="text/javascript" src="${DOMAIN_PATH}/resources/js/common/ajax-file-upload.js?${STATIC_VERSION?default('001')}"></script>
<script type="text/javascript" src="${DOMAIN_PATH}/resources/js/common/additional-methods.js?${STATIC_VERSION?default('001')}"></script>