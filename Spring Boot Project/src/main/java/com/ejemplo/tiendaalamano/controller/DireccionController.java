package com.ejemplo.tiendaalamano.controller;

import java.util.List;

import com.ejemplo.tiendaalamano.data.entities.DireccionEntity;
import com.ejemplo.tiendaalamano.service.DireccionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {
    @Autowired
    private DireccionServiceImpl direccionServicio;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/todas", method = RequestMethod.GET)
    public List<DireccionEntity> obtenerTodasDirecciones(){
        return direccionServicio.todasLasDirecciones();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "una/{codigo}", method = RequestMethod.GET)
    public DireccionEntity obtenerUnaDireccion(@PathVariable Integer codigo){
        return direccionServicio.unaDireccion(codigo);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/nueva", method = RequestMethod.POST, consumes = "application/json")
    public void nuevaDireccion(@RequestBody DireccionEntity miObjetito){
        direccionServicio.crearDireccion(miObjetito);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/borrar/{codigo}", method = RequestMethod.DELETE)
    public void eliminarUnaDireccion(@PathVariable Integer codigo){
        direccionServicio.borrarDireccion(codigo);
    }
    
    @ResponseStatus(code = HttpStatus.OK, reason = "Objeto direccion cambiado")
    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public void actualizarDireccion(@RequestBody DireccionEntity miObjeto){
        direccionServicio.actualizarDireccion(miObjeto);
    }
}
