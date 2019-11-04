package exam.backend.created_exam_rel.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.created_exam_rel.db.entity.UserExam;
import exam.backend.created_exam_rel.db.repository.UserExamRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserExamService extends BaseEntityService<UserExam, UserExamRepository> {

    @Resource
    private UserExamRepository userExamRepository;

    @Override
    public UserExamRepository getRepository() {
        return userExamRepository;
    }

}
