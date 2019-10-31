package exam.backend.common.constant;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class GlobalConstants {

	private static GlobalConstants instance;

	static {
		instance = new GlobalConstants();
	}

	ThreadLocal<Object> crmSendFormater = new ThreadLocal<>();

	/**
	 * TODO İleride şemalar ayrıldığında "" ile değiştirilebilir ya da kaldırılabilir
	 */
	public static final String DB_PREFIX = "EXAM_";

	public static NumberFormat formatDoublePrice() {
		DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("tr", "TR"));
		Object obj = decimalFormat;
		return (NumberFormat) obj;
	}

	public static SimpleDateFormat getCrmSendDateFormat() {
		Object obj = instance.crmSendFormater.get();
		if (obj == null) {
			obj = new SimpleDateFormat("dd.MM.yyyy");
			instance.crmSendFormater.set(obj);
		}
		return (SimpleDateFormat) obj;
	}

}
