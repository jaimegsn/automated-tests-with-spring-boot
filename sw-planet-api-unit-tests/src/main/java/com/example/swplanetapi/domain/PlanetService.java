package com.example.swplanetapi.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {
    private PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository){
        this.planetRepository = planetRepository;
    }
    public Planet create(Planet planet){
        return planetRepository.save(planet);
    }

    public List<Planet> findAll(){
        return planetRepository.findAll();
    }
}
