package br.com.fiap.ibike.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "administrador")
@Data
public class Administrador {

    @Id
    @Column(length = 11)
    private String cpf;

    @Column(name = "nm_adm", nullable = false)
    private String nome;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 5)
    @Column(nullable = false, length = 10)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAdministrador status;

    public enum StatusAdministrador {
        ATIVO, INATIVO, BLOQUEADO
    }
}
