package mx.edu.utez.ejemplo.controller;

import jakarta.validation.Valid;
import mx.edu.utez.ejemplo.model.User;
import mx.edu.utez.ejemplo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.plaf.PanelUI;

@Controller
public class MainController {


    @Autowired
    LoginService loginServices;

    @GetMapping("")
    public String index(){
        return "index";
    }
    @GetMapping("capturistas")
    public String capturistas(){
        return "listaCapturistas";
    }
    @GetMapping("clientes")
    public String clientes(){
        return "listaClientes";
    }
    @GetMapping("pedidos")
    public String pedidos(){
        return "listaPedidos";
    }
    @GetMapping("productos")
    public String productos(){
        return "listaProductos";
    }
    @GetMapping("registro")
    public String registroFormulario(Model model){
      model.addAttribute("user" ,new User());
        return "registro";
    }

    @PostMapping("/registro")
    public String registro(@Valid User user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("user",user);
            redirectAttributes.addFlashAttribute("errorMessage","Error en el registro del usuario");
            return "registro";
        }
        redirectAttributes.addFlashAttribute("successMessage","Usuario validado");
        return "redirect:/";
    }

    @GetMapping("bitacora")
    public String logins(Model model){
        model.addAttribute("logins",loginServices.findAll());
        return "listaLogin";
    }
}
