package com.mycompany.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mycompany.service.PrepareService;

@Component
public class Violoniste implements Musicien 
{
	private PrepareService prepareService;
	
	//annotation avec fichier properties
	@Value("${email}")private String email;
	
	@Value("${site}")private String site;
	
	@Override
	public String joueTaPartition ()
	{
		return "Je joue du violon !";
	}
	
	@Override
	public String getPrepa()
	{
		return prepareService.getPrepa();
	}
	
	//constructeur avec annotation pour referencer une dépendance
	//ici le ZenPrepareService
	public Violoniste(@Qualifier("zenPrepareService") 
							PrepareService preapreService) 
	{
		this.prepareService = preapreService;
	}

	//getter setter email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//getter setter site
	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	
	
}