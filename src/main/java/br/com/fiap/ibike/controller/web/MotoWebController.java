package br.com.fiap.ibike.controller.web;

import br.com.fiap.ibike.model.Moto;
import br.com.fiap.ibike.service.MotoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/motos")
public class MotoWebController {

    private final MotoService motoService;

    public MotoWebController(MotoService motoService) {
        this.motoService = motoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("motos", motoService.listarTodas());
        return "motos/lista";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("moto", new Moto());
        return "motos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("moto") Moto moto,
                         BindingResult br) {
        if (br.hasErrors()) return "motos/form";
        motoService.salvar(moto);
        return "redirect:/motos";
    }

    @GetMapping("/editar/{placa}")
    public String editar(@PathVariable String placa, Model model) {
        model.addAttribute("moto", motoService.buscarPorPlaca(placa));
        return "motos/form";
    }

    @PostMapping("/atualizar/{placa}")
    public String atualizar(@PathVariable String placa,
                            @Valid @ModelAttribute("moto") Moto moto,
                            BindingResult br) {
        if (br.hasErrors()) return "motos/form";
        motoService.atualizar(placa, moto);
        return "redirect:/motos";
    }

    @GetMapping("/excluir/{placa}")
    public String excluir(@PathVariable String placa) {
        motoService.excluir(placa);
        return "redirect:/motos";
    }
}
