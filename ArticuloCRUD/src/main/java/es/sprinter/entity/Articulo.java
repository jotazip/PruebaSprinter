package es.sprinter.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Articulos")
public class Articulo {

	@Id
	@Column(name = "id", unique = true)
	private String id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "seccion")
	private String seccion;

	@Column(name = "precio")
	private BigDecimal precio;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Articulo(String id, String nombre, String seccion, BigDecimal precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.seccion = seccion;
		this.precio = precio;
	}

	public Articulo() {
		super();
	}
}
