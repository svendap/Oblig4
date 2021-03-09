package no.hiof.svendap.model;

public class Star extends CelestialBody{
    private int effectiveTemp;
    static final double Msun = 1.98892E30;
    static final double Rsun = 695700;

    public Star(String name, double radius, double mass, int effectiveTemp) {
        super(name, radius, mass);
        this.effectiveTemp = effectiveTemp;
    }

    public int getEffectiveTemp() {
        return effectiveTemp;
    }

    public void setEffectiveTemp(int effectiveTemp) {
        this.effectiveTemp = effectiveTemp;
    }


    @Override
    public String toString() {
        return getName() + ", radius=" + getRadius() + " Rsun, mass=" + getMass() + " Msun, effectiveTemp=" + effectiveTemp;
    }

    @Override
    public double getMassInKg() {
        return getMass() * Msun;
    }

    @Override
    public double getRadiusInKm() {
        return getRadius() * Rsun;
    }


    @Override
    public int compareTo(CelestialBody cb) {
        return (int)getMassInKg() - (int)cb.getMassInKg();
    }
}
