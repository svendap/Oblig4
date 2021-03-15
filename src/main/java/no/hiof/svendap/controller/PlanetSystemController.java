package no.hiof.svendap.controller;

import no.hiof.svendap.model.Planet;
import no.hiof.svendap.model.PlanetSystem;
import no.hiof.svendap.repository.UniverseRepository;
import io.javalin.http.Context;
import java.util.ArrayList;


public class PlanetSystemController {
    private UniverseRepository universeRepository;

    public PlanetSystemController(UniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
    }


    public void getAllPlanetSystems(Context context) {
        ArrayList<PlanetSystem> planetSystems = universeRepository.getAllPlanetSystems();
        context.json(planetSystems);
    }

    public void getPlanetSystem(Context context) {
        String planetSystemId = context.pathParam(":planet-system-id");
        PlanetSystem aPlanetSystem = universeRepository.getPlanetSystem(planetSystemId);
        context.json(aPlanetSystem);
    }
}
