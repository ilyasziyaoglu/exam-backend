package exam.client.exam.response;

import exam.client.common.dto.response.AbstractResponse;
import exam.client.exam_question_rel.response.ExamQuestionResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExamResponse extends AbstractResponse {

    private String name;

    private String description;

    private ZonedDateTime date;

    private int registeredCount;

    private int questionCount;

    private String type;

    private List<ExamQuestionResponse> examQuestions;

}