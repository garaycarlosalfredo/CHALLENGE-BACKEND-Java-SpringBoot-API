/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garay.backend.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "personaje")
@NamedQueries({
    @NamedQuery(name = "Personaje.findAll", query = "SELECT p FROM Personaje p"),
    @NamedQuery(name = "Personaje.findById", query = "SELECT p FROM Personaje p WHERE p.id = :id"),
    @NamedQuery(name = "Personaje.findByImagen", query = "SELECT p FROM Personaje p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "Personaje.findByNombre", query = "SELECT p FROM Personaje p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Personaje.findByEdad", query = "SELECT p FROM Personaje p WHERE p.edad = :edad"),
    @NamedQuery(name = "Personaje.findByPeso", query = "SELECT p FROM Personaje p WHERE p.peso = :peso"),
    @NamedQuery(name = "Personaje.findByHistoria", query = "SELECT p FROM Personaje p WHERE p.historia = :historia")})
public class Personaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @Column(name = "peso")
    private float peso;
    @Basic(optional = false)
    @Column(name = "historia")
    private String historia;
    /*
    @OneToMany(mappedBy = "asociado")
    private List<Peliserie> peliserieList;
    */
    @JsonBackReference
    @JoinColumn(name = "peliAsociado", referencedColumnName = "id")
    @ManyToOne
    private Peliserie peliAsociado;

    public Personaje() {
    }

    public Personaje(Integer id) {
        this.id = id;
    }

    public Personaje(Integer id, String imagen, String nombre, int edad, float peso, String historia) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }
/*
    public List<Peliserie> getPeliserieList() {
        return peliserieList;
    }

    public void setPeliserieList(List<Peliserie> peliserieList) {
        this.peliserieList = peliserieList;
    }
*/
    public Peliserie getPeliAsociado() {
        return peliAsociado;
    }

    public void setPeliAsociado(Peliserie peliAsociado) {
        this.peliAsociado = peliAsociado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personaje)) {
            return false;
        }
        Personaje other = (Personaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.garay.backend.entity.Personaje[ id=" + id + " ]";
    }
    
}
