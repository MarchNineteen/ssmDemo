<script type="text/javascript" src="${DOMAIN_PATH}/resources/js/enterprise-manager/enterprise-activity-push.js?${STATIC_VERSION?default('001')}"></script>
<div class="main-left-body">
    <!-- 主体正文标题 -->
    <h3>活动中心</h3>
    <!-- 主体部分正文内容 -->
    <div class="left-body">
        <h4>发布活动</h4>
        <p class="body-title">
            <span>活动信息</span>
        </p>
        <p class="body-input">
            <label for="acttitle">活动标题：</label>
            <input type="text" style=" width:73%;" required="required" name="acttitle" id="acttitle">
        </p>
        <p class="body-input">
            <label for="starttime">开始时间：</label>
            <input id="starttime" placeholder="开始时间" class="laydate-icon">
            <label for="endtime">结束时间：</label>
            <input class="laydate-icon" placeholder="结束时间" name="endtime" id="endtime"/>
        </p>

        <p class="body-input">
            <label for="deadline">报名截止时间：</label>
            <input class="laydate-icon" placeholder="报名截止时间" name="deadline" id="deadline">
            <label for="contralnum">限制人数：</label>
            <input type="radio" value="0" checked="" name="people">不限制&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" value="1" name="people">限制
            <input id="limit-num" type="number" name="number" value="1"/>
        </p>
        <p class="body-input">
            <label for="actaddress">活动地址：</label>
            <input type="text" required="required" name="actaddress" id="actaddress">

            <label for="telephone">联系方式：</label>
            <input type="tel" required="required" name="telephone" id="telephone">
        </p>
        <p class="body-input activity">
            <label for="actaddress">活动类型：</label>
            <#if enterpriseActivityConfigVo??>
                <#list enterpriseActivityConfigVo.typeList as type>
                    <input type="checkbox" group="${type.groupKey?default('')}" group-val-desc="${type.groupValDesc?default('')}" group-val="${type.groupVal?default('')}" name="activity-types">${type.groupValDesc?default('')}
                </#list>
            </#if>
            <input id="new-activity-input" type="text" class="new-activity-input" style="display: none;"/>
            <button id="add-more-organizer" class="moreType">更多类型</button>
        </p>
        <p class="body-input">
            <label for="actmoney">活动费用：</label>
            <input maxLength="6" type="text" required="required" name="actmoney" id="actmoney" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}">
        </p>

        <div class="right_bottom_q ">
            <p class="organizer-info">
                <label for="uploadfile1">活动主办方：</label>
                <span class="upload">
                    <img class="upload-image" name="organizer-logo" src="${DOMAIN_PATH}/resources/image/logo1.png" style=""/>
                    <img class="upload-image" name="organizer-qrcode" src="${DOMAIN_PATH}/resources/image/sec.png" style=""/>
                    <span class="hostname">主办方名称：
                        <input name="organizer-name" type="text" value=""/>
                    </span>
                </span>
                <button class="moreHost" id="add-organizer-btn">添加主办方</button>
            </p>
            <p id="organizer-one" style="display: none;" class="organizer-info">
                <span class="upload hid1" style="display: inline;">
                    <img class="upload-image" name="organizer-logo" src="${DOMAIN_PATH}/resources/image/logo1.png" style=""/>
                    <img class="upload-image" name="organizer-qrcode" src="${DOMAIN_PATH}/resources/image/sec.png" style=""/>
                    <span class="hostname">主办方名称：
                        <input name="organizer-name" type="text" value=""/>
                    </span>
                    <button class="delete-organizer">删除</button>
                </span>
            </p>
            <p id="organizer-two" style="display: none;" class="organizer-info">
                <span class="upload hid2" style="display: inline;">
                    <img class="upload-image" name="organizer-logo" src="${DOMAIN_PATH}/resources/image/logo1.png" style=""/>
                    <img class="upload-image" name="organizer-qrcode" src="${DOMAIN_PATH}/resources/image/sec.png" style=""/>
                    <span class="hostname">主办方名称：
                        <input type="text" name="organizer-name"  value=""/>
                    </span>
                    <button class="delete-organizer">删除</button>
                </span>
            </p>
        </div>

        <div style="margin-top:3rem;" class="right_bottom_q">
            <p>
                <label for="uploadfile2">赞助商：</label>
            </p>
            <div class="supportHead">
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png" class="upbtn supportbtn upload-image"/>
                <img name="sponsor-image"  src="${DOMAIN_PATH}/resources/image/supp.png"" class="upbtn supportbtn upload-image"/>
            </div>
        </div>

        <div class="right_bottom_q">
            <p>
                <label for="uploadfile3">活动封面：</label>
                <span class="upload">
                    <img id="activity-cover-image" class="upbtn upload-image" src="${DOMAIN_PATH}/resources/image/cover.png" style=""/>
                </span>
            </p>
        </div>

        <p class="body-title">
            <span>活动详情</span>
        </p>
        <p class="body-input">
            <textarea id="activity-introduction" placeholder="请输入活动详情" autofocus></textarea>
        </p>

        <p class="body-title">
            <span>报名人信息采集列表</span>
        </p>
        <p class="body-input">
            <label for="infoway">信息采集方式：</label>
        <#if enterpriseActivityConfigVo??>
            <#list enterpriseActivityConfigVo.applyList as apply>
                <#if apply.isNeed == 1 >
                    <input is-base-info="1" type="radio" group="${apply.groupKey}" group-val="${apply.groupVal}" group-val-desc="${apply.groupValDesc}" class="activity-apply-need" checked="">${apply.groupValDesc?default('')}
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </#if>
            </#list>
            <br/>
            <#list enterpriseActivityConfigVo.applyList as apply>
                <#if apply.isNeed != 1 >
                    <#if apply.groupVal != "APPLY_REMARK">
                        <input is-base-info="0" type="checkbox" group="${apply.groupKey}" group-val="${apply.groupVal}" group-val-desc="${apply.groupValDesc}" class="activity-apply-checkbox">${apply.groupValDesc?default('')}
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <#else>
                        <input is-base-info="0" type="checkbox" group="${apply.groupKey}" group-val="${apply.groupVal}" group-val-desc="${apply.groupValDesc}" class="activity-apply-checkbox">${apply.groupValDesc?default('')}
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="activity-apply-remark" type="text" value="" placeholder="请填写备注信息"/>
                    </#if>
                </#if>
            </#list>
        </#if>
        </p>
        <span class="info-tip">此活动由磨古方代为收款，将在报名结束24小时内到您的账户。</span>
        <div class="info-btn">
            <input id="activity-preview-btn" type="button" style="background-color: #008cd7;" value="预览" name=""/>
            <input id="activity-publish-btn" type="button" style="background-color: #8ab81a;" value="发布" name="">
        </div>

    </div>
</div>