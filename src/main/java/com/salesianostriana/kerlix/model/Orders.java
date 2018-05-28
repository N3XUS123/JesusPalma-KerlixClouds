package com.salesianostriana.kerlix.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaContratacion = LocalDate.now();
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCaducidad;

	@ManyToOne
	private User usuario;

	@ManyToOne
	private Product producto;

	public Orders() {
	};

	public Orders(String nombre, int meses, Product producto) {
		this.nombre = nombre;
		this.fechaCaducidad = LocalDate.now().plusMonths(meses);
		this.producto = producto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", nombre=" + nombre + ", fechaContratacion=" + fechaContratacion
				+ ", fechaCaducidad=" + fechaCaducidad + ", usuario=" + usuario + ", producto=" + producto + "]";
	}

	// Metodos propios
	public int getDiasRestantes() {
		return (int) Duration.between(LocalDate.now().atStartOfDay(), fechaCaducidad.atStartOfDay()).toDays();
	}

	public int getMeses() {
		return (int) ChronoUnit.MONTHS.between(LocalDate.now(), fechaCaducidad);
	}

	public Orders setMesesContrato(int meses) {
		fechaCaducidad = fechaCaducidad.plusMonths(meses);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaContratacion == null) ? 0 : fechaContratacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (fechaContratacion == null) {
			if (other.fechaContratacion != null)
				return false;
		} else if (!fechaContratacion.equals(other.fechaContratacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
