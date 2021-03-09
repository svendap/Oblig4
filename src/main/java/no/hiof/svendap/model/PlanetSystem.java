package no.hiof.svendap.model;

import java.util.ArrayList;


public class PlanetSystem implements Comparable<PlanetSystem>{
    private String name;
    private Star centerStar;
    private ArrayList<Planet> planets;


    public PlanetSystem(String name, Star centerStar, ArrayList<Planet> planets) {
        this.name = name;
        this.centerStar = centerStar;
        this.planets = planets;
    }

    public Planet getPlanetByName(String name) {
        for (Planet planet:planets) {
            if (planet.getName().equals(name))
                return planet;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    public Planet getLargestPlanet() { //finds the largest planet by first checking radius, then mass if radius is equal to another.
        Planet largest = planets.get(0);
        for (int i = 1; i < planets.size(); i++) {
            if (planets.get(i).getRadius() > largest.getRadius()) {
                largest = planets.get(i);
            }
            else if (planets.get(i).getRadius() == largest.getRadius()) {
                if (planets.get(i).getMass() > largest.getMass()) {
                    largest = planets.get(i);
                }
            }
        }
        return largest;
    }

    public Planet getSmallestPlanet() { //finds the smallest planet by first checking radius, then mass if radius is equal to another.
        Planet smallest = planets.get(0);
        for (int i = 1; i < planets.size(); i++) {
            if (planets.get(i).getRadius() < smallest.getRadius()) {
                smallest = planets.get(i);
            }
            else if (planets.get(i).getRadius() == smallest.getRadius()) {
                if (planets.get(i).getMass() < smallest.getMass()) {
                    smallest = planets.get(i);
                }
            }
        }
        return smallest;
    }


    //Oppgave 2.3
    @Override
    public String toString() {
        return name + " has a center star named " + centerStar + "\nand " + planets.size() +  " planets:\n"; //+ Arrays.toString(new ArrayList[]{planets});
    }

    @Override
    public int compareTo(PlanetSystem ps) {
        return ps.planets.size() - planets.size();
    }
}
