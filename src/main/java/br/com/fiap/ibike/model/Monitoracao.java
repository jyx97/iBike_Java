package br.com.fiap.ibike.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Monitoracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O tipo de evento é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    private String descricao;

    @NotNull
    private LocalDateTime dataHora = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "placa_moto")
    private Moto moto;

    public enum TipoEvento {
        ENTRADA,
        SAIDA,
        ALERTA,
        CHECAGEM
    }
}
