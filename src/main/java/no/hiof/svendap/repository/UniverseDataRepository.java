package no.hiof.svendap.repository;

import no.hiof.svendap.model.Planet;
import no.hiof.svendap.model.PlanetSystem;
import no.hiof.svendap.model.Star;

import java.util.ArrayList;

public class UniverseDataRepository implements UniverseRepository{
    private ArrayList<PlanetSystem> planetSystems = new ArrayList<>();


    public UniverseDataRepository() {
        Star sun = new Star("Sun", 1.9885E30,695342,5777, "http://bit.ly/3cVhuZc");
        Star kepler11 = new Star("Kepler-11", 1.889E30,710310,5680, "");

        PlanetSystem solarSystem = new PlanetSystem("Solar System", sun, "http://bit.ly/333CTus");
        PlanetSystem kepler11System = new PlanetSystem("Keppler-11 system", kepler11, "http://bit.ly/2Iz4jPB");


        solarSystem.addPlanet(new Planet("Mercury", 3.283E23,2439.7, 0.387, 0.206, 88, sun, "http://bit.ly/2TB2Heo"));
        solarSystem.addPlanet(new Planet("Venus", 4.867E24,6051.8, 0.723, 0.007, 225, sun, "http://bit.ly/2W3p4L9"));
        solarSystem.addPlanet(new Planet("Earth", 5.972E24,6371, 1, 0.017, 365, sun, "http://bit.ly/33bvXLZ"));
        solarSystem.addPlanet(new Planet("Mars", 6.39E23,3389.5, 1.524, 0.093, 687, sun, "http://bit.ly/3aGyFvr"));
        solarSystem.addPlanet(new Planet("Jupiter", 1.898E27,69911, 5.20440, 0.049, 4380, sun, "http://bit.ly/2Q0fjK3"));
        solarSystem.addPlanet(new Planet("Saturn",5.683E26,58232, 9.5826, 0.057, 10585, sun, "http://bit.ly/2W0sqic"));
        solarSystem.addPlanet(new Planet("Uranus",8.681E25,25362, 19.2184, 0.046, 30660, sun, "http://bit.ly/335pbHy"));
        solarSystem.addPlanet(new Planet("Neptune",1.024E26,24622, 30.11, 0.010, 60225,sun, "http://bit.ly/38AyEba"));
        kepler11System.addPlanet(new Planet("Kepler-11b",0.01352982086406744,0.17554411682426005,1.36134E7,0.045,10.0, kepler11, ""));
        kepler11System.addPlanet(new Planet("Kepler-11c",0.04247734457323498,0.28070273597045825,1.5857E7,0.026,13.0, kepler11, ""));
        kepler11System.addPlanet(new Planet("Kepler-11d",0.019193466807165438,0.3056565769596598,2.3786E7,0.004,22.0, kepler11, ""));
        kepler11System.addPlanet(new Planet("Kepler-11e",0.026430347734457325,0.4027863257427404,2.9021E7,0.012,31.0, kepler11, ""));
        kepler11System.addPlanet(new Planet("Kepler-11f",0.007236880927291886,0.2325854641078722,3.7399E7,0.013,36.0, kepler11, ""));
        kepler11System.addPlanet(new Planet("Kepler-11g",0.9439409905163331,0.32614838023834836,6.9114E7,0.015,118.0, kepler11, ""));


        planetSystems.add(solarSystem);
        planetSystems.add(kepler11System);


    }

    @Override
    public ArrayList<PlanetSystem> getAllPlanetSystems() {
        ArrayList<PlanetSystem> planetSystems = getAllPlanetSystems();{
            if (planetSystems != null)
                return planetSystems;
        }

        return new ArrayList<>();
    }

    @Override
    public PlanetSystem getPlanetSystem(String systemName) {
        for (PlanetSystem aPlanetSystem : planetSystems) {
            if (aPlanetSystem.getName().equals(systemName))
                return aPlanetSystem;
        }

        return null;
    }

    @Override
    public ArrayList<Planet> getAllPlanets(String systemName) {
        PlanetSystem thisPlanetSystem = getPlanetSystem(systemName);

        if (thisPlanetSystem != null) {
            return thisPlanetSystem.getPlanets();
        }
        return new ArrayList<>();
    }

    @Override
    public Planet getSpesificPlanetFromPlanetSystem(String systemName, String planetId) {
        PlanetSystem planetSystem = getPlanetSystem(systemName);

        for (Planet thisPlanet : planetSystem.getPlanets()) {
            if (thisPlanet.getName().equals(planetId))
                return thisPlanet;
        }
        return null;
    }

}
