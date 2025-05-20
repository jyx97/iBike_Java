package br.com.fiap.ibike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ibike.model.dto.AdministradorResponse;
import br.com.fiap.ibike.model.dto.PatioResponse;
import br.com.fiap.ibike.repository.PatioRepository;

@Service
public class PatioService {
    @Autowired
    private PatioRepository patioRepository;

    public List<PatioResponse.PatioDTO> listarPatios() {
    return patioRepository.findAll().stream().map(patio -> 
        new PatioResponse.PatioDTO(
            patio.getId(),
            patio.getNome(),
            patio.getCapacidade(),
            patio.getStatus(),
            patio.getAdministradores().stream().map(admin ->
                new AdministradorResponse.UserResponse(
                    admin.getCpf(),
                    admin.getEmail(),
                    admin.getStatus()
                )
            ).toList() 
        )
    ).toList(); 
}

}
