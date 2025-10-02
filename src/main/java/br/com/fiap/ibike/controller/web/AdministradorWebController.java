package br.com.fiap.ibike.controller.web;

import br.com.fiap.ibike.model.Administrador;
import br.com.fiap.ibike.service.AdministradorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/administrador")
public class AdministradorWebController {

    private final AdministradorService administradorService;

    public AdministradorWebController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("admins", administradorService.listarTodos());
        return "administrador/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("admin", new Administrador());
        return "administrador/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("admin") Administrador admin,
                         BindingResult br) {
        if (br.hasErrors()) return "administrador/form";
        administradorService.salvar(admin);
        return "redirect:/administrador";
    }

    @GetMapping("/editar/{cpf}")
    public String editar(@PathVariable String cpf, Model model) {
        model.addAttribute("admin", administradorService.buscarPorCpf(cpf));
        return "administrador/form";
    }

    @PostMapping("/atualizar/{cpf}")
    public String atualizar(@PathVariable String cpf,
                            @Valid @ModelAttribute("admin") Administrador admin,
                            BindingResult br) {
        if (br.hasErrors()) return "administrador/form";
        administradorService.atualizar(cpf, admin);
        return "redirect:/administrador";
    }

    @GetMapping("/excluir/{cpf}")
    public String excluir(@PathVariable String cpf) {
        administradorService.excluir(cpf);
        return "redirect:/administrador";
    }
}
