package com.example.swplanetapi.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.example.swplanetapi.commons.PlanetConstants.VALID_PLANET;
import static com.example.swplanetapi.commons.PlanetConstants.INVALID_PLANET;
import static com.example.swplanetapi.commons.PlanetConstants.VALID_ID;
import static com.example.swplanetapi.commons.PlanetConstants.INVALID_ID;
import static com.example.swplanetapi.commons.PlanetConstants.LIST_PLANETS;


@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {
    @InjectMocks
    private PlanetService planetService;

    @Mock
    private PlanetRepository planetRepository;

    @Test
    //operacaoTestada_estadoParametro_retornoEsperado
    public void createPlanet_WithValidData_ReturnsPlanet(){
        Mockito.when(planetRepository.save(VALID_PLANET)).thenReturn(VALID_PLANET);
        Planet sut = planetService.create(VALID_PLANET);
        assertThat(sut).isEqualTo(VALID_PLANET);
    }

    @Test
    public void createPlanet_WithInvalidData_ThrowsException(){
        Mockito.when(planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);
        assertThatThrownBy(() -> planetService.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);
    }

    //Exercicio 1

    @Test
    public void getPlanet_ByExistingId_ReturnsPlanet(){
        Optional<Planet> optValidPlanet = Optional.of(VALID_PLANET);
        Mockito.when(planetRepository.findById(VALID_ID)).thenReturn(optValidPlanet);
        Planet sut = planetService.findById(VALID_ID);
        assertThat(sut).isEqualTo(VALID_PLANET);
    }

    @Test
    public void getPlanet_ByUnexistingId_ThrowsException(){
        Optional<Planet> optEmptyPlanet = Optional.empty();
        Mockito.when(planetRepository.findById(INVALID_ID)).thenReturn(optEmptyPlanet);
        assertThatThrownBy(() -> planetService.findById(INVALID_ID)).isInstanceOf(RuntimeException.class);
    }

    // Exercicio 2
    @Test
    public void getPlanet_ByExistingName_ReturnsPlanet(){
        Optional<List<Planet>> optListValidPlanets = Optional.of(LIST_PLANETS);
        Mockito.when(planetRepository.findByName("name")).thenReturn(optListValidPlanets);
        List<Planet> sut = planetService.findByName("name");
        assertThat(sut).isEqualTo(LIST_PLANETS);
    }

    @Test
    public void getPlanet_ByUnexistingName_ThrowsException(){
        Optional<List<Planet>> optListValidPlanets = Optional.of(new ArrayList<>());
        Mockito.when(planetRepository.findByName("name")).thenReturn(optListValidPlanets);
        assertThatThrownBy(() -> planetService.findByName("name")).isInstanceOf(NoSuchElementException.class);
    }
}
