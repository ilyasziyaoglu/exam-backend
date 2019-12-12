package exam.client.options.response;

import exam.client.common.dto.response.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OptionsResponse extends AbstractResponse {

    private String body;

    private boolean isTrue;

    private String imageUrl;

    private int order;
}