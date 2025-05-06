package br.com.fiap.ibike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.fiap.ibike.model.Bike;

public interface BikeRepository extends JpaRepository <Bike, String>, JpaSpecificationExecutor<Bike> {

}