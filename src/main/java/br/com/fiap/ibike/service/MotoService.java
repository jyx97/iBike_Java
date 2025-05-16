package br.com.fiap.ibike.service;

import br.com.fiap.ibike.model.Moto;
import br.com.fiap.ibike.repository.MotoRepository;
import br.com.fiap.ibike.specification.MotoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MotoService {

    @Autowired
    private MotoRepository repository;

    public Page<Moto> buscarPorStatus(String status, Pageable pageable) {
        Specification<Moto> spec = MotoSpecification.statusEquals(status);
        return repository.findAll(spec, pageable);
    }

    public Page<Moto> buscarPorPatio(String patio, Pageable pageable) {
        Specification<Moto> spec = MotoSpecification.patioEquals(patio);
        return repository.findAll(spec, pageable);
    }

    public Page<Moto> buscarPorStatusEPatio(String status, String patio, Pageable pageable) {
        Specification<Moto> spec = Specification
            .where(MotoSpecification.statusEquals(status))
            .and(MotoSpecification.patioEquals(patio));
        return repository.findAll(spec, pageable);
    }
}
