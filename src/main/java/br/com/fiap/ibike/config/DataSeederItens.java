package br.com.fiap.ibike.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.ibike.repository.MotoRepository;
import jakarta.annotation.PostConstruct;



@Component
public class DataSeederItens {

    @Autowired
    private MotoRepository repository;

    @PostConstruct
    public void init(){
        var moto=List.of(
            Personagem.builder().name("Guerreiro Valente").typeClass(ClassEnum.GUERREIRO).level(50).coins(1000).build(), 
            Personagem.builder().name("Mago Ancião").typeClass(ClassEnum.MAGO).level(40).coins(500).build(), 
            Personagem.builder().name("Arqueiro Sombrio").typeClass(ClassEnum.ARQUEIRO).level(60).coins(1200).build()
        );

         MotoRepository.saveAll(moto);


    }

}