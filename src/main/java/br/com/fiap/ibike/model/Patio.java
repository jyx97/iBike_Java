package br.com.fiap.ibike.model;

import java.util.List;

import br.com.fiap.ibike.components.StatusPatio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "patio")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @ToString.Exclude
    @OneToMany(mappedBy = "patio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Administrador> administradores;

}
