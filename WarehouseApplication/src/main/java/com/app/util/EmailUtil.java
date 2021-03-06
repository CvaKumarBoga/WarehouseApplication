package com.app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender sender;
	
	public boolean sendEmail(String to,String subject,
			String cc[],String bcc[],
			String text,CommonsMultipartFile file) {
		
		boolean flag=true;
		try {
			MimeMessage message=sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,file!=null?true:false);
			helper.setFrom("sivaboga555@gmail.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			
			if(cc!=null && cc.length>0)
				helper.setCc(cc);
			if(bcc!=null && bcc.length>0)
				helper.setBcc(bcc);
			
			if(file!=null) 
				helper.addAttachment(file.getOriginalFilename(),file);
				else 
					System.out.println("file is not found");
				sender.send(message);
				flag=true;
		}
		catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
	
		public boolean sendEmail(String to,String subject,String text) {
			return sendEmail(to, subject,null,null, text, null);
		}
		
		public boolean sendEmail(String to,String text) {
			return sendEmail(to, "NO SUBJECT",null,null, text, null);
		}

}
