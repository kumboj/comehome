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
public class Function implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	private String name;
	
	@ManyToOne
	private Device device;
	
	@OneToMany(mappedBy = "function")
	private java.util.List<CalledFunction> calledFunctions = new java.util.ArrayList<CalledFunction>();
	
	private static final long serialVersionUID = 1L;

	public Function() {
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
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
	@XmlTransient
	public java.util.List<CalledFunction> getCalledFunctions() {
		return calledFunctions;
	}

	public void setCalledFunctions(java.util.List<CalledFunction> calledFunctions) {
		this.calledFunctions = calledFunctions;
	}

	
}