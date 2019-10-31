package exam.backend.common.util;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PropertyUtil {

	protected static ConcurrentHashMap<String, String> properties = new ConcurrentHashMap<>();

	protected PropertyUtil() {
		throw new IllegalStateException("Utils class");
	}

	public static String getStringValue(String key) {
		return properties.get(key.toLowerCase());
	}

	public static String getStringValue(String key, String defaultVal) {
		String value = getStringValue(key);
		return StringUtils.isEmpty(value) ? defaultVal : value;
	}

	public static Integer getIntegerValue(String key, Integer defaultVal) {
		String value = getStringValue(key);
		return StringUtils.isEmpty(value) ? defaultVal : Integer.parseInt(value);
	}

	public static Boolean getBooleanValue(String key, Boolean defaultVal) {
		String value = getStringValue(key);
		return StringUtils.isEmpty(value) ? defaultVal : Boolean.parseBoolean(value);
	}

	public static Long getLongValue(String key, Long defaultVal) {
		String value = getStringValue(key);
		return StringUtils.isEmpty(value) ? defaultVal : Long.parseLong(value);
	}

	public static Double getDoubleValue(String key, Double defaultVal) {
		String value = getStringValue(key);
		return StringUtils.isEmpty(value) ? defaultVal : Double.valueOf(value);
	}

	public static BigInteger getBigIntegerValue(String key, BigInteger defaultVal) {
		String value = getStringValue(key);
		return StringUtils.isEmpty(value) ? defaultVal : new BigInteger(value);
	}

	public static void clearProperties() {
		properties.clear();
	}

	public static void addProperty(String key, String val) {
		properties.put(key.toLowerCase(), val);
	}

	public static void deleteProperty(String key) {
		properties.remove(key.toLowerCase());
	}

	public static void updateProperty(String key, String val) {
		properties.replace(key.toLowerCase(), val);
	}

	public static Map<String, String> getPropertiesMap() {
		return properties;
	}

}
