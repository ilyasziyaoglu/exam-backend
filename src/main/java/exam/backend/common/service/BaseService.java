package exam.backend.common.service;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public abstract class BaseService {

	@Resource
	protected HttpServletRequest request;

	@Resource
	protected HttpServletResponse response;

	@Resource
	private MessageSource messageSource;

	public String getMessage(String code) {
		try {
			return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
		} catch (NoSuchMessageException e) {
			return code;
		}
	}

}
