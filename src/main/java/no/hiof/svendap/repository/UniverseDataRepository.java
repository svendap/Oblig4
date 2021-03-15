package no.hiof.svendap.repository;

import no.hiof.svendap.model.Planet;
import no.hiof.svendap.model.PlanetSystem;
import no.hiof.svendap.model.Star;

import java.util.ArrayList;

public class UniverseDataRepository implements UniverseRepository{
    private ArrayList<PlanetSystem> planetSystems = new ArrayList<>();


    public UniverseDataRepository() {
        Star sun = new Star("Sun", 1.9885E30,695342,5777, "http://bit.ly/333CTus");
        Star kepler11 = new Star("Kepler-11", 1.889E30,710310,5680, "http://bit.ly/336nzNZ");

        PlanetSystem solarSystem = new PlanetSystem("Solar System", sun, "http://bit.ly/3cVhuZc");
        PlanetSystem kepler11System = new PlanetSystem("Keppler-11 system", kepler11, "http://bit.ly/2Iz4jPB");




        solarSystem.addPlanet(new Planet("Mercury", 0.03412549655905556, 1.7297154899894627E-4, 0.387, 0.206, 88, sun, "http://bit.ly/2TB2Heo"));
        solarSystem.addPlanet(new Planet("Venus", 0.08465003077267387, 0.002564278187565859, 0.723, 0.007, 225, sun, "http://bit.ly/2W3p4L9"));
        solarSystem.addPlanet(new Planet("Earth", 0.08911486599899289, 0.003146469968387777, 1, 0.017, 365, sun, "http://bit.ly/33bvXLZ"));
        solarSystem.addPlanet(new Planet("Mars", 0.04741089912158004, 3.3667017913593256E-4, 1.524, 0.093, 687, sun, "http://bit.ly/3aGyFvr"));
        solarSystem.addPlanet(new Planet("Jupiter", 1.0, 1.0, 5.20440, 0.049, 4380, sun, "http://bit.ly/2Q0fjK3"));
        solarSystem.addPlanet(new Planet("Saturn",0.8145247020645666, 0.2994204425711275, 9.5826, 0.057, 10585, sun, "http://bit.ly/2W0sqic"));
        solarSystem.addPlanet(new Planet("Uranus",0.35475297935433336, 0.04573761854583773, 19.2184, 0.046, 30660, sun, "http://bit.ly/335pbHy"));
        solarSystem.addPlanet(new Planet("Neptune",0.34440217087226543, 0.05395152792413066, 30.11, 0.010, 60225,sun, "http://bit.ly/38AyEba"));
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
        return planetSystems;
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
    public Planet getSpecificPlanetFromPlanetSystem(String systemName, String planetId) {
        PlanetSystem planetSystem = getPlanetSystem(systemName);

        for (Planet thisPlanet : planetSystem.getPlanets()) {
            if (thisPlanet.getName().equals(planetId))
                return thisPlanet;
        }
        return null;
    }

}
