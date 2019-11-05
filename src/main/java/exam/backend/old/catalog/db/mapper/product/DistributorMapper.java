package exam.backend.old.catalog.db.mapper.product;

import exam.backend.old.catalog.db.entity.product.Distributor;
import exam.client.catalog.dto.request.product.DistributorRequest;
import exam.client.catalog.dto.response.product.DistributorResponse;
import exam.backend.common.db.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DistributorMapper extends BaseMapper<Distributor, DistributorRequest, DistributorResponse> {
}
