package exam.backend.pool.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.pool.db.entity.Pool;
import exam.backend.pool.db.repository.PoolRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PoolService extends BaseEntityService<Pool, PoolRepository> {

    @Resource
    private PoolRepository poolRepository;

    @Override
    public PoolRepository getRepository() {
        return poolRepository;
    }

}
