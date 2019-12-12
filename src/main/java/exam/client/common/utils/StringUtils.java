package exam.client.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static final String HTML_LINE_BREAK = "<br/>";
	public static final String HTML_SPACE = "&nbsp;";
	public static final String SPACE = " ";
	public static final String EMPTY = "";
	public static final String PERCENT = "%";
	private static final String[] TURKISH_CHARS = {"ö", "ç", "ş", "ı", "ğ", "ü", "Ö", "Ç", "Ş", "İ", "Ğ", "Ü"};
	private static final String[] ENGLISH_CHARS = {"o", "c", "s", "i", "g", "u", "O", "C", "S", "I", "G", "U"};
	private static final String[] QUERY_TURKISH_CHARS = {"ı", "İ", "I", "i"};
	private static final String SPECIAL_CHARS = "[&%^()\\[\\]<>*?\"'!\\\\-]";

	public static String convertToString(Number number) {
		return convertToString(number, null);
	}

	public static String convertToString(Number number, String nullValue) {
		if (number != null) {
			return number.toString();
		}
		return nullValue != null ? nullValue : "";
	}

	public static String convertStringCollectionToString(Collection<String> stringList) {
		StringBuilder convertSrt = new StringBuilder();
		for (String string : stringList) {
			convertSrt.append(string);
			convertSrt.append("\r\n");
		}
		return convertSrt.toString();
	}

	public static String convertStringCollectionToStringHTMLDelimiter(Collection<String> stringList) {
		StringBuilder convertSrt = new StringBuilder();
		for (String string : stringList) {
			convertSrt.append(string).append(StringUtils.HTML_SPACE).append(StringUtils.HTML_LINE_BREAK);
		}
		return convertSrt.toString();
	}

	public static String[] parseStringToArray(String str, String delimeter) {
		StringTokenizer tokenizer = new StringTokenizer(str, delimeter);
		String[] toArray = new String[tokenizer.countTokens()];
		int count = 0;
		while (tokenizer.hasMoreElements()) {
			toArray[count] = tokenizer.nextToken();
			count++;
		}
		return toArray;
	}

	public static List<String> getListFromString(String string, String separator) {
		List<String> list = new ArrayList<>();
		if (string != null) {
			StringTokenizer tk = new StringTokenizer(string, separator);
			while (tk.hasMoreTokens()) {
				list.add(tk.nextToken());
			}
		}
		return list;
	}

	public static String addMultipleStringToString(String str, int count) {
		StringBuilder convertSrt = new StringBuilder();
		for (int i = 0; i < count; i++) {
			convertSrt.append(str);
		}
		return convertSrt.toString();
	}

	public static String prepareSearchText(String txt) {
		String text = txt;
		if (StringUtils.isNoneBlank(text)) {
			text = StringUtils.removeTurkishChar(text);
			text = text.toLowerCase();
		}
		return text;
	}

	public static String removeTurkishChar(String txt) {
		String text = txt;
		if (StringUtils.isNoneBlank(text)) {
			for (int i = 0; i < StringUtils.TURKISH_CHARS.length; i++) {
				text = text.replaceAll(StringUtils.TURKISH_CHARS[i], StringUtils.ENGLISH_CHARS[i]);
			}
		}
		return text;
	}

	public static String removeSpecialChar(String txt) {
		String text = txt;
		if (StringUtils.isNoneBlank(text)) {
			text = text.replaceAll(StringUtils.SPECIAL_CHARS, " ");
		}
		return text;
	}

	public static String replaceQueryTurkishChar(String txt) {
		String text = txt;
		if (StringUtils.isNoneBlank(text)) {
			for (int i = 0; i < StringUtils.QUERY_TURKISH_CHARS.length; i++) {
				text = text.replaceAll(StringUtils.QUERY_TURKISH_CHARS[i], StringUtils.PERCENT);
			}
		}
		return text;
	}

	public static String replaceStringWithDelimeter(String text, String[] values, String delimeter) {
		StringBuilder result = new StringBuilder();
		String[] parsedTextArray = text.split(delimeter);
		for (int i = 0; i < parsedTextArray.length; i++) {
			String currentValue = StringUtils.EMPTY;
			if (i < values.length) {
				currentValue = values[i];
			}
			result.append(parsedTextArray[i]).append(currentValue);
		}
		return result.toString();
	}

	public static String getShorterName(String txt, int maxLength) {
		String shortTxt = txt;
		if (shortTxt != null && maxLength > 0 && shortTxt.length() > maxLength) {
			shortTxt = shortTxt.substring(0, maxLength - 1) + "...";
		}
		return shortTxt;
	}

	public static String cleanUpHTML(String content, boolean comments, boolean spaces, boolean whitespace) {
		String result = content;
		if (whitespace) {
			result = result.replaceAll("(\\r|\\n|\\t)", StringUtils.SPACE);
		}
		if (comments) {
			result = result.replaceAll("<!--(.|\\s)*?-->", StringUtils.EMPTY);
		}
		if (spaces) {
			result = result.replaceAll("[\\s] *", StringUtils.SPACE).replaceAll(">[\\s]*", ">").replaceAll("[\\s]*<", "<")
					.replaceAll("\"[\\s]*/>", "\"/>");
		}
		return result;
	}

	public static String isHasElse(String value, String elseStr) {
		return StringUtils.isNoneBlank(value) ? value : elseStr;
	}

	public static String isHasElseEmpty(String value) {
		return StringUtils.isNoneBlank(value) ? value : StringUtils.EMPTY;
	}

	public static String defaultString(String str) {
		return str == null ? StringUtils.EMPTY : str;
	}

	public static String appendWith(String base, String adding, String delimiter) {
		return StringUtils.appendWith(base, adding, delimiter, false);
	}

	public static String appendWith(String base, String adding, String delimiter, boolean reverse) {
		return StringUtils.appendWith(base, adding, delimiter, reverse, false);
	}

	public static String appendWith(String base, String adding, String delimiter, boolean reverse, boolean force) {
		if (StringUtils.isNothing(adding) && force) {
			adding = "";
		}
		if (StringUtils.isNothing(adding) && !force) {
			return base;
		} else if (StringUtils.isNothing(base)) {
			return adding;
		} else {
			if (reverse) {
				return adding + delimiter + base;
			} else {
				return base + delimiter + adding;
			}
		}
	}

	public static boolean isNothing(String test) {
		if (test == null) {
			return true;
		} else {
			test = test.trim();
			return test.length() == 0 || test.equalsIgnoreCase("null") || test.equalsIgnoreCase("undefined");
		}
	}

}
