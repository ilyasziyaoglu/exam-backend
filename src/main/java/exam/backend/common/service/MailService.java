package exam.backend.common.service;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.model.MailEvent;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.apache.velocity.tools.generic.MathTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

@Component
public class MailService extends BaseService {

	@Resource
	private JavaMailSender mailSender;

	@Autowired
	protected MessageSource messageSource;

	@PostConstruct
	protected void init() {
		Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		Velocity.init();
	}

	public void send(MailEvent mailEvent) throws Throwable {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			mimeMessage.setSubject(mailEvent.getSubject(), "UTF-8");
			mimeMessage.setFrom(new InternetAddress(mailEvent.getFrom()));
			if (StringUtils.isNotEmpty(mailEvent.getTo())) {
				mimeMessage.setRecipients(Message.RecipientType.TO, getToMailAddresses(mailEvent.getTo()));
			}
			if (StringUtils.isNotEmpty(mailEvent.getBcc())) {
				mimeMessage.setRecipients(Message.RecipientType.BCC, getToMailAddresses(mailEvent.getBcc()));
			}
			if (StringUtils.isNotEmpty(mailEvent.getCc())) {
				mimeMessage.setRecipients(Message.RecipientType.CC, getToMailAddresses(mailEvent.getCc()));
			}

			MimeMultipart content = new MimeMultipart();

			if (StringUtils.isNotEmpty(mailEvent.getVm())) {
				MimeBodyPart html = new MimeBodyPart();
				html.setContent(mergeTemplate(mailEvent.getVm(), mailEvent.getDataModel()), "text/html; charset=UTF-8");
				content.addBodyPart(html);
			}

			if (!mailEvent.getFiles().isEmpty()) {
				mailEvent.getFiles().forEach(file -> {
					try {
						MimeBodyPart sendFile = new MimeBodyPart();
						sendFile.attachFile(file);
						sendFile.setFileName(mailEvent.getFileName() + "." + FilenameUtils.getExtension(file.getPath()));
						content.addBodyPart(sendFile);
					} catch (IOException e) {
					} catch (MessagingException e) {
					}
				});
			}

			mimeMessage.setContent(content);
			mimeMessage.saveChanges();
			mailSender.send(mimeMessage);
//			logger.info("mail basariyla gonderildi.");

		} catch (MailException ex) {
		} catch (Exception ex) {
		}

	}

	private String mergeTemplate(String vm, Map<String, Object> data) throws Throwable {
		VelocityContext context = new VelocityContext();

		// Common attributes
		context.put("math", new MathTool());
		context.put("locale", Locale.getDefault());
		context.put("number", GlobalConstants.formatDoublePrice());
		context.put("dateFormat", GlobalConstants.getCrmSendDateFormat());
		context.put("noArgs", new Object[] {});
		context.put("messageSource", messageSource);
//		logger.info("messageSource for mail " + messageSource);

		if (!data.isEmpty()) {
			data.forEach((k, v) -> {
				context.put(k, v);
			});
		}

		String vmPath = "templates/mail/" + vm + ".vm";
		Template template = Velocity.getTemplate(vmPath, StandardCharsets.UTF_8.name());
		StringWriter writer = new StringWriter();
		template.merge(context, writer);
		return writer.toString();
	}

	private InternetAddress[] getToMailAddresses(String emails) throws Throwable {
		List<String> toMails = Arrays.asList(StringUtils.split(emails, ","));
		List<InternetAddress> validToMails = new ArrayList<>();
		for (String e : toMails) {
			if (validateEmailByRegex(e)) {
				validToMails.add(new InternetAddress(e));
			}
		}
		return validToMails.toArray(new InternetAddress[0]);
	}

	public boolean validateEmailByRegex(String email) {
		try {
			if (StringUtils.isEmpty(email)) {
				return false;
			}
			String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			Pattern pattern = Pattern.compile(emailPattern);
			return pattern.matcher(email).matches();
		} catch (Exception e) {
			return false;
		}
	}
}
