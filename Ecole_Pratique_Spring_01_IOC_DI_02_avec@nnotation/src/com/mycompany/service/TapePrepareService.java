package com.mycompany.service;

import org.springframework.stereotype.Component;

@Component
public class TapePrepareService implements PrepareService {

	@Override
	public String getPrepa() {

		return "Je tape dans les murs";
	}

}
