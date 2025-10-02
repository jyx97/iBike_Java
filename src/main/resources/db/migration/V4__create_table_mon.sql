
-- Tabela de Monitoramento
CREATE TABLE monitoracao (
 id_monitoracao SERIAL PRIMARY KEY,
 tipo_evento VARCHAR(20) NOT NULL,
 data_hora TIMESTAMP NOT NULL,
 placa_moto VARCHAR(10) NOT NULL REFERENCES moto(placa));