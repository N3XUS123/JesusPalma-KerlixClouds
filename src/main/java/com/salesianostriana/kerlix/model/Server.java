package com.salesianostriana.kerlix.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Server")
@DiscriminatorValue(value = "Server")
public class Server extends Product {

	private int cpu;
	private int velocidadRed;
	private int capacidadRam;
	private boolean ssd;

	public int getCpu() {
		return cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public int getVelocidadRed() {
		return velocidadRed;
	}

	public void setVelocidadRed(int velocidadRed) {
		this.velocidadRed = velocidadRed;
	}

	public int getCapacidadRam() {
		return capacidadRam;
	}

	public void setCapacidadRam(int capacidadRam) {
		this.capacidadRam = capacidadRam;
	}

	public boolean isSsd() {
		return ssd;
	}

	public void setSsd(boolean ssd) {
		this.ssd = ssd;
	}

	@Override
	public String getDiscriminatorValue() {
		DiscriminatorValue val = this.getClass().getAnnotation(DiscriminatorValue.class);
		return val == null ? null : val.value();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + capacidadRam;
		result = prime * result + cpu;
		result = prime * result + (ssd ? 1231 : 1237);
		result = prime * result + velocidadRed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (capacidadRam != other.capacidadRam)
			return false;
		if (cpu != other.cpu)
			return false;
		if (ssd != other.ssd)
			return false;
		if (velocidadRed != other.velocidadRed)
			return false;
		return true;
	}

}
