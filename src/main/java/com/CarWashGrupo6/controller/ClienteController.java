
package com.CarWashGrupo6.controller;

import com.CarWashGrupo6.domain.Cliente;
import com.CarWashGrupo6.service.ClienteService;
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

/**
 *
 * @author Vivian
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //me hace peticiones de tipo get
    @GetMapping("/listado")//se accede por este /listado
    public String inicio(Model model) {

        List<Cliente> listadoClientes = clienteService.getClientes(false); //falso para que me muestre mis clientes
        //con el objeto model usarlo como transporte entre controlador y la vista
        //  model.addAttribute(attributeName, categoriaService) USAR ESTE
        model.addAttribute("clientes", listadoClientes); //utilizo el segundo el que tiene dos valores String atriute name y object
        model.addAttribute("totalClientes", listadoClientes.size());

        return "/cliente/listado";
    }

    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/cliente/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    //para FORMULARIOS envia mi objeto / atributos de cliente
    //pasa un parametro tipo MultipartFile
    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente,
            @RequestParam("imagenFile") MultipartFile imagenFile) {//viene alguna  imgen  if (!imagenFile.isEmpty() ?
        if (!imagenFile.isEmpty()) {
            clienteService.save(cliente);
            cliente.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "cliente",
                            cliente.getIdCliente()));
        }
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    //viene invocado desde un ancla por ese es de @GetMapping
    //el numero en el hover de la vista se ve gracias al ID idCliente que se va mapeando
    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {//mapeado con la clase Cliente  que tambien tiene el idCliente
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/mostrar/{correo}")
    public String clienteMostrar(Cliente cliente) {//mapeado con la clase Cliente  que tambien tiene el correo
        clienteService.getMostrar(cliente);
        return "redirect:/cliente/listado";
    }

    
      @GetMapping("/modificar/{idCliente}")
       public String clienteModificar(Cliente cliente, Model model) {
          cliente = clienteService.getCliente(cliente);
         model.addAttribute("cliente", cliente);
          return "/cliente/modifica";
     }
}
