package com.salesianostriana.kerlix.formbean;

public class CreateProduct {

	private Long id;
	private String nombre;
	private String tipo;
	private int almacenamiento;
	private int anchoBanda;
	private double mensualidad;
	private int dominio;
	private int db;
	private int ftp;
	private int email;
	private int cpu;
	private int velocidadRed;
	private int capacidadRam;
	private boolean ssd;
	private String discriminatorValue;
	
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

	public int getDominio() {
		return dominio;
	}

	public void setDominio(int dominio) {
		this.dominio = dominio;
	}

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	public int getFtp() {
		return ftp;
	}

	public void setFtp(int ftp) {
		this.ftp = ftp;
	}

	public int getEmail() {
		return email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

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

	public String getDiscriminatorValue() {
		return discriminatorValue;
	}

	public void setDiscriminatorValue(String discriminatorValue) {
		this.discriminatorValue = discriminatorValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + almacenamiento;
		result = prime * result + anchoBanda;
		result = prime * result + capacidadRam;
		result = prime * result + cpu;
		result = prime * result + db;
		result = prime * result + dominio;
		result = prime * result + email;
		result = prime * result + ftp;
		long temp;
		temp = Double.doubleToLongBits(mensualidad);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + (ssd ? 1231 : 1237);
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + velocidadRed;
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
		CreateProduct other = (CreateProduct) obj;
		if (almacenamiento != other.almacenamiento)
			return false;
		if (anchoBanda != other.anchoBanda)
			return false;
		if (capacidadRam != other.capacidadRam)
			return false;
		if (cpu != other.cpu)
			return false;
		if (db != other.db)
			return false;
		if (dominio != other.dominio)
			return false;
		if (email != other.email)
			return false;
		if (ftp != other.ftp)
			return false;
		if (Double.doubleToLongBits(mensualidad) != Double.doubleToLongBits(other.mensualidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (ssd != other.ssd)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (velocidadRed != other.velocidadRed)
			return false;
		return true;
	}

}
