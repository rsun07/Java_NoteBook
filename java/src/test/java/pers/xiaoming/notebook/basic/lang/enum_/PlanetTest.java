package pers.xiaoming.notebook.basic.lang.enum_;


import org.junit.Test;

public class PlanetTest {

    @Test
    public void testEnumValues() {
        double humanEarthWeight = 70; //kg
        double mass = humanEarthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s \t is %f%n", p, p.surfaceWeight(mass));
        }
    }

    @Test
    public void testOrdinals() {
        // Never derive a value associated with an enum_ from its ordinal; store it in an instance field instead
        for (Planet p : Planet.values()) {
            System.out.printf("Ordinal in %s \t is %d%n", p, p.ordinal());
        }
    }
}
