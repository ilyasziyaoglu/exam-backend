package exam.backend.catalog.db.mapper.company;

import exam.backend.catalog.db.entity.company.Company;
import exam.client.catalog.dto.request.company.CompanyRequest;
import exam.client.catalog.dto.response.company.CompanyResponse;
import exam.backend.common.db.mapper.BaseMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CompanyMapper extends BaseMapper<Company, CompanyRequest, CompanyResponse> {


}