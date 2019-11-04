package exam.backend.exam_created_rel.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.exam_created_rel.db.entity.ExamCreated;
import exam.backend.exam_created_rel.db.repository.ExamCreatedRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExamCreatedService extends BaseEntityService<ExamCreated, ExamCreatedRepository> {

    @Resource
    private ExamCreatedRepository examCreatedRepository;

    @Override
    public ExamCreatedRepository getRepository() {
        return examCreatedRepository;
    }

}
