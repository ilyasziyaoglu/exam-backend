package exam.client.common.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
public abstract class AbstractResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	protected ZonedDateTime created_date;

	protected Long id;

}
