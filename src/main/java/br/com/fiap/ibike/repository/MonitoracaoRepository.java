package br.com.fiap.ibike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.fiap.ibike.model.Monitoracao;

public interface MonitoracaoRepository extends JpaRepository <Monitoracao, Long>, JpaSpecificationExecutor<Monitoracao> {

}