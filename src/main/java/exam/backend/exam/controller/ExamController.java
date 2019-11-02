package exam.backend.exam.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.exam.db.entity.Exam;
import exam.backend.exam.db.mapper.ExamMapper;
import exam.backend.exam.db.repository.ExamRepository;
import exam.backend.exam.service.ExamService;
import exam.client.exam.dto.request.ExamRequest;
import exam.client.exam.dto.response.ExamResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/exam")
public class ExamController extends BaseEntityController<ExamRequest, ExamResponse, Exam, ExamRepository, ExamService, ExamMapper> {

    @Resource
    private ExamService examService;

    @Resource
    private ExamMapper examMapper;

    @Override
    protected ExamService getService() {
        return examService;
    }

    @Override
    protected ExamMapper getMapper() {
        return examMapper;
    }
}
