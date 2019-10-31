package exam.backend.sinav.controller;
import exam.backend.common.controller.BaseEntityController;
import exam.backend.sinav.db.entity.Sinav;
import exam.backend.sinav.db.mapper.SinavMapper;
import exam.backend.sinav.db.repository.SinavRepository;
import exam.backend.sinav.service.SinavService;
import exam.client.offer.dto.request.OfferRequest;
import exam.client.offer.dto.response.OfferResponse;
import exam.client.sinav.dto.request.SinavRequest;
import exam.client.sinav.dto.response.SinavResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/sinav")
public class SinavController extends BaseEntityController<SinavRequest, SinavResponse, Sinav, SinavRepository, SinavService, SinavMapper> {

	@Resource
	private SinavService sinavService;

	@Resource
	private SinavMapper sinavMapper;

	@Override
	protected SinavService getService() {
		return sinavService;
	}

	@Override
	protected SinavMapper getMapper() {
		return sinavMapper;
	}
}
