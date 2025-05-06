package br.com.fiap.ibike.model;

import java.time.LocalDate;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Bike {
    @Id
    @NotBlank(message = "A placa é obrigatória")
    private String placa;

    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    @NotNull(message = "O status é obrigatório")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull(message = "A quilometragem atual é obrigatória")
    private Double kmAtual;

    @NotBlank(message = "A localização é obrigatória")
    private String localizacao;

    @NotNull(message = "A data do último check é obrigatória")
    private LocalDate dataUltimoCheck;


    public enum Status {
        DISPONIVEL,
        MANUTENCAO,
        INDISPONIVEL
    }

}
