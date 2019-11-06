package exam.backend.common.controller;

import exam.client.common.dto.request.AbstractRequest;
import exam.client.common.dto.response.AbstractResponse;
import exam.client.common.dto.response.JsonResponse;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.common.db.repository.BaseRepository;
import exam.backend.common.service.BaseEntityService;
import exam.backend.common.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public abstract class BaseEntityController<Request extends AbstractRequest, Response extends AbstractResponse, Entity extends AbstractEntity, Repository extends BaseRepository<Entity>, Service extends BaseEntityService<Entity, Repository>, Mapper extends BaseMapper<Entity, Request, Response>>
        extends AbstractBaseController<Request, Response, Entity, Repository, Service, Mapper> {

    @Autowired
    protected HttpServletRequest request;

    @GetMapping({"/{id}"})
    public JsonResponse<Response> get(@PathVariable("id") Long id) {
        JsonResponse<Response> jsonResponse = new JsonResponse<>();
        ServiceResult<Entity> serviceResult = getService().get(id);
        if (serviceResult.isSuccess()) {
            jsonResponse.setResult(getMapper().toResponse(serviceResult.getValue()));
        } else {
            jsonResponse.setStatus(serviceResult.getHttpStatus().value());
        }
        return jsonResponse;
    }



    @DeleteMapping({"/{id}"})
          public JsonResponse<Response> delete(@PathVariable("id") Long id) {
        JsonResponse<Response> jsonResponse = new JsonResponse<>();
        ServiceResult<Entity> serviceResult = getService().get(id);
        if (serviceResult.isSuccess()) {
            getService().delete(id);
            jsonResponse.setResult(getMapper().toResponse(serviceResult.getValue()));
        } else {
            jsonResponse.setStatus(serviceResult.getHttpStatus().value());
        }
        return jsonResponse;
    }


    @PutMapping
    public JsonResponse<Response> put( @RequestBody Request request) {

        JsonResponse<Response> jsonResponse = new JsonResponse<>();
        ServiceResult<Entity> entityServiceResult = getService().get(request.getId());
        if (entityServiceResult.getValue() == null) {
             jsonResponse.setStatus(entityServiceResult.getHttpStatus().value());
             return jsonResponse;
        }

        ServiceResult<Entity> serviceResult = getService().save(getMapper().toEntity(request));
        if (serviceResult.isSuccess()) {
            jsonResponse.setResult(getMapper().toResponse(serviceResult.getValue()));
        } else {
            jsonResponse.setStatus(serviceResult.getHttpStatus().value());
        }
        return jsonResponse;
    }

    @PostMapping
    public JsonResponse<Response> post(@RequestBody Request request) {
        JsonResponse<Response> jsonResponse = new JsonResponse<>();
        Entity entity = getMapper().toEntity(request);
        ServiceResult<Entity> serviceResult = getService().save(entity);
        if (serviceResult.isSuccess()) {
            jsonResponse.setResult(getMapper().toResponse(serviceResult.getValue()));
        } else {
            jsonResponse.setStatus(serviceResult.getHttpStatus().value());
        }

        return jsonResponse;
    }

    @GetMapping("/all")
    public JsonResponse<List<Response>> getAll() {
        JsonResponse<List<Response>> jsonResponse = new JsonResponse<>();
        ServiceResult<List<Entity>> serviceResult = getService().getAll();
        if (serviceResult.isSuccess()) {
            List<Response> responseList = new ArrayList<>();
            serviceResult.getValue().forEach(val -> responseList.add(getMapper().toResponse(val)));
            jsonResponse.setResult(responseList);
        } else {
            jsonResponse.setStatus(serviceResult.getHttpStatus().value());
        }
        return jsonResponse;
    }

}
