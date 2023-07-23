package com.example.swplanetapi.domain;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlanetService {
    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository){
        this.planetRepository = planetRepository;
    }
    public Planet create(Planet planet){
        return planetRepository.save(planet);
    }

    public List<Planet> findAll(String terrain, String climate){
        return planetRepository.findByTerrainContainsAndClimateContains(terrain, climate);
    }
    public Planet findById(Long id){
        Optional<Planet> opt =  planetRepository.findById(id);
        return opt.orElseThrow();
    }

    public List<Planet> findByName(String name){
        List<Planet> listPlanets = planetRepository.findByName(name).orElseThrow();
        if(listPlanets.isEmpty())
            throw new NoSuchElementException("No value present");
        return listPlanets;
    }

    public void delete(Long id){
        planetRepository.delete(planetRepository.getReferenceById(id));
    }
}
