package exam.client.user_answers_rel.response;

import exam.client.common.dto.response.AbstractResponse;
import exam.client.options.response.OptionsResponse;
import exam.client.questions.response.QuestionsResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UsersAnswersResponse extends AbstractResponse {

	private QuestionsResponse question;

	private OptionsResponse option;
}