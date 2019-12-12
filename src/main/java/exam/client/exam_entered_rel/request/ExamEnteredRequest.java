package exam.client.exam_entered_rel.request;

import exam.client.common.dto.request.AbstractRequest;
import exam.client.exam.request.ExamRequest;
import exam.client.user_answers_rel.request.UserAnswersRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExamEnteredRequest extends AbstractRequest {

	private float examScore;

	private boolean isEntered;

	private int examDuration;

	private ExamRequest exam;

	private List<UserAnswersRequest> userAnswers;
}
