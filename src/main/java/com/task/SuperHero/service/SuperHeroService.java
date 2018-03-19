package com.task.SuperHero.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.task.SuperHero.model.SuperHeroModel;

@Service
public class SuperHeroService {

	public List<SuperHeroModel> getAllSuperHeros() {
		List<SuperHeroModel> superHeroList = createSuperHeros();
		return superHeroList;
	}

	
	public SuperHeroModel getSuperHeroByName(String name) {
		List<SuperHeroModel> superHeroList = createSuperHeros();
		return superHeroList.stream().filter(t -> t.getSuperHeroName().equals(name)).findFirst().get();
	}

	private List<SuperHeroModel> createSuperHeros() {
		ArrayList<String> batManSkills = new ArrayList<>();
		batManSkills.add("Unarmed Combat");
		batManSkills.add("Insanely Rich");
		batManSkills.add("Gadgets");
		batManSkills.add("Stealth");
		batManSkills.add("Escape Artist");
		
		ArrayList<String> batManAllies = new ArrayList<>();
		batManAllies.add("Robin");
		batManAllies.add("Tim Drake");
		
		ArrayList<String> superManSkills = new ArrayList<>();
		superManSkills.add("Flight ");
		superManSkills.add("telescopic vision");
		superManSkills.add("x-ray vision");
		superManSkills.add("Invulnerability");
		superManSkills.add("speed");
		ArrayList<String> superManAllies = new ArrayList<>();
		superManAllies.add("Batman");
		superManAllies.add("Lana Lang");
		LocalDate d1 = LocalDate.of(1939, Month.MAY, 1);	
		SuperHeroModel batMan = new SuperHeroModel("Batman", "Bruce Wayne", "DC COMICS", batManSkills, batManAllies,
				d1);
		List<SuperHeroModel> superHeroList = new ArrayList<>();
		LocalDate d2 = LocalDate.of(1938, Month.JUNE, 1);
		SuperHeroModel superMan = new SuperHeroModel("SuperMan", "Clark Kent", "DC COMICS", superManSkills,
				superManAllies, d2);

		superHeroList.add(batMan);
		superHeroList.add(superMan);
		return superHeroList;
	}

}
