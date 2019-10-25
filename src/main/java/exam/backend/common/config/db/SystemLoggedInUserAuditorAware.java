package exam.backend.common.config.db;//package exam.backend.inventory.common.config.db;
//
//import TokenUtils;
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class SystemLoggedInUserAuditorAware implements AuditorAware<String> {
//
//	@Resource
//	private HttpServletRequest request;
//
//	@Override
//	public Optional<String> getCurrentAuditor() {
//		return Optional.of(TokenUtils.getValueFromToken(TokenUtils.USERNAME, request));
//	}
//}
