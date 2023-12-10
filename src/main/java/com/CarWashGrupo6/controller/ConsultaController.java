package com.CarWashGrupo6.controller;

import com.CarWashGrupo6.domain.Consulta;
import com.CarWashGrupo6.service.ConsultaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author quiro
 */
@Controller
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    //me hace peticiones de tipo get
    @GetMapping("/listado")//se accede por este /listado
    public String inicio(Model model) {

        List<Consulta> listadoConsultas = consultaService.getConsultas(false); //falso para que me muestre mis clientes
        //con el objeto model usarlo como transporte entre controlador y la vista
        //  model.addAttribute(attributeName, categoriaService) USAR ESTE
        model.addAttribute("consultas", listadoConsultas); //utilizo el segundo el que tiene dos valores String atriute name y object
        model.addAttribute("totalConsultas", listadoConsultas.size());

        return "/consulta/listado";
    }

    @GetMapping("/nuevo")
    public String consultaNuevo(Consulta consulta) {
        return "/consulta/modifica";
    }
    
   

    @PostMapping("/guardar")
    public String consultaGuardar(Consulta consulta) {

        consultaService.save(consulta);
        return "redirect:/consulta/listado";
    }

    @GetMapping("/eliminar/{idConsulta}")
    public String consultaEliminar(Consulta consulta) {
        consultaService.delete(consulta);
        return "redirect:/consulta/listado";
    }

    /*@GetMapping("/mostrar/{correo}")
    public String consultaMostrar(Consulta consulta) {
        consultaService.getMostrar(consulta);
        return "redirect:/consulta/listado";
    }*/

    @GetMapping("/modificar/{idConsulta}")
    public String consultaModificar(Consulta consulta, Model model) {
        consulta = consultaService.getConsulta(consulta);
        model.addAttribute("consulta", consulta);
        return "/consulta/modifica";
    }
}
