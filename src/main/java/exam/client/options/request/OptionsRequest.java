package exam.client.options.request;

import exam.client.common.dto.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OptionsRequest extends AbstractRequest {

	private String body;

	private boolean isTrue;

	private String imageUrl;

	private int order;
}
