package cn.yi;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//yiyong
public class sendEmail {

	public static void main(String[] args) throws MessagingException {
		//邮件服务器主机
		//传输协议SMTP（simple mail transfer protocol)
		//邮箱认证授权
		//发件人地址
		//收件人地址
		//收件人邮箱
		//邮件主题
		//邮件内容
		
		//创建一个文件
		Properties pro=new Properties();
		pro.setProperty("mail.host", "smtp.qq.com");
		pro.setProperty("mail.transport.protocol", "smtp");
		pro.setProperty("mail.smtp.auth", "true");
		
		
		//创建认证对象
		Auth auth=new Auth();
		//获取一个session会话对象
		
		Session session=Session.getDefaultInstance(pro, auth);
		
		//获取连接
		Transport ts=session.getTransport();
		//连接服务器
		ts.connect("smtp.qq.com", "2214222026@qq.com", "uexqzfttgogweafc");
		
		//创建邮件对象
		MimeMessage message=new MimeMessage(session);
		//设置发件人地址
		message.setFrom(new InternetAddress("2214222026@qq.com"));
		
		
		//设置收件人地址
		//message.setRecipient(Message.RecipientType.TO, new InternetAddress("2214222026@qq.com"));
		
		//群发邮件
		InternetAddress[] address= {new InternetAddress("2214222026@qq.com"),new InternetAddress("123985354@qq.com")};
		message.setRecipients(Message.RecipientType.TO, address);
		//设置邮件标题
		message.setSubject("java emailSend test");
		
		//设置邮件内容
		message.setContent("测试邮件发送", "text/html;charset=utf-8");

		//发送邮件
		ts.sendMessage(message,message.getAllRecipients());
		ts.close();
		System.out.println("邮件发送完毕");
		
		
	}

}
