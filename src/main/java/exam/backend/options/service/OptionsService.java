package exam.backend.options.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.options.db.entity.Options;
import exam.backend.options.db.repository.OptionsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OptionsService extends BaseEntityService<Options, OptionsRepository> {

    @Resource
    private OptionsRepository optionsRepository;

    @Override
    public OptionsRepository getRepository() {
        return optionsRepository;
    }

}
