package com.mycompany.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.*;

import com.mycompany.service.PrepareService;

@Component
public class Batteur implements Musicien {
	
	private PrepareService prepareService;
		
	@Override
	public String joueTaPartition() {
		
		return "Je joue de la batterie badumtss !";
	}
	
	@Override
	public String getPrepa()
	{
		return prepareService.getPrepa();
	}
		
	public PrepareService getPrepareService() {
		return prepareService;
	}
	
	//annotation pour lier la méthode à une dépendance,
	//ici le TapePrepareService
	@Autowired
	@Qualifier("tapePrepareService")
	public void setPrepareService(PrepareService prepareService) {
		this.prepareService = prepareService;
	}
	
	
	//PostConstruct et PreDestroy annotation pour executer des actions
	//au moment de la création et de la destruction
	@PostConstruct
	public void myInitMethode() {
	System.out.println(" DRUMMER HAS COME TO LIFE ");
	}
	@PreDestroy
	public void myDestroyMethode() {
	System.out.println(" DRUMMER HAS BEEN KILLED ");
	}

	

}