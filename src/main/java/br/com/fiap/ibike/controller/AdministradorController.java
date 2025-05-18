package br.com.fiap.ibike.controller;

import br.com.fiap.ibike.model.Administrador;
import br.com.fiap.ibike.repository.AdministradorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdministradorRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Criar usuário (cadastro)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador create(@RequestBody @Valid Administrador administrador) {
        log.info("Cadastrando administrador: " + administrador.getEmail());
        administrador.setSenha(passwordEncoder.encode(administrador.getSenha()));
        return repository.save(administrador);
    }

    // Buscar os dados do próprio administrador autenticado
    @GetMapping("/me")
    public Administrador getMe() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador não encontrado"));
    }

    // Atualizar dados do próprio administrador
    @PutMapping("/alteracao")
    public Administrador updateMe(@RequestBody @Valid Administrador administradorAtualizado) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Administrador administrador = repository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador não encontrado"));

        // Atualize os campos permitidos
        administrador.setNome(administradorAtualizado.getNome());

        // Se quiser atualizar a senha, encode antes
        if (administradorAtualizado.getSenha() != null && !administradorAtualizado.getSenha().isBlank()) {
            administrador.setSenha(passwordEncoder.encode(administradorAtualizado.getSenha()));
        }

        return repository.save(administrador);
    }

    // Deletar própria conta
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMe() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Administrador administrador = repository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador não encontrado"));

        repository.delete(administrador);
        log.info("Administrador deletado: " + email);
    }

}
