package exam.client.common.log;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstractEventModel implements Serializable {

    protected static final String LOG_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss,SSS";

    protected String serviceName;

    protected Date logTime = new Date();

    protected String logTimeStr;

    private long requestStartTime;

    private long requestEndTime;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public long getRequestStartTime() {
        return requestStartTime;
    }

    public void setRequestStartTime(long requestStartTime) {
        this.requestStartTime = requestStartTime;
    }

    public long getRequestEndTime() {
        return requestEndTime;
    }

    public void setRequestEndTime(long requestEndTime) {
        this.requestEndTime = requestEndTime;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogTimeStr() {
        return logTimeStr;
    }

    public void setLogTimeStr(String logTimeStr) {
        this.logTimeStr = logTimeStr;
    }
}

    