//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package exam.backend.common.db.specification;

import com.google.common.base.Predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.List;

public interface Specification<AbstractEntity> {
    Predicate toPredicate(Root<AbstractEntity> var1, CriteriaBuilder var2);

    Class<AbstractEntity> getType();

    org.springframework.data.jpa.domain.Specification<AbstractEntity> idEqual(Long var1);

    org.springframework.data.jpa.domain.Specification<AbstractEntity> idsEqual(List<Long> var1);
}
