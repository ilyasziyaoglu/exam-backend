package exam.backend.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MailUtils {

	private static final Logger log = LoggerFactory.getLogger(MailUtils.class);

	public final static String MAIL_SUBJECT_KEY = "mail.subject";
	public final static String CHARGE_BACK_MAIL_SUBJECT_KEY = "chargerback.mail.subject";

	public static boolean validateEmailByRegex(String email) {
		try {
			if (StringUtils.isEmpty(email)) {
				return false;
			}
			String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			Pattern pattern = Pattern.compile(emailPattern);
			return pattern.matcher(email).matches();
		} catch (Exception e) {
			log.error("validateEmailByRegex exception = " + e.getMessage(), e);
			return false;
		}
	}
//
//	public static Map<String, Object> getofferMailDataModel(Offer offer) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("offer", offer);
//		return map;
//	}

}
