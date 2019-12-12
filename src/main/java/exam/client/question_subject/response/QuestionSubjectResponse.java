package exam.client.question_subject.response;

import exam.client.common.dto.response.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionSubjectResponse extends AbstractResponse {

    private String name;
}