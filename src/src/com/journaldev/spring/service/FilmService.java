package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Film;

public interface FilmService {

	public void addFilm(Film p);
	public void updateFilm(Film p);
	public List<Film> listFilms();
	public Film getFilmById(int id);
	public void removeFilm(int id);
	
}
