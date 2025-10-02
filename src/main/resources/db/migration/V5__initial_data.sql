INSERT INTO administrador (cpf, nm_adm, email, senha, status) VALUES
('12345678900', 'Carlos Silva', 'carlos@admin.com', 'senha123', 'ATIVO'),
('22345678900', 'Ana Lima', 'ana@admin.com', 'senha456', 'INATIVO'),
('32345678900', 'Juliana Costa', 'juliana@admin.com', 'senha789', 'ATIVO'),
('42345678900', 'Paulo Souza', 'paulo@admin.com', 'admin123', 'BLOQUEADO'),
('52345678900', 'Fernanda Rocha', 'fernanda@admin.com', 'pass321', 'ATIVO');
INSERT INTO moto (placa, modelo, status, km_atual, localizacao, data_ultimo_check) VALUES
('AAA1111', 'Honda CG 160', 'NO_PATIO', 12000, 'Pátio Central', '2024-12-01'),
('BBB2222', 'Yamaha Fazer 250', 'EM_USO', 8000, 'Rua das Flores', '2025-01-15'),
('CCC3333', 'Suzuki Yes 125', 'SUSPEITA', 15000, 'Av. Brasil', '2025-02-10'),
('DDD4444', 'Honda Biz 110i', 'FURTADA', 5000, 'Desconhecido', '2025-03-05'),
('EEE5555', 'Shineray Phoenix', 'NO_PATIO', 3000, 'Pátio Norte', '2025-04-20');
-- continua com as demais motos...
INSERT INTO patio (id_patio, nm_patio, capacidade) VALUES
(1, 'Pátio Central', 50),
(2, 'Pátio Norte', 40),
(3, 'Pátio Sul', 60),
(4, 'Pátio Leste', 30),
(5, 'Pátio Oeste', 70);