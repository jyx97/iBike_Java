package br.com.fiap.ibike.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.ibike.model.Monitoracao;
import br.com.fiap.ibike.model.Moto;
import br.com.fiap.ibike.model.Patio;
import br.com.fiap.ibike.repository.MonitoracaoRepository;
import br.com.fiap.ibike.repository.MotoRepository;
import br.com.fiap.ibike.repository.PatioRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataSeeder {

    private final RestTemplate restTemplate;
    private final MotoRepository motoRepository;
    private final PatioRepository patioRepository;
    private final MonitoracaoRepository monitoracaoRepository;

    @Value("${mockapi.url1}")
    private String mock1;

    @Value("${mockapi.url2}")
    private String mock2;

    @Value("${mockapi.url3}")
    private String mock3;

    @Autowired
    public DataSeeder(RestTemplate restTemplate, MotoRepository motoRepository, PatioRepository patioRepository, MonitoracaoRepository monitoracaoRepository) {
        this.restTemplate = restTemplate;
        this.motoRepository = motoRepository;
        this.patioRepository = patioRepository;
        this.monitoracaoRepository = monitoracaoRepository;
    }

    public void seed() {
        // URLs para as chamadas API
        String[] urls = { mock1, mock2, mock3 };

        for (String url : urls) {
            Object[] dados = restTemplate.getForObject(url, Object[].class);
            if (dados != null) {

                for (Object dado : dados) {
                    if (dado instanceof Moto) {
                        Moto moto = (Moto) dado;
                        motoRepository.save(moto);
                        System.out.println("Moto salva: " + moto);
                    } else if (dado instanceof Patio) {
                        Patio patio = (Patio) dado;
                        patioRepository.save(patio);
                        System.out.println("Patio salvo: " + patio);
                    } else if (dado instanceof Monitoracao) {
                        Monitoracao monitoracao = (Monitoracao) dado;
                        monitoracaoRepository.save(monitoracao);
                        System.out.println("Monitoração salva: " + monitoracao);
                    }
                }
            }
        }
    }
}
