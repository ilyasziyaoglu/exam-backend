package exam.backend.common.db.validation;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ValidateHolder<T> implements Serializable {

	private List<ValidateResult> errors = new ArrayList<>();

	private T object;

}
