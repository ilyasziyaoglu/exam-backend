package exam.backend.exam_created_rel.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.exam_created_rel.db.entity.ExamCreated;
import exam.backend.exam_created_rel.db.mapper.ExamCreatedMapper;
import exam.backend.exam_created_rel.db.repository.ExamCreatedRepository;
import exam.backend.exam_created_rel.service.ExamCreatedService;
import exam.client.exam_created_rel.request.ExamCreatedRequest;
import exam.client.exam_created_rel.response.ExamCreatedResponse;
import exam.client.exam_entered_rel.request.ExamEnteredRequest;
import exam.client.exam_entered_rel.response.ExamEnteredResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/exam-created")
public class ExamCreatedController extends BaseEntityController<ExamCreatedRequest, ExamCreatedResponse, ExamCreated, ExamCreatedRepository, ExamCreatedService, ExamCreatedMapper> {

    @Resource
    private ExamCreatedService examCreatedService;

    @Resource
    private ExamCreatedMapper examCreatedMapper;

    @Override
    protected ExamCreatedService getService() {
        return examCreatedService;
    }

    @Override
    protected ExamCreatedMapper getMapper() {
        return examCreatedMapper;
    }
}
