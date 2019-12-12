package exam.client.common.dto.response;

import lombok.Data;

@Data
public class JsonResponse<T> {

	private int status = 200;

	private String message;

	private T result;

}
