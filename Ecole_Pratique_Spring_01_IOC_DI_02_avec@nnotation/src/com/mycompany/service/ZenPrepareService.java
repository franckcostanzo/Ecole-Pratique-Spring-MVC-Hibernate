package com.mycompany.service;

import org.springframework.stereotype.*;

@Component
public class ZenPrepareService implements PrepareService {

	@Override
	public String getPrepa() {
		
		return "Je me prépare à la cool";
	}

}
