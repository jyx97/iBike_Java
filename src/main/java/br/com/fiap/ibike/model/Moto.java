package br.com.fiap.ibike.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import br.com.fiap.ibike.View;
import br.com.fiap.ibike.components.StatusMoto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "moto")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Moto {

    @Id
    @Column(length = 10)
    @JsonView(View.Public.class)
    private String placa;

    @Column(nullable = false)
    @JsonView(View.Public.class)
    private String modelo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @JsonView(View.Public.class)
    private StatusMoto status;

    @Column(name = "km_atual", nullable = false)
    @JsonView(View.Public.class)
    private double kmAtual;

    @Column(name = "data_ultimo_check", nullable = false)
    @JsonView(View.Public.class)
    private LocalDate dataUltimoCheck;

    @ManyToOne
    @JsonView(View.Public.class)
    private Patio patio;

}

