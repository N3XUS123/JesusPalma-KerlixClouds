package com.salesianostriana.kerlix.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Hosting")
@DiscriminatorValue(value = "Hosting")
public class Hosting extends Product {

	private int dominio;
	private int db;
	private int ftp;
	private int email;

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

	@Override
	public String getDiscriminatorValue() {
		DiscriminatorValue val = this.getClass().getAnnotation(DiscriminatorValue.class);
		return val == null ? null : val.value();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + db;
		result = prime * result + dominio;
		result = prime * result + email;
		result = prime * result + ftp;
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
		Hosting other = (Hosting) obj;
		if (db != other.db)
			return false;
		if (dominio != other.dominio)
			return false;
		if (email != other.email)
			return false;
		if (ftp != other.ftp)
			return false;
		return true;
	}

}
