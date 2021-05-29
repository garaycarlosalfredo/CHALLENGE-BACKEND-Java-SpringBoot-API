/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garay.backend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "peliserie")
@NamedQueries({
    @NamedQuery(name = "Peliserie.findAll", query = "SELECT p FROM Peliserie p"),
    @NamedQuery(name = "Peliserie.findById", query = "SELECT p FROM Peliserie p WHERE p.id = :id"),
    @NamedQuery(name = "Peliserie.findByImagen", query = "SELECT p FROM Peliserie p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "Peliserie.findByTitulo", query = "SELECT p FROM Peliserie p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Peliserie.findByFecha", query = "SELECT p FROM Peliserie p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Peliserie.findByCalificacion", query = "SELECT p FROM Peliserie p WHERE p.calificacion = :calificacion")})
public class Peliserie implements Serializable {

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
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "calificacion")
    private int calificacion;

    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private Genero genero;
    

	@JoinColumn(name = "asociado", referencedColumnName = "id")
    @ManyToOne
    private Personaje asociado;

    
    /*
    @OneToMany(mappedBy = "peliserie")
    private List<Genero> generoList;
    @OneToMany(mappedBy = "peliAsociado")
    private List<Personaje> personajeList;
*/
    public Peliserie() {
    }

    public Peliserie(Integer id) {
        this.id = id;
    }

    public Peliserie(Integer id, String imagen, String titulo, Date fecha, int calificacion) {
        this.id = id;
        this.imagen = imagen;
        this.titulo = titulo;
        this.fecha = fecha;
        this.calificacion = calificacion;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
    
    
    public Personaje getAsociado() {
        return asociado;
    }

    public void setAsociado(Personaje asociado) {
        this.asociado = asociado;
    }
/*
    public List<Genero> getGeneroList() {
        return generoList;
    }

    public void setGeneroList(List<Genero> generoList) {
        this.generoList = generoList;
    }

    public List<Personaje> getPersonajeList() {
        return personajeList;
    }

    public void setPersonajeList(List<Personaje> personajeList) {
        this.personajeList = personajeList;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peliserie)) {
            return false;
        }
        Peliserie other = (Peliserie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.garay.backend.entity.Peliserie[ id=" + id + " ]";
    }
    
}
