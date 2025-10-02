
-- Tabela de Motos
CREATE TABLE moto (
 placa VARCHAR(10) PRIMARY KEY,
 modelo VARCHAR(255) NOT NULL,
 status VARCHAR(20) NOT NULL CHECK (status IN ('NO_PATIO', 'EM_USO', 'FURTADA', 'SUSPEITA')),
 km_atual INTEGER,
 localizacao VARCHAR(255),
 data_ultimo_check DATE
);
