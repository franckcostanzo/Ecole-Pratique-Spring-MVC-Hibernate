package com.springdemo;

import com.servicedemo.PrepareService;

public class Violoniste implements Musicien {
	
	private PrepareService service;
		
	public PrepareService getService() {
		return service;
	}

	public void setService(PrepareService service) {
		this.service = service;
	}
	
	@Override
	public String joueTaPartition() 
	{
		return "Je joue la valse à 3 temps au violon comme un dingo !";
	}
	
	@Override
	public String getPrepa()
	{
		return service.getPrepa();
	}
}
