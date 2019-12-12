package exam.client.pool.response;

import exam.client.common.dto.response.AbstractResponse;
import exam.client.questions.response.QuestionsResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PoolResponse extends AbstractResponse {

    private String name;

    private List<QuestionsResponse> questions;
}