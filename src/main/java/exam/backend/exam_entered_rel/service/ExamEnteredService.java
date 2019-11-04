package exam.backend.exam_entered_rel.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.exam_entered_rel.db.entity.ExamEntered;
import exam.backend.exam_entered_rel.db.repository.ExamEnteredRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExamEnteredService extends BaseEntityService<ExamEntered, ExamEnteredRepository> {

    @Resource
    private ExamEnteredRepository examEnteredRepository;

    @Override
    public ExamEnteredRepository getRepository() {
        return examEnteredRepository;
    }

}
