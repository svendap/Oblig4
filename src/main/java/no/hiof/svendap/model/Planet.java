package no.hiof.svendap.model;

public class Planet extends NaturalSatellite{
    static final double Mjup = 1.898E27;
    static final double Rjup = 71492;
    static final double gravityConstant = 6.67408E-11;
    static final double Mearth = 5.972E24;
    static final double Rearth = 6371;

    public Planet(String name, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod, Star centralCelestialBody) {
        super(name, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod, centralCelestialBody);
    }



    @Override
    public double getMassInKg() {
        return getMass() * Mjup;
    }

    @Override
    public double getRadiusInKm() {
        return getRadius() * Rjup;
    }

    public double getPlanetRadiusInM() { //converts Km to M.
        return getRadiusInKm() * 1000;
    }

    public double getSurfaceGravity() { //finds the surface gravity of a planet.
        return gravityConstant * getMassInKg() / Math.pow(getPlanetRadiusInM(), 2);
    }


    public double getPlanetMassInMearth() { //converts planet mass from Kg to Mearth.
        return getMassInKg() / Mearth;
    }

    public double getPlanetRadiusInRearth() { //converts planet radius from Km to Rearth.
        return getRadiusInKm() / Rearth;
    }

    @Override
    public String toString() {
        return getName() + "`s radius is " + getRadius() + " Rjup" + " and has a mass off " + getMass() + " Mjup\n";
    }

    @Override
    public int compareTo(CelestialBody cb) {
        return (int)getMassInKg() - (int)cb.getMassInKg();
    }
}

