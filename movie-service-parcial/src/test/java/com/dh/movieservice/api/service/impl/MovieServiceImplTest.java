package com.dh.movieservice.api.service.impl;

import com.dh.movieservice.domain.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieServiceImplTest {

    private final MovieServiceImpl movieService;
    @Autowired
    public MovieServiceImplTest(MovieServiceImpl movieService){
        this.movieService= movieService;
    }

    @Test
    public void save() throws Exception{
        Movie movie= new Movie("Prueba", "Action", "https://www.prueba");
        movieService.save(movie);

        Movie savedMovie= movieService.save(movie);

        System.out.println(savedMovie);

        assertTrue(savedMovie != null);
        assertEquals("Prueba", savedMovie.getName());


    }
}