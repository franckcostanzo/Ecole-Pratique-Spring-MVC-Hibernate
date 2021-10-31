package com.mycompany.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.*;

@Component
public class RandomPrepareService implements PrepareService {

	//en ayant mis à la clé "preparation" du fichier preparation.properties
	//plusieurs valeurs séparées par des "," lorsque j'appelle cette
	//propriété dans un tableau de String, automatiquement chaque String
	//entre "," prend un index
 	@Value("${preparation}")
	private String preparations [];
	
	@Override
	public String getPrepa() {
		
		Random random = new Random();
		int x = random.nextInt(preparations.length);
		return preparations[x];

	}

}
