package com.dh.movieservice.api.service.impl;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
	private final MovieRepository movieRepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public List<Movie> getListByGenre(String genre) throws Exception {
		List<Movie> res= movieRepository.findAllByGenre(genre);
		if (res.isEmpty()){
			throw new Exception();
		}
		return res;
	}

	@Override
	public Movie save(Movie movie) throws Exception {
		Movie res;
		if (movie.getName() ==null || movie.getGenre()==null || movie.getUrlStream()==null){
			throw new Exception();
		}else {
			res =movieRepository.save(movie);
		}
		return res;
	}
}
