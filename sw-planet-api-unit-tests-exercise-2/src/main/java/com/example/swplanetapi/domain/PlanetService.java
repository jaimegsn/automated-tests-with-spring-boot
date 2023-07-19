package com.example.swplanetapi.domain;

import org.springframework.stereotype.Service;

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

    public List<Planet> findAll(){
        return planetRepository.findAll();
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
}
