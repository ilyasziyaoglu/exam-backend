package exam.backend.common.config;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SystemEnvironment {

	@Autowired
	private Environment environment;

	public String getActiveProfile() {
		if (ArrayUtils.isNotEmpty(environment.getActiveProfiles())) {
			return environment.getActiveProfiles()[0];
		}
		return "prod";
	}

	public String getENV() {
		return getActiveProfile();
	}

	public boolean isLOCAL() {
		return "DEV".equalsIgnoreCase(getActiveProfile());
	}

	public boolean isSTB() {
		return "STB".equalsIgnoreCase(getActiveProfile());
	}

	public boolean isPRP() {
		return "PRP".equalsIgnoreCase(getActiveProfile());
	}

	public boolean isPROD() {
		return "PROD".equalsIgnoreCase(getActiveProfile());
	}

	public boolean isGP() {
		return "GP".equalsIgnoreCase(getActiveProfile());
	}

	public boolean isDevOrStb() {
		if (isLOCAL() || isSTB()) {
			return true;
		}
		return false;
	}

	// local, stb, prp
	public boolean isDevelopmentMode() {
		if (isDevOrStb() || isPRP()) {
			return true;
		}
		return false;
	}

}
