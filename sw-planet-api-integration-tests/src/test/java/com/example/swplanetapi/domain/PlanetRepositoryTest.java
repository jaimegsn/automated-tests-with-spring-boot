package com.example.swplanetapi.domain;

import static com.example.swplanetapi.commons.PlanetConstants.*;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


@DataJpaTest
public class PlanetRepositoryTest {
    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void createPlanet_WithValidData_ReturnsPlanet(){
        Planet planet = planetRepository.save(VALID_PLANET);
        Planet sut = testEntityManager.find(Planet.class, planet.getIdPlanet());

        assertThat(sut).isNotNull();
        assertThat(sut.getName()).isEqualTo(VALID_PLANET.getName());
        assertThat(sut.getClimate()).isEqualTo(VALID_PLANET.getClimate());
        assertThat(sut.getTerrain()).isEqualTo(VALID_PLANET.getTerrain());
        assertThat(sut.getIdPlanet()).isEqualTo(VALID_PLANET.getIdPlanet());
    }

    @Test
    public void createPlanet_WithInvalidData_ThrowsException(){
        Planet emptyPlanet = new Planet();
        Planet invalidPlanet = new Planet("" , "", "");
        assertThatThrownBy(() -> planetRepository.save(emptyPlanet));
        assertThatThrownBy(() -> planetRepository.save(invalidPlanet));
    }

    @Test
    public void createPlanet_WithExistingName_ThrowsException(){
        Planet planet = testEntityManager.persistAndFlush(VALID_PLANET);
        testEntityManager.detach(planet);
        planet.setIdPlanet(null);
        assertThatThrownBy(() -> planetRepository.save(planet));
    }
}
