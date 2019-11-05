package exam.backend.pool.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.pool.db.entity.Pool;
import exam.backend.pool.db.mapper.PoolMapper;
import exam.backend.pool.db.repository.PoolRepository;
import exam.backend.pool.service.PoolService;
import exam.client.pool.request.PoolRequest;
import exam.client.pool.response.PoolResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/options")
public class PoolController extends BaseEntityController<PoolRequest, PoolResponse, Pool, PoolRepository, PoolService, PoolMapper> {

    @Resource
    private PoolService poolService;

    @Resource
    private PoolMapper poolMapper;

    @Override
    protected PoolService getService() {
        return poolService;
    }

    @Override
    protected PoolMapper getMapper() {
        return poolMapper;
    }
}
