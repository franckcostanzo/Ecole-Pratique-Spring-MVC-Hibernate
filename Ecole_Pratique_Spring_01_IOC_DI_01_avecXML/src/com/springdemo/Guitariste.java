package com.springdemo;

import com.servicedemo.PrepareService;

public class Guitariste implements Musicien {
	
	private PrepareService service;
	private String emailAdress;
	private String webSite;
	private int toto;
		
	public Guitariste(PrepareService service) {
		super();
		this.service = service;
	}
	
	public Guitariste() {};

	
	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdresse) {
		this.emailAdress = emailAdresse;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	@Override
	public String joueTaPartition ()
	{
		return "Je joue de la gratte !";
	}
	
	@Override
	public String getPrepa()
	{
		
		return service.getPrepa();
	}

}
