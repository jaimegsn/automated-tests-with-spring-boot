package com.example.swplanetapi.web;

import com.example.swplanetapi.domain.Planet;
import com.example.swplanetapi.domain.PlanetService;
import com.example.swplanetapi.utils.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private PlanetService planetService;

    public PlanetController(PlanetService planetService){
        this.planetService = planetService;
    }

    @GetMapping(produces = MediaType.JSON)
    public ResponseEntity<List<Planet>> findAll(){
        return ResponseEntity.ok().body(planetService.findAll());
    }

    @PostMapping(produces = MediaType.JSON, consumes = MediaType.JSON)
    public ResponseEntity<Planet> create(@RequestBody Planet planet){
        return ResponseEntity.ok().body(planetService.create(planet));
    }
}
