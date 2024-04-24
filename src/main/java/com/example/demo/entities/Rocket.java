package com.example.demo.entities;

import java.util.Date;
import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Rocket{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRocket;
	private String nomRocket;
	private Double budget;
	private Date LDate;
	public Rocket() {
	super();
	}
	public Rocket(String nomRocket, Double budget, Date LDate) {
	super();
	this.nomRocket = nomRocket;
	this.budget = budget;
	this.LDate = LDate;
	
	}
	public Long getIdRocket() {
		return idRocket;
	}
	public void setIdRocket(Long idRocket) {
		this.idRocket = idRocket;
	}
	public String getNomRocket() {
		return nomRocket;
	}
	public void setNomRocket(String nomRocket) {
		this.nomRocket = nomRocket;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public Date getLDate() {
		return LDate;
	}
	public void setLDate(Date lDate) {
		LDate = lDate;
	}
	@Override
	public String toString() {
		return "Rocket [idRocket=" + idRocket + ", nomRocket=" + nomRocket + ", budget=" + budget + ", LDate=" + LDate
				+ "]";
	}
	
}
