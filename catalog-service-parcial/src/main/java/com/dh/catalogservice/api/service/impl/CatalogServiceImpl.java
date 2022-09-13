package com.dh.catalogservice.api.service.impl;


import com.dh.catalogservice.api.service.CatalogFeignClient;
import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CatalogServiceImpl implements CatalogService {


	private final CatalogFeignClient catalogFeignClient;

	@Autowired
	public CatalogServiceImpl(CatalogFeignClient catalogFeignclient) {
		this.catalogFeignClient= catalogFeignclient;
	}

	@Override
	public CatalogWS getMovieByGenre(String genre) {
		ResponseEntity<List<MovieWS>> response= catalogFeignClient.findMovieByGenre(genre);
		if(response.getStatusCode().is2xxSuccessful() && !Objects.requireNonNull(response.getBody()).isEmpty())
			return getCatalogWS(genre, response.getBody());
		return null;
	}

	private CatalogWS getCatalogWS(String genre, List<MovieWS> movies){
		CatalogWS catalogWS= new CatalogWS();
		catalogWS.setGenre(genre);
		catalogWS.setMovies(movies);
		return catalogWS;
	}

}
