package com.mycompany.exec;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.entity.*;;

public class App 
{

	public static void main(String[] args) 
	{
		
		//Load spring configuration file and container creation
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		Violoniste violoniste = context.getBean("violoniste", Violoniste.class);
		System.out.println(violoniste.joueTaPartition() + " et "
							+ violoniste.getPrepa() 
							+ "\nEmail : " + violoniste.getEmail()
							+ "\nSite : " + violoniste.getSite());
		
		Musicien batteur = context.getBean("batteur", Musicien.class);
		System.out.println(batteur.joueTaPartition() + " et " 
							+ batteur.getPrepa());
		
		Musicien saxophoniste = 
				context.getBean("saxophoniste", Musicien.class);
		System.out.println(saxophoniste.joueTaPartition() + " et "
				+ saxophoniste.getPrepa());
		
		Musicien saxophoniste2 = 
				context.getBean("saxophoniste", Musicien.class);
		System.out.println(saxophoniste.joueTaPartition() + " et "
				+ saxophoniste.getPrepa());
		
		Musicien saxophoniste3 = 
				context.getBean("saxophoniste", Musicien.class);
		System.out.println(saxophoniste.joueTaPartition() + " et "
				+ saxophoniste.getPrepa());
		
		context.close();

	}

}