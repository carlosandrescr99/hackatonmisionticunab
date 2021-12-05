package com.ejemplo.tiendaalamano.repository;

import java.util.List;

import com.ejemplo.tiendaalamano.data.entities.DireccionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<DireccionEntity, Integer> {
    @Query("SELECT d FROM DireccionEntity d")
    public List<DireccionEntity> consultaAll();

    @Query("SELECT d FROM DireccionEntity d WHERE d.id_direccion=:codigo")
    public DireccionEntity consultaOne(Integer codigo);

    @Query("DELETE FROM DireccionEntity d WHERE d.id_direccion=:codigo")
    public Void borrarOne(Integer codigo);




    
}
