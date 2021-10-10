package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		//instanciation d'un violoniste simplement
		Violoniste musicien = new Violoniste();
		
		System.out.println(musicien.joueTaPartition() + "\n");
		
		//instanciation d'un violoniste via l'interface
		Musicien musicien2 = new Violoniste();
		
		System.out.println(musicien2.joueTaPartition()  + "\n");
		
		//instanciation d'un pianiste via l'interface
		Musicien musicien3 = new Pianiste();
		
		System.out.println(musicien3.joueTaPartition() +"\n");
		
		
		
		
		System.out.println("******************************"
						+"\n   Avec application Context"
						+"\n******************************");
						
		
		//Load spring configuration file and container creation
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//instanciation du Musicien 
		//via le bean qu'on a créé dans le applicationContext.xml
		Musicien pianiste = context.getBean("monMusicien", Musicien.class);
		System.out.println("\n");
		
		System.out.println(pianiste.joueTaPartition() 
				+ "\n" +pianiste.getPrepa() + "\n");
		
		
		/*Pour pouvoir utiliser les getters et setters 
		 * de la classe Guitariste je ne peux pas instancier de Musicien,
		 * En effet, les limites de la généricité font que l'instanciation
		 * d'une interface même affecté à une classe l'implémentant
		 * ne permet pas d'utiliser les méthodes de cette classe
		 * */
		Guitariste guitariste = 
				context.getBean("monAutreMusicien", Guitariste.class);
		
		System.out.println(guitariste.joueTaPartition() 
				+ "\n" + guitariste.getPrepa());
		System.out.println("L'email du guitarite est : " + guitariste.getEmailAdress() 
				+ "\net son site internet : " + guitariste.getWebSite()  + "\n");
		
		Musicien violoniste =
				context.getBean("monTroisiemeMusicien", Musicien.class);
		
		System.out.println(violoniste.joueTaPartition() 
				+ "\n" + violoniste.getPrepa() + "\n");
		
		//fermeture du context
		context.close();
		
		
		//Scope du bean par default, tous les objets pointent vers le même bean, la même adresse mémoire
		
		System.out.println("******************************"
						+"\n   Avec BeanScope par default"
						+"\n******************************" +"\n");

		ClassPathXmlApplicationContext context1 = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Pianiste pianisteA = context1.getBean("monMusicien", Pianiste.class);
		pianisteA.setTaille(25);
		
		Pianiste pianisteB = context1.getBean("monMusicien", Pianiste.class);
		
		System.out.println("premier pianiste :" + pianisteA.joueTaPartition() 
							+ " et sa taille est : " + pianisteA.getTaille()
							+"\ndeuxieme pianiste :" + pianisteB.joueTaPartition()  
							+ " et sa taille est : " + pianisteB.getTaille() +"\n");
		
		context1.close();
		
		
		/*Scope du bean prototype, tous les objets pointent vers le même bean, 
		 * mais il y a création d'un nouvel objet à chaque nouvel appel du bean
		 */
		System.out.println("******************************"
						+"\n   Avec BeanScope prototype"
						+"\n******************************" +"\n");
		
		ClassPathXmlApplicationContext context2 = 
				new ClassPathXmlApplicationContext("beanScope_applicationContext.xml");
		
		Pianiste pianisteC = context2.getBean("monMusicien", Pianiste.class);
		pianisteC.setTaille(14);
		
		Pianiste pianisteD = context2.getBean("monMusicien", Pianiste.class);
		
		System.out.println("premier pianiste : " + pianisteC.joueTaPartition() 
							+ " et sa taille est : " + pianisteC.getTaille()
							+"\ndeuxieme pianiste : " + pianisteD.joueTaPartition()  
							+ " et sa taille est : " + pianisteD.getTaille() +"\n");
		
		context2.close();
		
		/*
		 * Altération des méthodes Init et destroy des beans
		 */
		
		System.out.println("************************************"
						+"\n Altération méthode init et destroy"
						+"\n************************************" +"\n");
		
		ClassPathXmlApplicationContext context3 = 
				new ClassPathXmlApplicationContext("Alteration_InitAndDestroy_applicationContext.xml");
		
		Pianiste pianisteE = context3.getBean("monMusicien", Pianiste.class);
		
		System.out.println("premier pianiste : " + pianisteC.joueTaPartition());
		
		context3.close();
		
		
		
	}

}
