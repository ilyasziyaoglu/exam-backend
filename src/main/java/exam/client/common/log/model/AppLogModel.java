package exam.client.common.log.model;

import exam.client.common.log.BaseLogModel;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class AppLogModel extends BaseLogModel {

	private String exceptionStackTrace;

	public AppLogModel() {
		this.logTimeStr = DateFormatUtils.format(this.logTime, LOG_DATE_TIME_FORMAT);
	}

	public String setStackTrace(final Throwable throwable) {
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw, true);
		try {
			throwable.printStackTrace(pw);
			return sw.getBuffer().toString();
		} catch (Exception e) {
			return throwable.getMessage();
		} finally {
			try {
				sw.close();
				pw.close();
			} catch (IOException e) {
				throw new AssertionError("StringWriter#close() should not throw IOException", e);
			}
		}
	}

	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

	public void setExceptionStackTrace(String exceptionStackTrace) {
		this.exceptionStackTrace = exceptionStackTrace;
	}

}
