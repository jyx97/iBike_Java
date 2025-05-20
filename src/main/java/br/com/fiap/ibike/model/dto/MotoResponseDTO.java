package br.com.fiap.ibike.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MotoResponseDTO {

    private String placa;
    private String modelo;
    private String status;
    private double kmAtual;
    private String localizacao;
    private LocalDate dataUltimoCheck;

    private Long idUltimaMonitoracao;
    private String nomePatio;
}
