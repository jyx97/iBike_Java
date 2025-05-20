package br.com.fiap.ibike.model.dto;

import java.util.List;

import br.com.fiap.ibike.components.StatusPatio;

public class PatioResponse {
    public record PatioDTO(
        Long id,
        String nome,
        int capacidade,
        StatusPatio status,
        List<AdministradorResponse.UserResponse> administradores
    ) {}
}
