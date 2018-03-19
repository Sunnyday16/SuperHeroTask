package com.task.SuperHero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.SuperHero.model.SuperHeroModel;
import com.task.SuperHero.service.SuperHeroService;


@RestController
public class SuperHeroController {

	@Autowired
	private SuperHeroService superheroService;
	
	@RequestMapping(value="/api/superHeros",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperHeroModel> getSuperHeros() {
		return superheroService.getAllSuperHeros();
	}
	@RequestMapping(value="/api/admin/superHeros/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
	public SuperHeroModel getSuperHeroWithName(@PathVariable String name)
	{
		return superheroService.getSuperHeroByName(name);
	}
}
