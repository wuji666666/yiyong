package cn.yi;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendEmail {

	public static void main(String[] args) throws MessagingException {
		//�ʼ�����������
		//����Э��SMTP��simple mail transfer protocol)
		//������֤��Ȩ
		//�����˵�ַ
		//�ռ��˵�ַ
		//�ռ�������
		//�ʼ�����
		//�ʼ�����
		
		//����һ���ļ�
		Properties pro=new Properties();
		pro.setProperty("mail.host", "smtp.qq.com");
		pro.setProperty("mail.transport.protocol", "smtp");
		pro.setProperty("mail.smtp.auth", "true");
		
		
		//������֤����
		Auth auth=new Auth();
		//��ȡһ��session�Ự����
		
		Session session=Session.getDefaultInstance(pro, auth);
		
		//��ȡ����
		Transport ts=session.getTransport();
		//���ӷ�����
		ts.connect("smtp.qq.com", "2214222026@qq.com", "uexqzfttgogweafc");
		
		//�����ʼ�����
		MimeMessage message=new MimeMessage(session);
		//���÷����˵�ַ
		message.setFrom(new InternetAddress("2214222026@qq.com"));
		
		
		//�����ռ��˵�ַ
		//message.setRecipient(Message.RecipientType.TO, new InternetAddress("2214222026@qq.com"));
		
		//Ⱥ���ʼ�
		InternetAddress[] address= {new InternetAddress("2214222026@qq.com"),new InternetAddress("123985354@qq.com")};
		message.setRecipients(Message.RecipientType.TO, address);
		//�����ʼ�����
		message.setSubject("java emailSend test");
		
		//�����ʼ�����
		message.setContent("�����ʼ�����", "text/html;charset=utf-8");

		//�����ʼ�
		ts.sendMessage(message,message.getAllRecipients());
		ts.close();
		System.out.println("�ʼ��������");
		
		
	}

}
