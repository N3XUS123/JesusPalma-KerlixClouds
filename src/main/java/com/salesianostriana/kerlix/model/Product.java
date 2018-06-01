package com.salesianostriana.kerlix.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo; // Nombre del producto
	private int almacenamiento;
	private int anchoBanda;
	private double mensualidad;
	private boolean disabled;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(int almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public int getAnchoBanda() {
		return anchoBanda;
	}

	public void setAnchoBanda(int anchoBanda) {
		this.anchoBanda = anchoBanda;
	}

	public double getMensualidad() {
		return mensualidad;
	}

	public void setMensualidad(double mensualidad) {
		this.mensualidad = mensualidad;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public abstract String getDiscriminatorValue();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + almacenamiento;
		result = prime * result + anchoBanda;
		result = prime * result + (disabled ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(mensualidad);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Product other = (Product) obj;
		if (almacenamiento != other.almacenamiento)
			return false;
		if (anchoBanda != other.anchoBanda)
			return false;
		if (disabled != other.disabled)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(mensualidad) != Double.doubleToLongBits(other.mensualidad))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}
