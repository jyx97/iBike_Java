package br.com.fiap.ibike.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "patio")
@Data
public class Patio {

    @Id
    @Column(name = "id_patio")
    private Long id;

    @Column(name = "nm_patio", nullable = false)
    private String nome;

    @Column(nullable = false)
    private int capacidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPatio status;

    @ManyToMany
    @JoinTable(
        name = "administrador_patio",
        joinColumns = @JoinColumn(name = "id_patio"),
        inverseJoinColumns = @JoinColumn(name = "cpf")
    )
    private List<Administrador> administradores = new ArrayList<>();

    public enum StatusPatio {
    DISPONIVEL,   // Espaço disponível
    CHEIO,        // Capacidade total atingida
    SOBRECARGA    // Acima da capacidade
}
}
