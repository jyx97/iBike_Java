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

    public static Specification<Moto> patioEquals(String patio) {
        return (root, query, builder) -> {
            if (patio == null || patio.isBlank()) return null;
            return builder.equal(root.get("patio"), patio);
        };
    }

    public static Specification<Moto> patioDaUltimaMonitoracaoEquals(Long idPatio) {
        return (root, query, builder) -> {
            if (idPatio == null) return null;
            return builder.equal(root.join("ultimaMonitoracao").join("patio").get("id"), idPatio);
        };
    }
    
}
