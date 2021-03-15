package no.hiof.svendap.controller;

import no.hiof.svendap.model.CelestialBody;
import no.hiof.svendap.model.Planet;
import no.hiof.svendap.model.PlanetSystem;
import no.hiof.svendap.repository.UniverseRepository;
import io.javalin.http.Context;
import java.util.ArrayList;
import java.util.Comparator;


public class PlanetController {
    private UniverseRepository universeRepository;

    public PlanetController(UniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
    }


    public void getAllPlanets(Context context) {
        String planetSystemId = context.pathParam(":planet-system-id");
        ArrayList<Planet> planets = new ArrayList<>(universeRepository.getAllPlanets(planetSystemId));

        String s = context.queryParam("sort_by");

        switch (s != null ? s : "") {
            case "name" -> planets.sort(Comparator.comparing(CelestialBody::getName));
            case "mass" -> planets.sort(Comparator.comparing(CelestialBody::getMass));
            case "radius" -> planets.sort(Comparator.comparing(CelestialBody::getRadius));
            default -> planets = new ArrayList<>(universeRepository.getAllPlanets(planetSystemId));
        }
        context.json(planets);
    }

    public void getSpecificPlanetFromPlanetSystem(Context context) {
        String planetSystemId = context.pathParam(":planet-system-id");
        String planetId = context.pathParam(":planet-id");
        PlanetSystem aPlanetSystem = universeRepository.getPlanetSystem(planetSystemId);
        Planet aPlanet = aPlanetSystem.getPlanetByName(planetId);

        context.json(aPlanet);
    }
}
