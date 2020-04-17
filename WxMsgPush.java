package com.jeff.tianti.util;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeff.tianti.cms.entity.ContractUs;

/**
 * 微信消息推送
 *
 * @ClassName WxMsgPush
 * @Author denghaiping
 * @Date 2020/4/16 16:20
 **/
    @Component  
    public class WxMsgPush {

    /**
     * 微信公众号API的Service
     */
    @Autowired
    private  WxMpService wxMpService;


    /**
     * 发送微信模板信息
     *
     * @param openId 接受者openId
     * @return 是否推送成功
     */
    public boolean SendWxMsg(String openId, ContractUs contractUs) {
        // 发送模板消息接口
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                // 接收者openid
                .toUser(openId)
                // 模板id
                .templateId("2LGl0kzDPppW6DMFWi8pAor5wLb9cfppU6wvKgCrbhA")
                // 模板跳转链接
               // .url("http://www.baidu.com")
                .build();
        // 添加模板数据
        templateMessage.addData(new WxMpTemplateData("first", "客户访问信息", "#FF00FF"))
                .addData(new WxMpTemplateData("keyword1", contractUs.getName(), "#000000"))
                .addData(new WxMpTemplateData("keyword2", contractUs.getTelphone(), "#000000"))
                .addData(new WxMpTemplateData("keyword3", getNowTime(), "#000000"))
                .addData(new WxMpTemplateData("keyword4", "刚刚", "#000000"))
                .addData(new WxMpTemplateData("remark", contractUs.getProductneeds(), "#000000"));
        String msgId = null;
        try {
            // 发送模板消息
            msgId = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
       
        return msgId != null;
    }
    
    public static String getNowTime(){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sf.format(date);
        return now;
    }
}