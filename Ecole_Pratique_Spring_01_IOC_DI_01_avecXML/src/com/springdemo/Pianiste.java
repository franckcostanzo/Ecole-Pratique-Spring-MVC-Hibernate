package com.springdemo;

import com.servicedemo.PrepareService;

public class Pianiste implements Musicien {
	
	
	private PrepareService service;
	private int taille;
	
	public Pianiste(PrepareService service) {
		super();
		this.service = service;
	}
	
	public Pianiste() {};
		
	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	@Override
	public String joueTaPartition() {
		
		return "Je fais du piano !";
	}
	
	@Override
	public String getPrepa()
	{
		return service.getPrepa();
	}

	//Overloading des méthodes init et destroy
	public void myInitMethod() {
		System.out.println("I CAME TO LIFE !");
	}
	
	public void myDestroyMethod() {
		System.out.println("THEY KILLED ME !");
	}
}
