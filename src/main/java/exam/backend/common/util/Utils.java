package exam.backend.common.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Utils {

	public static URL prepareURL(String _url, int connectTimeoutMiliSecond, int readTimeoutMiliSecond) throws MalformedURLException {
		// URL creation with TimeOut definition
		URL endpoint = new URL(null, _url, new URLStreamHandler() {

			@Override
			protected URLConnection openConnection(URL url) throws IOException {
				URL clone_url = new URL(url.toString());
				HttpURLConnection clone_urlconnection = (HttpURLConnection) clone_url.openConnection();
				clone_urlconnection.setConnectTimeout(connectTimeoutMiliSecond);
				clone_urlconnection.setReadTimeout(readTimeoutMiliSecond);
				return (clone_urlconnection);
			}
		});
		return endpoint;
	}

	// public static Stream<T> pager(Pager pager, Stream<T> stream) {
	// if (pager != null) {
	// pager.setTotalCount(stream.count());
	//
	// List<T> list = stream.collect(Collectors.toList());
	// List<T> pagerList = new ArrayList<>();
	//
	// for (int i = pager.getFirstResult(); i < pager.getEnd(); i++) {
	// pagerList.add(list.get(i));
	// }
	//
	// return pagerList.stream();
	//
	// }
	//
	// return stream;
	// }

	public static <T> List<List<T>> splitList(List<T> original, int count) {
		ArrayList<List<T>> result = new ArrayList<>();

		Iterator<T> it = (Iterator<T>) original.iterator();
		int each = original.size() / count;
		int remaining = original.size() % count;
		each = remaining > 0 ? ++each : each;

		for (int i = 0; i < each; i++) {
			List<T> s = new ArrayList<>();
			result.add(s);
			for (int j = 0; j < count && it.hasNext(); j++) {
				s.add((T) it.next());
			}
		}

		return result;
	}

	public static String getCellValue(Row row, int ind, String defaultValue) {
		if (row != null) {
			Cell cell = row.getCell(ind);
			if (cell != null) {
				try {
					String str = null;
					if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
						str = "" + (long) cell.getNumericCellValue();
					} else if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
						str = cell.getStringCellValue();
					} else if (Cell.CELL_TYPE_BOOLEAN == cell.getCellType()) {
						str = String.valueOf(cell.getBooleanCellValue());
					}
					return str;
				} catch (Exception e) {
					return defaultValue;
				}
			}
		}
		return defaultValue;
	}

	public static boolean maxInputSizeExceed(InputStream inputStream) {
		try {
			Integer maxSize = PropertyUtil.getIntegerValue("config.input.max.size", 10);
			double inputTotalMb = inputStream.read() / (1024 * 1024);
			return inputTotalMb >= maxSize;
		} catch (IOException e) {
			return false;
		}
	}

}
