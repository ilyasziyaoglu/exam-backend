package exam.client.exam_created_rel.request;

import exam.client.common.dto.request.AbstractRequest;
import exam.client.questions.request.QuestionsRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExamCreatedRequest extends AbstractRequest {

	private int questionOrder;

	private int point;

	private int optionCount;

	private QuestionsRequest question;
}
