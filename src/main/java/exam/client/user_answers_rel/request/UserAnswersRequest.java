package exam.client.user_answers_rel.request;

import exam.client.common.dto.request.AbstractRequest;
import exam.client.options.request.OptionsRequest;
import exam.client.questions.request.QuestionsRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserAnswersRequest extends AbstractRequest {

	private QuestionsRequest question;

	private OptionsRequest option;
}
