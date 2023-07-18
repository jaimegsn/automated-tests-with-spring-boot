package com.example.swplanetapi.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.example.swplanetapi.commons.PlanetConstants.VALID_PLANET;
import static com.example.swplanetapi.commons.PlanetConstants.INVALID_PLANET;


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
}
