package br.com.fiap.ibike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.fiap.ibike.model.Usuario;

public interface UserRepository extends JpaRepository <Usuario, String>, JpaSpecificationExecutor<Usuario>  {
    
}
