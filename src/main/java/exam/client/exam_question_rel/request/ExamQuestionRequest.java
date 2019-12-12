package exam.client.exam_question_rel.request;

import exam.client.common.dto.request.AbstractRequest;
import exam.client.questions.request.QuestionsRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExamQuestionRequest extends AbstractRequest {

	private int questionOrder;

	private int point;

	private int optionCount;

	private QuestionsRequest question;
}
