package exam.backend.sinav.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.sinav.db.repository.SinavRepository;
import exam.backend.sinav.db.entity.Sinav;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SinavService extends BaseEntityService<Sinav, SinavRepository> {

    @Resource
    private SinavRepository sinavRepository;

    @Override
    public SinavRepository getRepository() {
        return sinavRepository;
    }

}
