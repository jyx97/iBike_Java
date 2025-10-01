package br.com.fiap.ibike.service;

import br.com.fiap.ibike.model.Moto;
import br.com.fiap.ibike.repository.MotoRepository;
import br.com.fiap.ibike.specification.MotoSpecification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class MotoService {

    @Autowired
    private MotoRepository repository;

    public Page<Moto> buscarPorStatus(String status, Pageable pageable) {
        Specification<Moto> spec = MotoSpecification.statusEquals(status);
        return repository.findAll(spec, pageable);
    }
    public MotoService(MotoRepository repository) {
        this.repository = repository;
    }

    public List<Moto> listarTodas() {
        return repository.findAll();
    }

    public Moto buscarPorPlaca(String placa) {
        return repository.findById(placa)
                .orElseThrow(() -> new IllegalArgumentException("Moto não encontrada: " + placa));
    }

    @Transactional
    public Moto salvar(Moto moto) {
        // validações básicas
        if (moto.getPlaca() == null || moto.getPlaca().isBlank()) {
            throw new IllegalArgumentException("Placa obrigatória");
        }
        return repository.save(moto);
    }

    @Transactional
    public Moto atualizar(String placa, Moto motoAtualizada) {
        Moto moto = buscarPorPlaca(placa);
        moto.setModelo(motoAtualizada.getModelo());
        moto.setKmAtual(motoAtualizada.getKmAtual());
        moto.setStatus(motoAtualizada.getStatus());
        moto.setDataUltimoCheck(motoAtualizada.getDataUltimoCheck());
        moto.setPatio(motoAtualizada.getPatio());
        return repository.save(moto);
    }

    @Transactional
    public void excluir(String placa) {
        repository.deleteById(placa);
    }
}
