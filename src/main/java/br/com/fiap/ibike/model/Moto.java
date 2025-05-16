package br.com.fiap.ibike.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    @Column(name = "data_ultimo_check", nullable = false)
    private LocalDate dataUltimoCheck;

   @JoinColumn(name = "id_monitoracao")
   @OneToOne
    private Monitoracao ultimaMonitoracao;
    
    @ManyToOne
    @JoinColumn(name = "id_patio")
    private Patio patio; // Novo relacionamento com o Pátio


    public enum Status {
        NO_PATIO, EM_USO, MANUTENÇÃO, PENDENTE, FURTADA
    }
}

