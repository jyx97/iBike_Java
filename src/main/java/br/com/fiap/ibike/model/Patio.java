package br.com.fiap.ibike.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Patio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    private int capacidade;

    @ManyToOne
    @JoinColumn(name = "cpf")
    private Admin admin;

    @OneToMany(mappedBy = "patio")
    private List<Moto> motos;
}

