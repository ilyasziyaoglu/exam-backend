package exam.client.question_subject.request;

import exam.client.common.dto.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionSubjectRequest extends AbstractRequest {

	private String name;
}
