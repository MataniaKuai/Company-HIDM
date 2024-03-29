package com.hidm.booksharingscore.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendMailUtil {
    private static final String HOST = "smtp.hidmgroup.com";
    private static final Integer PORT = 25;
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String EMAILFORM = "itsystem@hidmgroup.com";
    private static String content = null;
    private static JavaMailSenderImpl mailSender = createMailSender();
    /**
     * 邮件发送器
     *
     * @return 配置好的工具
     */
    private static JavaMailSenderImpl createMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(HOST);
        sender.setPort(PORT);
//        sender.setUsername(USERNAME);
//        sender.setPassword(PASSWORD);
        sender.setDefaultEncoding("Utf-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout", "25000");
        p.setProperty("mail.smtp.auth", "false");
        sender.setJavaMailProperties(p);
        return sender;
    }

    /**
     * 发送邮件
     *
     * @param to 接受人
     * @param subject 主题
     * @param html 发送内容
     * @throws MessagingException 异常
     * @throws UnsupportedEncodingException 异常
     */
    public static void sendHtmlMail(String from, String fromName, String[]  to, String subject, String html) throws MessagingException,UnsupportedEncodingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        messageHelper.setFrom(from, fromName);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(html, true);
        mailSender.send(mimeMessage);
    }
    
    public static void sendRateNotice(String[]  to) throws MessagingException,UnsupportedEncodingException {
        String subject = "摄影评选系统已上线，诚邀您参与投票，感谢您的关注。";
    	String content = getContent();
    	sendHtmlMail(EMAILFORM, "摄影评选系统", to, subject, content);
    }
    
    public static String getContent() {
    	if (null != content) {
    		return content;
    	}
    	
    	content = "123123<br>";
    	
    	return content;
    }
    
    public static void main(String[] args) {
//    	try {
//			SendMailUtil.sendRateNotice("Matania.Kuai@hidmgroup.com");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
    }
}