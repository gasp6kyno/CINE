package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Film;

@Repository
public class FilmDAOImpl implements FilmDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(FilmDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addFilm(Film p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Film saved successfully, Film Details="+p);
	}

	@Override
	public void updateFilm(Film p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Film updated successfully, Film Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Film> listFilms() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Film> FilmsList = session.createQuery("from Film").list();
		for(Film p : FilmsList){
			logger.info("Film List::"+p);
		}
		return FilmsList;
	}

	@Override
	public Film getFilmById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Film p = (Film) session.load(Film.class, new Integer(id));
		logger.info("Film loaded successfully, Film details="+p);
		return p;
	}

	@Override
	public void removeFilm(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Film p = (Film) session.load(Film.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Film deleted successfully, Film details="+p);
	}

}
