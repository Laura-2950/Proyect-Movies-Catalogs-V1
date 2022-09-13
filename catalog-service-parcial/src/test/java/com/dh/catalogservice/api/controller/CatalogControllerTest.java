package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.domain.model.dto.CatalogWS;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CatalogControllerTest {

    private final CatalogController catalogController;

    @Autowired
    public CatalogControllerTest(CatalogController catalogController){
        this.catalogController= catalogController;
    }

    @Test
    public void getCatalogByGenre() throws Exception {
        ResponseEntity<CatalogWS> res= catalogController.getCatalogByGenre("Action");
        assertTrue(res.getBody().getGenre()== "Action");

    }

}