package no.hiof.svendap.repository;
import no.hiof.svendap.model.PlanetSystem;

import java.util.ArrayList;

public class UniverseDataRepository implements UniverseRepository{
    private ArrayList<PlanetSystem> planetSystems;

    public UniverseDataRepository() {
        planetSystems = new ArrayList<>();
    }

    public UniverseDataRepository(ArrayList<PlanetSystem> planetSystems) {
        this.planetSystems = planetSystems;
    }
}
