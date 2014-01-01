package com.kum.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
@Entity
public class Location implements Serializable {

	@GeneratedValue(strategy = GenerationType.TABLE)
	@Id
	private long id;
	private String description;
	
	@OneToMany(mappedBy = "location")
	private java.util.List<Device> devices = new java.util.ArrayList<Device>();

	private static final long serialVersionUID = 1L;

	public Location() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@XmlTransient
	public java.util.List<Device> getDevices() {
		return devices;
	}

	public void setDevices(java.util.List<Device> devices) {
		this.devices = devices;
	}
}