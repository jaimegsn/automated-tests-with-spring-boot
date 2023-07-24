package com.example.swplanetapi.web;

import com.example.swplanetapi.domain.Planet;
import com.example.swplanetapi.domain.PlanetService;
import com.example.swplanetapi.utils.MediaType;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    final private PlanetService planetService;

    public PlanetController(PlanetService planetService){
        this.planetService = planetService;
    }

    @GetMapping(produces = {MediaType.JSON})
    public ResponseEntity<List<Planet>> findAll(@RequestParam(required = false) String terrain,
                                                @RequestParam(required = false) String climate){
        List<Planet> listPlanets = planetService.findAll(terrain,climate);
        return ResponseEntity.ok().body(listPlanets);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.JSON})
    public ResponseEntity<Planet> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(planetService.findById(id));
    }

    @GetMapping(value="/name/{name}", produces = {MediaType.JSON})
    public ResponseEntity<List<Planet>> findByName(@PathVariable String name){
        return ResponseEntity.ok().body(planetService.findByName(name));
    }


    @PostMapping(produces = MediaType.JSON, consumes = MediaType.JSON)
    public ResponseEntity<Planet> create(@RequestBody @Valid Planet planet){
        return ResponseEntity.status(HttpStatus.CREATED).body(planetService.create(planet));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        planetService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
