package br.com.fiap.ibike.specification;

import br.com.fiap.ibike.model.Moto;
import org.springframework.data.jpa.domain.Specification;

public class MotoSpecification {

    public static Specification<Moto> statusEquals(String status) {
        return (root, query, builder) -> {
            if (status == null || status.isBlank()) return null;
            return builder.equal(root.get("status"), status);
        };
    }
}
