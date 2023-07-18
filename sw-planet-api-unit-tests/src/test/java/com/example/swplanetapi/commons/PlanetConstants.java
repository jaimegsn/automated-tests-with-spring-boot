package com.example.swplanetapi.commons;

import com.example.swplanetapi.domain.Planet;

    public class PlanetConstants {
        public static Planet VALID_PLANET = new Planet("name","climate","terrain");
        public static Planet INVALID_PLANET = new Planet("","","");

    }
