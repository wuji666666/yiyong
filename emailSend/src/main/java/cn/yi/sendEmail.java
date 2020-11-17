package cn.yi;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//yiyong+ziyan
public class sendEmail {

	public static void main(String[] args) throws MessagingException {
		//閭欢鏈嶅姟鍣ㄤ富鏈�
		//浼犺緭鍗忚SMTP锛坰imple mail transfer protocol)
		//閭璁よ瘉鎺堟潈
		//鍙戜欢浜哄湴鍧�
		//鏀朵欢浜哄湴鍧�
		//鏀朵欢浜洪偖绠�
		//閭欢涓婚
		//閭欢鍐呭
		
		//鍒涘缓涓�涓枃浠�
		Properties pro=new Properties();
		pro.setProperty("mail.host", "smtp.qq.com");
		pro.setProperty("mail.transport.protocol", "smtp");
		pro.setProperty("mail.smtp.auth", "true");
		
		
		//鍒涘缓璁よ瘉瀵硅薄
		Auth auth=new Auth();
		//鑾峰彇涓�涓猻ession浼氳瘽瀵硅薄
		
		Session session=Session.getDefaultInstance(pro, auth);
		
		//鑾峰彇杩炴帴
		Transport ts=session.getTransport();
		//杩炴帴鏈嶅姟鍣�
		ts.connect("smtp.qq.com", "2214222026@qq.com", "uexqzfttgogweafc");
		
		//鍒涘缓閭欢瀵硅薄
		MimeMessage message=new MimeMessage(session);
		//璁剧疆鍙戜欢浜哄湴鍧�
		message.setFrom(new InternetAddress("2214222026@qq.com"));
		
		
		//璁剧疆鏀朵欢浜哄湴鍧�
		//message.setRecipient(Message.RecipientType.TO, new InternetAddress("2214222026@qq.com"));
		
		//缇ゅ彂閭欢
		InternetAddress[] address= {new InternetAddress("2214222026@qq.com"),new InternetAddress("123985354@qq.com")};
		message.setRecipients(Message.RecipientType.TO, address);
		//璁剧疆閭欢鏍囬
		message.setSubject("java emailSend test");
		
		//璁剧疆閭欢鍐呭
		message.setContent("娴嬭瘯閭欢鍙戦��", "text/html;charset=utf-8");

		//鍙戦�侀偖浠�
		ts.sendMessage(message,message.getAllRecipients());
		ts.close();
		System.out.println("閭欢鍙戦�佸畬姣�");
		
		
	}

}
