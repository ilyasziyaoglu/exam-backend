package exam.client.questions.request;

import exam.client.common.dto.request.AbstractRequest;
import exam.client.options.request.OptionsRequest;
import exam.client.question_subject.request.QuestionSubjectRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionsRequest extends AbstractRequest {

	private String body;

	private String imageUrl;

	private QuestionSubjectRequest subject;

	private List<OptionsRequest> options;
}
