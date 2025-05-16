package br.com.fiap.ibike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.fiap.ibike.model.Patio;

public interface PatioRepository extends JpaRepository <Patio, Long>, JpaSpecificationExecutor<Patio> {

}