package exam.client.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExamHeaderDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String traceId;

	private String channelId;

	private String userName;

	private String password;

	private String ldapCode;

	private String ip;

	private String port;

	// client session id
	private String sid;

}
