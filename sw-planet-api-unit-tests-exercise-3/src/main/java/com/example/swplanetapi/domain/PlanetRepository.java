package com.example.swplanetapi.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
    public Optional<List<Planet>> findByName(String txt);
    public List<Planet> findByTerrainContainsAndClimateContains(String t, String c);


}
