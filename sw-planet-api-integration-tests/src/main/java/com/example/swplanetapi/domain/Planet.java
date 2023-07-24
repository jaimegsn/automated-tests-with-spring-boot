package com.example.swplanetapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "planets")
public class Planet implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idPlanet;
    @Column(unique = true)
    @NotEmpty
    private String name;
    @Column
    @NotEmpty
    private String climate;
    @Column
    @NotEmpty
    private String terrain;

    public Planet() {

    }

    public Planet( String name, String climate, String terrain) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
    }

    public Long getIdPlanet() {
        return idPlanet;
    }

    public void setIdPlanet(Long idPlanet) {
        this.idPlanet = idPlanet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(idPlanet, planet.idPlanet) && Objects.equals(name, planet.name) && Objects.equals(climate, planet.climate) && Objects.equals(terrain, planet.terrain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlanet, name, climate, terrain);
    }
}
