package com.task.SuperHero;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.task.SuperHero.controller.SuperHeroController;
import com.task.SuperHero.model.SuperHeroModel;
import com.task.SuperHero.service.SuperHeroService;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=SuperHeroController.class, secure=false)
public class SuperHeroTaskApplicationTests {

	@Autowired
	MockMvc mvc;
	@MockBean
	private SuperHeroService superheroService;
	
	SuperHeroModel superHeroModel = new SuperHeroModel();
	@Before
    public void setUp() throws Exception {
		 
		superHeroModel.setSuperHeroName("Batman");
		ArrayList<String> batManSkills = new ArrayList<>();
		batManSkills.add("Unarmed Combat");
		batManSkills.add("Insanely Rich");
		batManSkills.add("Gadgets");
		batManSkills.add("Stealth");
		batManSkills.add("Escape Artist");
		
		ArrayList<String> batManAllies = new ArrayList<>();
		batManAllies.add("Robin");
		batManAllies.add("Tim Drake");
		superHeroModel.setSuperHeroSkills(batManSkills);
		superHeroModel.setSuperHeroAllies(batManAllies);
		superHeroModel.setPublisher("DC COMICS");
		superHeroModel.setPseudonym("Bruce Wayne");
		superHeroModel.setDateOfAppearance(LocalDate.of(1939, Month.MAY, 1));
    }

	@Test
	public void superHeroTest() throws Exception {
		
		given(superheroService.getAllSuperHeros()).willReturn(Arrays.asList(superHeroModel));
	
		mvc.perform(get("/api/superHeros").accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk());
		
	    verify(superheroService,times(1)).getAllSuperHeros();

}
	
	@Test
	public void superHeroByNameTest() throws Exception {
		
		given(superheroService.getSuperHeroByName("Batman")).willReturn(superHeroModel);
		
		mvc.perform(get("/api/admin/superHeros/Batman").accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk()).andExpect(content().json("{\"superHeroName\":\"Batman\",\"pseudonym\":\"Bruce Wayne\",\"publisher\":\"DC COMICS\",\"superHeroSkills\":[\"Unarmed Combat\",\"Insanely Rich\",\"Gadgets\",\"Stealth\",\"Escape Artist\"],\"superHeroAllies\":[\"Robin\",\"Tim Drake\"],\"dateOfAppearance\":{\"year\":1939,\"month\":\"MAY\",\"era\":\"CE\",\"dayOfMonth\":1,\"dayOfWeek\":\"MONDAY\",\"dayOfYear\":121,\"leapYear\":false,\"monthValue\":5,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}}}"));
		verify(superheroService,times(1)).getSuperHeroByName("Batman");
	   

}

}