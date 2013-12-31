package com.kum.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
@Entity
public class Device implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	private String name;

	@ManyToOne
	private Location location;

	@OneToMany
	private java.util.List<Function> functionList = new java.util.ArrayList<Function>();
	private static final long serialVersionUID = 1L;

	public Device() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlTransient
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public java.util.List<Function> getFunctionList() {
		return this.functionList;
	}

	public void setFunctionList(java.util.List<Function> functionList) {
		this.functionList = functionList;
	}

}