package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Film;
import com.journaldev.spring.service.FilmService;

@Controller
public class FilmController {
	
	private FilmService filmService;
	
	@Autowired(required=true)
	@Qualifier(value="filmService")
	public void setPersonService(FilmService ps){
		this.filmService = ps;
	}
	
	@RequestMapping(value = "/films", method = RequestMethod.GET)
	public String listFilms(Model model) {
		model.addAttribute("film", new Film());
		model.addAttribute("listFilms", this.filmService.listFilms());
		return "film";
	}
	
	//For add and update person both
	@RequestMapping(value= "/film/add", method = RequestMethod.POST)
	public String addFilm(@ModelAttribute("film") Film p){
		
		if(p.getId() == 0){
			//new person, add it
			this.filmService.addFilm(p);
		}else{
			//existing person, call update
			this.filmService.updateFilm(p);
		}
		
		return "redirect:/films";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeFilm(@PathVariable("id") int id){
		
        this.filmService.removeFilm(id);
        return "redirect:/films";
    }
 
    @RequestMapping("/edit/{id}")
    public String editFilm(@PathVariable("id") int id, Model model){
        model.addAttribute("film", this.filmService.getFilmById(id));
        model.addAttribute("listFilms", this.filmService.listFilms());
        return "film";
    }
	
}
