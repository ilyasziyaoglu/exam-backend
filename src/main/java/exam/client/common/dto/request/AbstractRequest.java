package exam.client.common.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class AbstractRequest implements Serializable {

	protected Long id;

}
