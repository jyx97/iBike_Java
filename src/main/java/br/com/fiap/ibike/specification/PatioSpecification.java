package br.com.fiap.ibike.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.ibike.components.StatusPatio;
import br.com.fiap.ibike.model.Patio;

public class PatioSpecification {

    public static Specification<Patio> hasStatus(StatusPatio status) {
        return (root, query, builder) -> builder.equal(root.get("status"), status);
    }
}
