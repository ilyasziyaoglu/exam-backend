package exam.client.exam_created_rel.response;

import exam.client.common.dto.response.AbstractResponse;
import exam.client.questions.response.QuestionsResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExamCreatedResponse extends AbstractResponse {

	private int questionOrder;

	private int point;

	private int optionCount;

	private QuestionsResponse question;
}