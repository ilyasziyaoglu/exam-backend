package exam.backend.exam_entered_rel.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.exam_entered_rel.db.entity.ExamEntered;
import exam.backend.exam_entered_rel.db.mapper.ExamEnteredMapper;
import exam.backend.exam_entered_rel.db.repository.ExamEnteredRepository;
import exam.backend.exam_entered_rel.service.ExamEnteredService;
import exam.client.exam_entered_rel.request.ExamEnteredRequest;
import exam.client.exam_entered_rel.response.ExamEnteredResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/exam-entered")
public class ExamEnteredController extends BaseEntityController<ExamEnteredRequest, ExamEnteredResponse, ExamEntered, ExamEnteredRepository, ExamEnteredService, ExamEnteredMapper> {

    @Resource
    private ExamEnteredService examEnteredService;

    @Resource
    private ExamEnteredMapper examEnteredMapper;

    @Override
    protected ExamEnteredService getService() {
        return examEnteredService;
    }

    @Override
    protected ExamEnteredMapper getMapper() {
        return examEnteredMapper;
    }
}
