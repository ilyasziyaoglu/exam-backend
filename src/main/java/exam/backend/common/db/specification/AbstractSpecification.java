//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package exam.backend.common.db.specification;

import com.google.common.base.Predicate;
import org.apache.commons.lang.NotImplementedException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractSpecification<AbstractEntity, FilterDto> implements Specification<AbstractEntity> {
    public AbstractSpecification() {
    }

    public org.springframework.data.jpa.domain.Specification<AbstractEntity> filter(FilterDto dto) {
        return null;
    }

    public Class<AbstractEntity> getType() {
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        return (Class)type.getActualTypeArguments()[0];
    }

    public Predicate toPredicate(Root<AbstractEntity> root, CriteriaBuilder cb) {
        throw new NotImplementedException();
    }

    public org.springframework.data.jpa.domain.Specification<AbstractEntity> idEqual(Long id) {
        return (root, criteria, cb) -> {
            return cb.equal(root.get("identifier"), id);
        };
    }

    public org.springframework.data.jpa.domain.Specification<AbstractEntity> idsEqual(List<Long> ids) {
        return (root, criteria, cb) -> {
            return root.get("identifier").in(ids);
        };
    }
}
