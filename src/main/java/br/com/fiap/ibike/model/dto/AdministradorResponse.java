package br.com.fiap.ibike.model.dto;

import br.com.fiap.ibike.components.StatusAdministrador;

public class AdministradorResponse {
    public record UserResponse(String cpf,String email,StatusAdministrador status) {}
}
