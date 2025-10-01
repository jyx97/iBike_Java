package br.com.fiap.ibike.controller.web;

import br.com.fiap.ibike.model.Patio;
import br.com.fiap.ibike.service.PatioWebService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patio")
public class PatioWebController {

    private final PatioWebService patioService;

    public PatioWebController(PatioWebService patioService) {
        this.patioService = patioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("patios", patioService.listarTodos());
        return "patio/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("patio", new Patio());
        return "patio/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("patio") Patio patio,
                         BindingResult br) {
        if (br.hasErrors()) return "patio/form";
        patioService.salvar(patio);
        return "redirect:/patio";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("patio", patioService.buscarPorId(id));
        return "patio/form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id,
                            @Valid @ModelAttribute("patio") Patio patio,
                            BindingResult br) {
        if (br.hasErrors()) return "patio/form";
        patioService.atualizar(id, patio);
        return "redirect:/patio";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        patioService.excluir(id);
        return "redirect:/patio";
    }
}
