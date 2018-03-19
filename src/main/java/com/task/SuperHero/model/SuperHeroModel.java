package com.task.SuperHero.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class SuperHeroModel {
	public SuperHeroModel() {
		
	}
	private String superHeroName;
	private String pseudonym;
	private String publisher;
	public SuperHeroModel(String superHeroName, String pseudonym, String publisher, ArrayList<String> superHeroSkills,
			ArrayList<String> superHeroAllies, LocalDate dateOfAppearance) {
		super();
		this.superHeroName = superHeroName;
		this.pseudonym = pseudonym;
		this.publisher = publisher;
		this.superHeroSkills = superHeroSkills;
		this.superHeroAllies = superHeroAllies;
		this.dateOfAppearance = dateOfAppearance;
	}
	private ArrayList<String> superHeroSkills;
	private ArrayList<String> superHeroAllies;
	private LocalDate dateOfAppearance;
	
	public String getSuperHeroName() {
		return superHeroName;
	}
	public void setSuperHeroName(String superHeroName) {
		this.superHeroName = superHeroName;
	}
	public String getPseudonym() {
		return pseudonym;
	}
	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public ArrayList<String> getSuperHeroSkills() {
		return superHeroSkills;
	}
	public void setSuperHeroSkills(ArrayList<String> superHeroSkills) {
		this.superHeroSkills = superHeroSkills;
	}
	public ArrayList<String> getSuperHeroAllies() {
		return superHeroAllies;
	}
	public void setSuperHeroAllies(ArrayList<String> superHeroAllies) {
		this.superHeroAllies = superHeroAllies;
	}
	public LocalDate getDateOfAppearance() {
		return dateOfAppearance;
	}
	public void setDateOfAppearance(LocalDate dateOfAppearance) {
		this.dateOfAppearance = dateOfAppearance;
	}
	

}
