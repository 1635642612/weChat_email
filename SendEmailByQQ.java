package com.jeff.tianti.util;


import java.util.Properties;


import javax.mail.Authenticator;

import javax.mail.Message;

import javax.mail.PasswordAuthentication;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.Message.RecipientType;

import javax.mail.MessagingException;

import javax.mail.internet.AddressException;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;


/**
 *  * send email byqq
 * <p>
 *  *@authoradmin
 * <p>
 *  *
 * <p>
 *  
 */

public class SendEmailByQQ {


    public static void sendEmail(String to,String content) throws AddressException, MessagingException {

/*

  * 1、创建连接对象

               * 2、创建邮件对象

               * 3、发送邮件

               */

//            1、创建连接对象

        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtp");

        props.put("mail.smtp.host", "smtp.qq.com");

        props.put("mail.smtp.auth", "true");

        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        props.setProperty("mail.smtp.socketFactory.fallback", "false");

        props.setProperty("mail.smtp.port", "465");

        props.setProperty("mail.smtp.socketFactory.port", "465");

        Session session = Session.getInstance(props, new Authenticator() {


            protected PasswordAuthentication

            getPasswordAuthentication() {//认证信息

            return new PasswordAuthentication("120564917@qq.com", "gxvvbdzupdkrbjie");

            }


        });


//            2、创建邮件对象

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress("120564917@qq.com"));

        message.setRecipient(RecipientType.TO, new InternetAddress(to));

        message.setRecipient(RecipientType.CC, new InternetAddress("120564917@qq.com"));

        message.setSubject("客户信息");

       // message.setContent("" + content + "", "text / html; charset = utf-8 ");
        message.setContent("" + content + "", "text/html;charset=utf-8");


//            3、发送邮件

        Transport.send(message);
        System.out.println("发送成功");

    }

}
