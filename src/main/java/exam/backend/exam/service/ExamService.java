package exam.backend.exam.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.exam.db.entity.Exam;
import exam.backend.exam.db.repository.ExamRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExamService extends BaseEntityService<Exam, ExamRepository> {

    @Resource
    private ExamRepository examRepository;

    @Override
    public ExamRepository getRepository() {
        return examRepository;
    }

}
