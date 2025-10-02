// package br.com.fiap.ibike.config;

// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Component;

// import br.com.fiap.ibike.components.StatusAdministrador;
// import br.com.fiap.ibike.components.StatusMoto;
// import br.com.fiap.ibike.components.StatusPatio;
// import br.com.fiap.ibike.components.TipoEvento;
// import br.com.fiap.ibike.model.Administrador;
// import br.com.fiap.ibike.model.Moto;
// import br.com.fiap.ibike.model.Monitoracao;
// import br.com.fiap.ibike.model.Patio;
// import br.com.fiap.ibike.repository.AdministradorRepository;
// import br.com.fiap.ibike.repository.MotoRepository;
// import br.com.fiap.ibike.repository.MonitoracaoRepository;
// import br.com.fiap.ibike.repository.PatioRepository;
// import jakarta.annotation.PostConstruct;

// @Component
// public class DataSeeder {

//     @Autowired
//     private MotoRepository motoRepository;

//     @Autowired
//     private PatioRepository patioRepository;

//     @Autowired
//     private AdministradorRepository administradorRepository;

//     @Autowired
//     private MonitoracaoRepository monitoracaoRepository;

//     @Autowired
//     private PasswordEncoder passwordEncoder;

//     @PostConstruct
//     public void init() {
//         // === CRIANDO PÁTIOS ===
//        var patio1 = Patio.builder()
//             .id(1L)
//             .nome("Pinheiros")
//             .capacidade(100)
//             .status(StatusPatio.DISPONIVEL)
//             .build();

//         var patio2 = Patio.builder()
//             .id(2L)
//             .nome("Moema")
//             .capacidade(50)
//             .status(StatusPatio.DISPONIVEL)
//             .build();

//         var patio3 = Patio.builder()
//             .id(3L)
//             .nome("Vila Madalena")
//             .capacidade(70)
//             .status(StatusPatio.SOBRECARGA)
//             .build();

//         var patio4 = Patio.builder()
//             .id(4L)
//             .nome("Jardins")
//             .capacidade(40)
//             .status(StatusPatio.CHEIO)
//             .build();

//         var patio5 = Patio.builder()
//             .id(5L)
//             .nome("Itaim Bibi")
//             .capacidade(30)
//             .status(StatusPatio.DISPONIVEL)
//             .build();

//         patioRepository.saveAll(List.of(patio1, patio2, patio3, patio4, patio5));

//         // === CRIANDO ADMINISTRADORES ===
//         var admin1 = Administrador.builder()
//             .cpf("12345678901")
//             .email("admin@example.com")
//             .password(passwordEncoder.encode("123456"))
//             .nome("Administrador Principal")
//             .status(StatusAdministrador.ATIVO)
//             .patio(patio1)
//             .build();

//         var admin2 = Administrador.builder()
//             .cpf("11122233344")
//             .email("teste@teste.com")
//             .password(passwordEncoder.encode("senha123"))
//             .nome("Teste Silva")
//             .status(StatusAdministrador.ATIVO)
//             .patio(patio2)
//             .build();

//         administradorRepository.saveAll(List.of(admin1, admin2));

//         // === CRIANDO MOTOS ===
//         var motos = List.of(
//             Moto.builder()
//                 .placa("ABC-1234")
//                 .modelo("Mottu Sport")
//                 .status(StatusMoto.NO_PATIO)
//                 .kmAtual(1230.5)
//                 .dataUltimoCheck(LocalDate.parse("2025-04-21"))
//                 .patio(patio1)
//                 .build(),

//             Moto.builder()
//                 .placa("DEF-5678")
//                 .modelo("Mottu E")
//                 .status(StatusMoto.EM_USO)
//                 .kmAtual(5400)
//                 .dataUltimoCheck(LocalDate.parse("2025-04-20"))
//                 .patio(patio2)
//                 .build(),

//             Moto.builder()
//                 .placa("GHI-9012")
//                 .modelo("Mottu Pop")
//                 .status(StatusMoto.MANUTENÇÃO)
//                 .kmAtual(870.3)
//                 .dataUltimoCheck(LocalDate.parse("2025-04-22"))
//                 .patio(patio3)
//                 .build(),

//             Moto.builder()
//                 .placa("JKL-3456")
//                 .modelo("Mottu Sport")
//                 .status(StatusMoto.NO_PATIO)
//                 .kmAtual(2345.1)
//                 .dataUltimoCheck(LocalDate.parse("2025-04-18"))
//                 .patio(patio4)
//                 .build(),

//             Moto.builder()
//                 .placa("MNO-7890")
//                 .modelo("Mottu E")
//                 .status(StatusMoto.PENDENTE)
//                 .kmAtual(4500)
//                 .dataUltimoCheck(LocalDate.parse("2025-04-19"))
//                 .patio(patio5)
//                 .build()
//         );

//         motoRepository.saveAll(motos);

//         // === CRIANDO MONITORAÇÕES ===
//         var monitoracoes = List.of(
//             Monitoracao.builder()
//                 .tipoEvento(TipoEvento.ENTRADA)
//                 .dataHora(LocalDateTime.now().minusDays(1))
//                 .moto(motos.get(0))
//                 .build(),

//             Monitoracao.builder()
//                 .tipoEvento(TipoEvento.SAIDA)
//                 .dataHora(LocalDateTime.now())
//                 .moto(motos.get(1))
//                 .build()
//         );

//         monitoracaoRepository.saveAll(monitoracoes);
//     }
// }
