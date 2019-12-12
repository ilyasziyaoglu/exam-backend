package exam.client.common.log;

import exam.client.common.log.enums.LogEventType;

public abstract class BaseLogModel extends AbstractEventModel {

	protected LogEventType logEventType;

	protected String msisdn;

	protected String traceId;

	protected String methodName;

	protected String clazzName;

	protected String reqUri;

	protected String ip;

	protected String port;

	protected String sid;

	protected String logMessage;

	public LogEventType getLogEventType() {
		return logEventType;
	}

	public void setLogEventType(LogEventType logEventType) {
		this.logEventType = logEventType;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public String getReqUri() {
		return reqUri;
	}

	public void setReqUri(String reqUri) {
		this.reqUri = reqUri;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

}
