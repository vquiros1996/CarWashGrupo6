
package com.CarWashGrupo6.controller;

import com.CarWashGrupo6.domain.Cita;
import com.CarWashGrupo6.service.CitaService;
import com.CarWashGrupo6.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/cita")
public class CitaController {
     @Autowired
    private CitaService citaService;

    //me hace peticiones de tipo get
    @GetMapping("/listado")//se accede por este /listado
    public String inicio(Model model) {

        List<Cita> listadoCitas = citaService.getCitas(false); //falso para que me muestre mis clientes
        //con el objeto model usarlo como transporte entre controlador y la vista
        //  model.addAttribute(attributeName, categoriaService) USAR ESTE
        model.addAttribute("citas", listadoCitas); //utilizo el segundo el que tiene dos valores String atriute name y object
        model.addAttribute("totalCitas", listadoCitas.size());

        return "/cita/listado";
    }

    @GetMapping("/nuevo")
    public String citaNuevo(Cita cita) {
        return "/cita/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    //para FORMULARIOS envia mi objeto / atributos de cliente
    //pasa un parametro tipo MultipartFile
    @PostMapping("/guardar")
    public String citaGuardar(Cita cita,
            @RequestParam("imagenFile") MultipartFile imagenFile) {//viene alguna  imgen  if (!imagenFile.isEmpty() ?
        if (!imagenFile.isEmpty()) {
            citaService.save(cita);
            cita.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "cita",
                            cita.getIdCita()));
        }
        citaService.save(cita);
        return "redirect:/cita/listado";
    }

    //viene invocado desde un ancla por ese es de @GetMapping
    //el numero en el hover de la vista se ve gracias al ID idCliente que se va mapeando
    @GetMapping("/eliminar/{idCita}")
    public String citaEliminar(Cita cita) {//mapeado con la clase Cliente  que tambien tiene el idCliente
        citaService.delete(cita);
        return "redirect:/cita/listado";
    }

    //
    @GetMapping("/modificar/{idCita}")
    public String citaModificar(Cita cita, Model model) {
    cita = citaService.getCita(cita);
    model.addAttribute("cita", cita);
    return "/cita/modifica";
    }
}

