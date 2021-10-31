package com.mycompany.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mycompany.service.PrepareService;

@Component
@Scope("prototype") 
//le scope prototype instancie un nouveau Saxophoniste à chaque appel du bean
public class Saxophoniste implements Musicien {
	
	private PrepareService prepareService;
	
	@Override
	public String joueTaPartition() {
		
		return "Je fais du saxo !";
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
	//ici le RandomPrepareService
	@Autowired
	@Qualifier("randomPrepareService")
	public void setPrepareService(PrepareService prepareService) {
		this.prepareService = prepareService;
	}
	
	

}
