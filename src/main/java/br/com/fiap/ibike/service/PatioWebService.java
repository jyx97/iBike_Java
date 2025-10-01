package br.com.fiap.ibike.service;

import br.com.fiap.ibike.model.Patio;
import br.com.fiap.ibike.repository.PatioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatioWebService {

    private final PatioRepository repository;

    public PatioWebService(PatioRepository repository) {
        this.repository = repository;
    }

    public List<Patio> listarTodos() {
        return repository.findAll();
    }

    public Patio buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pátio não encontrado"));
    }

    public Patio salvar(Patio patio) {
        return repository.save(patio);
    }

    public Patio atualizar(Long id, Patio patioAtualizado) {
        Patio existente = buscarPorId(id);
        existente.setNome(patioAtualizado.getNome());
        existente.setCapacidade(patioAtualizado.getCapacidade());
        existente.setStatus(patioAtualizado.getStatus());
        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
