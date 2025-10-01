package br.com.fiap.ibike.service;

import br.com.fiap.ibike.model.Administrador;
import br.com.fiap.ibike.repository.AdministradorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    private final AdministradorRepository repository;
    private final PasswordEncoder encoder;

    public AdministradorService(AdministradorRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public List<Administrador> listarTodos() {
        return repository.findAll();
    }

    public Administrador buscarPorCpf(String cpf) {
        return repository.findById(cpf).orElseThrow(() -> new RuntimeException("Administrador não encontrado"));
    }

    public Administrador salvar(Administrador admin) {
        admin.setPassword(encoder.encode(admin.getPassword()));
        return repository.save(admin);
    }

    public Administrador atualizar(String cpf, Administrador adminAtualizado) {
        Administrador existente = buscarPorCpf(cpf);
        existente.setNome(adminAtualizado.getNome());
        existente.setStatus(adminAtualizado.getStatus());
        if (adminAtualizado.getPassword() != null && !adminAtualizado.getPassword().isBlank()) {
            existente.setPassword(encoder.encode(adminAtualizado.getPassword()));
        }
        return repository.save(existente);
    }

    public void excluir(String cpf) {
        repository.deleteById(cpf);
    }
}
