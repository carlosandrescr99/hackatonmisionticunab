package com.ejemplo.tiendaalamano.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo.tiendaalamano.data.entities.DireccionEntity;
import com.ejemplo.tiendaalamano.repository.DireccionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service("DireccionService")
public class DireccionServiceImpl {
    @Autowired
    private DireccionRepository direccionRepo;

    public List<DireccionEntity> todasLasDirecciones(){
        return direccionRepo.consultaAll();
    }
    
    public DireccionEntity unaDireccion(Integer codigo){
        return direccionRepo.consultaOne(codigo);
    }

    public void crearDireccion(DireccionEntity miObjeto){
        direccionRepo.save(miObjeto);
    }

    public void borrarDireccion(Integer codigo){
        direccionRepo.deleteById(codigo);
    }

    public void actualizarDireccion(DireccionEntity miObjeto){
        Optional<DireccionEntity> objetoVerificado = direccionRepo.findById(miObjeto.getId_direccion());
        if(objetoVerificado.isPresent()){
            direccionRepo.save(miObjeto);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Objeto direccion no encontrado");
        }
    }
}
