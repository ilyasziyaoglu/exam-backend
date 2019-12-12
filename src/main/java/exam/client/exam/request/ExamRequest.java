package exam.client.exam.request;

import exam.client.common.dto.request.AbstractRequest;
import exam.client.exam_question_rel.request.ExamQuestionRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExamRequest extends AbstractRequest {

    private String name;

    private String description;

    private ZonedDateTime date;

    private int registeredCount;

    private int questionCount;

    private String type;

    private List<ExamQuestionRequest> examQuestions;

}
