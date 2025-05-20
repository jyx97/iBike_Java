package br.com.fiap.ibike.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.ibike.model.Patio;
import br.com.fiap.ibike.model.dto.PatioResponse;
import br.com.fiap.ibike.components.StatusPatio;
import br.com.fiap.ibike.repository.PatioRepository;
import br.com.fiap.ibike.service.PatioService;
import br.com.fiap.ibike.specification.PatioSpecification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/patio")
public class PatioController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PatioRepository repository;

    @Autowired
    private PatioService patioService;

    @GetMapping
    public ResponseEntity<List<PatioResponse.PatioDTO>> listar() {
        return ResponseEntity.ok(patioService.listarPatios());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(responses = @ApiResponse(responseCode = "400", description = "Validação falhou"))
    @CacheEvict(value = "patios", allEntries = true)
    public ResponseEntity<Patio> create(@RequestBody @Valid Patio patio) {
        log.info("Cadastrando pátio " + patio.getNome());
        repository.save(patio);
        return ResponseEntity.status(HttpStatus.CREATED).body(patio);
    }

    @GetMapping("{id}")
    public Patio get(@PathVariable Long id) {
        log.info("Buscando Pátio " + id);
        return getPatio(id);
    }

    @GetMapping("/filtro")
    public List<Patio> filtrarPorStatus(@RequestParam(required = false) StatusPatio status) {
        return repository.findAll(PatioSpecification.hasStatus(status));
    }


    private Patio getPatio(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pátio não encontrado"));
    }
}
