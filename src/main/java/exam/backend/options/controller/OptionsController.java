package exam.backend.options.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.options.db.entity.Options;
import exam.backend.options.db.mapper.OptionsMapper;
import exam.backend.options.db.repository.OptionsRepository;
import exam.backend.options.service.OptionsService;
import exam.client.options.request.OptionsRequest;
import exam.client.options.response.OptionsResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/options")
public class OptionsController extends BaseEntityController<OptionsRequest, OptionsResponse, Options, OptionsRepository, OptionsService, OptionsMapper> {

    @Resource
    private OptionsService optionsService;

    @Resource
    private OptionsMapper optionsMapper;

    @Override
    protected OptionsService getService() {
        return optionsService;
    }

    @Override
    protected OptionsMapper getMapper() {
        return optionsMapper;
    }
}
