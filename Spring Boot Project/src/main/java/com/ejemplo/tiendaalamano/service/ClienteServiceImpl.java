package com.ejemplo.tiendaalamano.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo.tiendaalamano.data.entities.ClienteEntity;
import com.ejemplo.tiendaalamano.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service("ClienteService")
public class ClienteServiceImpl {
    @Autowired
    private ClienteRepository clienteRepo;

    public List<ClienteEntity> todosLosClientes(){
        return clienteRepo.consultaAll();
    }

    public ClienteEntity unCliente(Integer codigo){
        return clienteRepo.consultaOne(codigo);
    }

    public void crearCliente(ClienteEntity miObjeto){
        clienteRepo.save(miObjeto);
    }

    public void borrarCliente(Integer codigo){
        clienteRepo.deleteById(codigo);
    }

    public void actualizarCliente(ClienteEntity miObjeto){
        Optional<ClienteEntity> objetoVerificado = clienteRepo.findById(miObjeto.getId_cliente());
        if(objetoVerificado.isPresent()){
            clienteRepo.save(miObjeto);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Objeto cliente no encontrado");
        }
    }
    
}
