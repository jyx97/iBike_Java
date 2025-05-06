package br.com.fiap.ibike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.fiap.ibike.model.Admin;

public interface AdminRepository  extends JpaRepository <Admin, String>, JpaSpecificationExecutor<Admin>{
    
}
