package com.ejemplo.tiendaalamano.data.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="direcciones")
public class DireccionEntity implements Serializable{    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_direccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_direccion;

    @Column(name="direccion")
    private String direccion;

    @Column(name="estado")
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
    private ClienteEntity clienteModel;

    public Integer getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Integer id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    

}
