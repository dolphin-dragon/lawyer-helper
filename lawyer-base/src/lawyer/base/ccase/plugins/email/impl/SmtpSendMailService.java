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
    
    @Value("${smtp.mail.send.port}")
    private int mailSendPort;
    @Value("${smtp.mail.send.timeout}")
    private int sendTimeOut;
    @Value("${smtp.mail.send.auth}")
    private Boolean auth;
    @Value("${smtp.mail.send.isSSL}")
    private Boolean isSll;
    
    @Autowired
    private VelocityEngine velocityEngine;

	@Override
	public boolean sendMail(String to, String title, String content) {
		try {
			Properties prop = new Properties();
			prop.put("mail.smtp.host", mailSendServer);
			prop.put("mail.smtp.port", mailSendPort);
			prop.put("mail.transport.protocol", mailSendProtocol);
			prop.put("mail.smtp.timeout",sendTimeOut);//时间延迟
			prop.put("mail.smtp.auth", auth);
			
			if(isSll)
				prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			
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