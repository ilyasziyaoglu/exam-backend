package exam.backend.common.db.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public abstract class AbstractValidator {

	@Resource
	private MessageSource messageSource;

	public String getMessage(String code, Object... args) {
		try {
			return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
		} catch (Exception e) {
			return code;
		}
	}

	public void addError(List<ValidateResult> errors, String field, String message) {
		errors.add(new ValidateResult(field, message));
	}

}
