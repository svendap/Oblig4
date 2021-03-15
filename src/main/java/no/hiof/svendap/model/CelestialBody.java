package no.hiof.svendap.model;

public abstract class CelestialBody implements Comparable<CelestialBody>{
    private String name;
    private double radius;
    private double mass;
    public String pictureUrl;


    public CelestialBody(String name, double radius, double mass, String pictureUrl) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
        this.pictureUrl = pictureUrl;
    }

    public abstract double getMassInKg();

    public abstract double getRadiusInKm();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
