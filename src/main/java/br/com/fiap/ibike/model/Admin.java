package br.com.fiap.ibike.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Admin {
    @Id
    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 dígitos")
    private String cpf;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 5, message = "A senha deve ter pelo menos 5 caracteres")
    private String senha;

    @NotNull(message = "Status é obrigatório")
    @Enumerated(EnumType.STRING)
    private StatusAdmin status;

    public enum StatusAdmin {
        ATIVO,
        INATIVO,
        BLOQUEADO
    }
    
}
