package exam.backend.common.db.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ValidateResult implements Serializable {

	private String field;

	private String message;

}
