package lawyer.base.ccase.plugins.email.impl;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;

import lawyer.base.ccase.entity.SysUserExt;
import lawyer.base.ccase.plugins.email.MailService;

public class SmtpSendMailService implements MailService{
	
	private Logger logger = LoggerFactory.getLogger(SmtpSendMailService.class);
	
    @Value("${smtp.mail.send.server}")
    private String mailSendServer;
    @Value("${smtp.mail.send.protocol}")
    private String mailSendProtocol;
    @Value("${smtp.mail.send.content.code}")
    private String contentCode;
    
    @Value("${smtp.mail.send.username}")
    private String sendUserName;
    @Value("${smtp.mail.send.password}")
    private String sendUserPwd;
    @Value("${smtp.mail.send.from.email}")
    private String sendFrom;
    
    @Value("${mail.template.register}")
    private String registerTemplate;
    @Value("${mail.template.findPwd}")
    private String findPwdTemplate;
    
    @Autowired
    private VelocityEngine velocityEngine;
	
//    public static void sendMail(String fromEmail, String toEmail, String emailName, String emailPassword, String title,
//            String centent) throws Exception
//    {
//        Properties prop=new Properties();  
//        prop.put("mail.host","smtp.mxhichina.com" );  
//        prop.put("mail.transport.protocol", "smtp");  
//        prop.put("mail.smtp.auth", "true");  
//        Session session=Session.getInstance(prop);  
//        session.setDebug(true);
//        Transport ts=session.getTransport();  
//        ts.connect(emailName, emailPassword);  
//        Message message=new MimeMessage(session);  
//        message.setFrom(new InternetAddress(fromEmail));  
//        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));  
//        message.setSubject(title);  
//        message.setContent(centent, "text/html;charset=utf-8");    
//        ts.sendMessage(message, message.getAllRecipients()); 
//    }
//    
//    public static void main(String[] rags) {
//    	String fromEmail = "bgxt@xingquanlaw.com";
//    	String toEmail = "19352530@qq.com";
//    	String emailName = "bgxt@xingquanlaw.com";
//    	String emailPassword = "Bangong@123";
//    	String title = "发送一个邮件";
//    	String centent = "看看收到邮件了吗？";
//    	
//    	toEmail = "lixi114311@163.com";
//    	
//    	try {
//			SmtpSendMailService.sendMail(fromEmail, toEmail, emailName, emailPassword, title, centent);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    }

	@Override
	public boolean sendMail(String to, String title, String content) {
		try {
			Properties prop = new Properties();
			prop.put("mail.host", mailSendServer);
			prop.put("mail.transport.protocol", mailSendProtocol);
			prop.put("mail.smtp.auth", "true");
			Session session = Session.getInstance(prop);
			session.setDebug(true);
			Transport ts = session.getTransport();
			ts.connect(sendUserName, sendUserPwd);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sendFrom));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(title);
			message.setContent(content, "text/html;charset="+contentCode);
			ts.sendMessage(message, message.getAllRecipients());
			return true;
		} catch (Exception e) {
			logger.error(e + "", e);
		}
		return false;
	}

	@Async
	@Override
	public boolean sendRegisterMailByAsync(SysUserExt user) {
		String subject = "星权-账号信息";
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userName", user.getName());
		model.put("loginName", user.getEmail());
		model.put("webSite", user.getEmail());
		model.put("loginPwd", user.getPwd());
		model.put("date",  new SimpleDateFormat("yyyy年MM月dd号 HH时mm分").format(user.getCreatedTime()));
		StringWriter result = new StringWriter();
		velocityEngine.mergeTemplate(registerTemplate, contentCode, new VelocityContext(model), result);
		return sendMail(user.getEmail(), subject, result.toString());
	}

	@Async
	@Override
	public boolean sendFindPwdMailByAsync(SysUserExt user) {
		return false;
	}
}