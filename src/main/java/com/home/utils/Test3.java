package com.home.utils;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by 李小末 on 2019/6/3 16:04
 * 发送邮件的demo
 */
public class Test3 {
    public static void main(String[] args) {
        //收件人电子邮箱
        String to="891650711@qq.com";
        //发件人邮箱
        String from="2224657927@qq.com";
        //指定发送邮件的主机为localhost(smto.qq.com为qq邮箱的地址)
        String host="smtp.qq.com";
        //获取系统属性
        Properties properties = System.getProperties();
        //设置邮件服务器
        properties.setProperty("mail.smtp.host",host);

        properties.put("mail.smtp.auth","true");
        //获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication(){
                //发件人邮箱，授权的 QQ 邮箱密码（授权码）
                return new PasswordAuthentication("2224657927@qq.com","djdwxiorgvaseahg");
            }
        });
        try {
            //创建more的mimemessage
            MimeMessage message = new MimeMessage(session);
            //set from ：头部头字段
            message.setFrom(new InternetAddress(from));
            //set to:头部头字段
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            //set subject：头部头字段(标题)
            message.setSubject("This is the Subject Line!");
            //设置消息体
            message.setText("发送邮件的demo");
            //发送消息
            Transport.send(message);
            System.out.println("Sent message successfully......");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
