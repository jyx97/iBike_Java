package br.com.fiap.ibike.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "moto")
@Data
public class Moto {

    @Id
    @Column(length = 10)
    private String placa;

    @Column(nullable = false)
    private String modelo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "km_atual", nullable = false)
    private double kmAtual;

    @Column(nullable = false)
    private String localizacao;

    @Column(name = "data_ultimo_check", nullable = false)
    private LocalDate dataUltimoCheck;

    @OneToMany(mappedBy = "moto", cascade = CascadeType.ALL)
    private List<Monitoracao> monitoracoes;

    public enum Status {
        NO_PATIO, EM_USO, SUSPEITA, FURTADA
    }
}

