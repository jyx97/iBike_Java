package br.com.fiap.ibike.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.fiap.ibike.model.Administrador;

public interface AdministradorRepository  extends JpaRepository <Administrador, String>, JpaSpecificationExecutor<Administrador>{

    Optional<Administrador> findByEmail(String email);
    
}
