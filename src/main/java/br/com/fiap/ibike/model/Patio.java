package br.com.fiap.ibike.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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

    @ManyToMany
    @JoinTable(
        name = "administrador_patio",
        joinColumns = @JoinColumn(name = "id_patio"),
        inverseJoinColumns = @JoinColumn(name = "cpf")
    )
    private List<Administrador> administradores = new ArrayList<>();
}
