package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.FilmDAO;
import com.journaldev.spring.model.Film;

@Service
public class FilmServiceImpl implements FilmService {
	
	private FilmDAO FilmDAO;

	public void setFilmDAO(FilmDAO FilmDAO) {
		this.FilmDAO = FilmDAO;
	}

	@Override
	@Transactional
	public void addFilm(Film p) {
		this.FilmDAO.addFilm(p);
	}

	@Override
	@Transactional
	public void updateFilm(Film p) {
		this.FilmDAO.updateFilm(p);
	}

	@Override
	@Transactional
	public List<Film> listFilms() {
		return this.FilmDAO.listFilms();
	}

	@Override
	@Transactional
	public Film getFilmById(int id) {
		return this.FilmDAO.getFilmById(id);
	}

	@Override
	@Transactional
	public void removeFilm(int id) {
		this.FilmDAO.removeFilm(id);
	}

}
