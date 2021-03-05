package com.app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Component
public class EmailUtil {

	//This interface is supports basic functionalities of sending simple mail and also MIME messeges.
	@Autowired
	private JavaMailSender sender;

	//creating mail simplemailmsg and storing the information
	public boolean sendEmail(String to,String subject,
			String cc[],String bcc[],
			String text,CommonsMultipartFile file) {
		
		//mail status flag
		boolean flag=false;
		
		try {
			//create empty mail
			MimeMessage message = sender.createMimeMessage();

			//Create a new MimeMessageHelper for the given MimeMessage in multipart mode.
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,file!=null?true:false);
			
			//message helper data
			messageHelper.setFrom("sivaboga333@gmail.com");
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(text);

			if(file!=null)
				messageHelper.addAttachment(file.getOriginalFilename(), file);
			else
				System.out.println("No file attached!..");
			//send mail
			sender.send(message);
		}catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
	//send email without attachment
	public boolean sendEmail(String to,String subject,String text) {
		return sendEmail(to, subject,null,null, text, null);
	}

	//send email without subject
	public boolean sendEmail(String to,String text) {
		return sendEmail(to, "NO SUBJECT",null,null, text, null);
	}
}


