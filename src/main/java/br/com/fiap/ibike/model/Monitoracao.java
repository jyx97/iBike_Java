package br.com.fiap.ibike.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "monitoracao")
@Data
public class Monitoracao {

    @Id
    @Column(name = "id_monitoracao")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento", nullable = false)
    private TipoEvento tipoEvento;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    public enum TipoEvento {
        ENTRADA, SAIDA, ALERTA, TRIAGEM
    }
}
