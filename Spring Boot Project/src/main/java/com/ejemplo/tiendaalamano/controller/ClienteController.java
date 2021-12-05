package com.ejemplo.tiendaalamano.controller;

import java.util.List;

import com.ejemplo.tiendaalamano.data.entities.ClienteEntity;
import com.ejemplo.tiendaalamano.service.ClienteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteServiceImpl clienteServicio;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<ClienteEntity> obtenerTodosClientes(){
        return clienteServicio.todosLosClientes();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/uno/{codigo}", method = RequestMethod.GET)
    public ClienteEntity obtenerUnCliente(@PathVariable Integer codigo){
        return clienteServicio.unCliente(codigo);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/nuevo", method = RequestMethod.POST, consumes = "application/json")
    public void nuevoCliente(@RequestBody ClienteEntity miObjetito){
        clienteServicio.crearCliente(miObjetito);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/borrar/{codigo}", method = RequestMethod.DELETE)
    public void eliminarUnCliente(@PathVariable Integer codigo){
        clienteServicio.borrarCliente(codigo);
    }

    @ResponseStatus(code = HttpStatus.OK, reason = "Objeto cliente cambiado")
    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public void actualizarCliente(@RequestBody ClienteEntity miObjeto){
        clienteServicio.actualizarCliente(miObjeto);
    }
}
