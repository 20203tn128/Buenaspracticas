package mx.edu.utez.ejemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.plaf.PanelUI;

@Controller
public class MainController {
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
    public String registro(){
        return "registro";
    }
}
