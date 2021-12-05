package com.ejemplo.tiendaalamano.repository;

import java.util.List;

import com.ejemplo.tiendaalamano.data.entities.ClienteEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    @Query("SELECT l FROM ClienteEntity l")
    public List<ClienteEntity> consultaAll();

    @Query("SELECT l FROM ClienteEntity l WHERE l.id_cliente=:codigo")
    public ClienteEntity consultaOne(Integer codigo);

    @Query("DELETE FROM ClienteEntity l WHERE l.id_cliente=:codigo")
    public Void borrarOne(Integer codigo);   
}
