package no.hiof.svendap.repository;

import no.hiof.svendap.model.Planet;
import no.hiof.svendap.model.PlanetSystem;

import java.util.ArrayList;

public interface UniverseRepository{
    ArrayList<PlanetSystem> getAllPlanetSystems();
    PlanetSystem getPlanetSystem(String systemName);
    ArrayList<Planet> getAllPlanets(String systemName);
    Planet getSpecificPlanetFromPlanetSystem(String systemName, String planetId);


}
