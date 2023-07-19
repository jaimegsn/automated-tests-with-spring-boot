package com.example.swplanetapi.commons;

import com.example.swplanetapi.domain.Planet;

import java.util.Arrays;
import java.util.List;

public class PlanetConstants {
        public static Planet VALID_PLANET = new Planet("name","climate","terrain");
        public static Planet INVALID_PLANET = new Planet("","","");
        public static Long VALID_ID = 1L;
        public static Long INVALID_ID = 2L;
        public static List<Planet> LIST_PLANETS = List.of(VALID_PLANET);

    }
