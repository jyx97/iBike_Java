
package br.com.fiap.ibike.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.fiap.ibike.model.Moto;
import br.com.fiap.ibike.model.Moto.Status;
import br.com.fiap.ibike.model.Patio;
import br.com.fiap.ibike.repository.MotoRepository;
import br.com.fiap.ibike.repository.PatioRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DataSeeder {

    @Autowired
    private MotoRepository repository;

    @Autowired
    private PatioRepository patioRepository;

    @PostConstruct
    public void init() {
        var moto = List.of( 
                Moto.builder().placa("ABC-1234").modelo("Mottu Sport").status(Status.NO_PATIO).kmAtual(1230.5).dataUltimoCheck(LocalDate.parse("2025-04-21")).build(),
                
                Moto.builder().placa("DEF-5678").modelo("Mottu E").status(Status.EM_USO).kmAtual(5400).dataUltimoCheck(LocalDate.parse("2025-04-20")).build(),
                
                Moto.builder().placa("GHI-9012").modelo("Mottu Pop").status(Status.MANUTENÇÃO).kmAtual(870.3).dataUltimoCheck(LocalDate.parse("2025-04-22")).build(),
                
                Moto.builder().placa("JKL-3456").modelo("Mottu Sport").status(Status.NO_PATIO).kmAtual(2345.1).dataUltimoCheck(LocalDate.parse("2025-04-18")).build(),

                Moto.builder().placa("MNO-7890").modelo("Mottu E").status(Status.PENDENTE).kmAtual(4500).dataUltimoCheck(LocalDate.parse("2025-04-19")).build()
        );

        
        repository.saveAll(moto);
    
        var patios = List.of(
        new Patio() {{
            setId(1L);
            setNome("Pinheiros");
            setCapacidade(100);
            setStatus(StatusPatio.DISPONIVEL);
        }},
        new Patio() {{
            setId(2L);
            setNome("Moema");
            setCapacidade(50);
            setStatus(StatusPatio.DISPONIVEL);
        }},
        new Patio() {{
            setId(3L);
            setNome("Vila Madalena");
            setCapacidade(70);
            setStatus(StatusPatio.SOBRECARGA);
        }},
        new Patio() {{
            setId(4L);
            setNome("Jardins");
            setCapacidade(40);
            setStatus(StatusPatio.CHEIO);
        }},
        new Patio() {{
            setId(5L);
            setNome("Itaim Bibi");
            setCapacidade(30);
            setStatus(StatusPatio.DISPONIVEL);
        }}
    );

    patioRepository.saveAll(patios);

}

}
