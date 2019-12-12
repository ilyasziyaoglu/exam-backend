package exam.client.questions.response;

import exam.client.common.dto.response.AbstractResponse;
import exam.client.options.response.OptionsResponse;
import exam.client.question_subject.response.QuestionSubjectResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionsResponse extends AbstractResponse {

    private String body;

    private String imageUrl;

    private QuestionSubjectResponse subject;

    private List<OptionsResponse> options;
}