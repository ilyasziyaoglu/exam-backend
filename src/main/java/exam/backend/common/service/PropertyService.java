package exam.backend.common.service;

import exam.backend.common.db.entity.property.Property;
import exam.backend.common.db.repository.BaseRepository;
import exam.backend.common.db.repository.property.PropertyRepository;
import exam.backend.common.util.PropertyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Service
public class PropertyService extends BaseEntityService<Property, BaseRepository<Property>> {

	@Resource
	private PropertyRepository propertyRepository;

	@Override
	public BaseRepository<Property> getRepository() {
		return propertyRepository;
	}

	@PostConstruct
	public void refreshProperties() {
		PropertyUtil.clearProperties();
		List<Property> properties = propertyRepository.findAll();
		System.out.println(">>>>>>> properties.size = " + properties.size());
		properties.forEach(property -> PropertyUtil.addProperty(property.getKey(), property.getValue()));
	}

	public void addPropertyUtil(String key, String val) {
		if (StringUtils.isNotEmpty(key)) {
			PropertyUtil.addProperty(key, val);
		}
	}

	public void deletePropertyUtil(String key) {
		if (StringUtils.isNotEmpty(key)) {
			PropertyUtil.deleteProperty(key);
		}
	}

	public void updateProperties(String key, String val) {
		if (StringUtils.isNotEmpty(key)) {
			PropertyUtil.updateProperty(key, val);
		}
	}

}
