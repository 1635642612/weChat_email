package com.jeff.tianti.test;



import com.jeff.tianti.util.SendEmailByQQ;
import com.jeff.tianti.util.SendEmailByWY;
import com.jeff.tianti.util.WxMsgPush;
import me.chanjar.weixin.mp.api.WxMpService;

import javax.mail.MessagingException;

import javax.mail.internet.AddressException;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestWY {

  public static void main(String[] args) throws AddressException, MessagingException, SQLException {
      SendEmailByWY.sendEmail("1635642612@qq.com", "test邮件内容");
     // SendEmailByQQ.sendEmail("120564917@qq.com", "客户信息");
      //SendEmailByQQ.sendEmail("chent@genestone.com.cn", "客户姓名：柯南\n"+"<br/>单位：米花小镇\n"+"<br/>电话：11111\n"+"<br/>咨询业务：11111");
     /* WxMpService wxMpService =  new WxMpService();
      WxMsgPush push = new WxMsgPush();
      push.SendWxMsg("o15V4s1-xveukq8Co9Neyu9nH2y0");*/
    // Example: DriverManager.getDriver("jdbc:mysql://localhost:3306");
    java.sql.Driver mySqlDriver = DriverManager.getDriver("jdbc:mysql://124.232.138.122:3306/publiccms?useUnicode=true&characterEncoding=utf-8");
    DriverManager.deregisterDriver(mySqlDriver);

  }

}
