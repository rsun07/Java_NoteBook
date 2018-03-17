package JavaBasicTest.lang.EnumClass;


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
        // Never derive a value associated with an enum from its ordinal; store it in an instance field instead
        for (Planet p : Planet.values()) {
            System.out.printf("Ordinal in %s \t is %d%n", p, p.ordinal());
        }
    }

    // Enum type with data and behavior
    enum Planet {

        MERCURY(3.302e+23, 2.439e6),
        VENUS  (4.869e+24, 6.052e6),
        EARTH   (5.975e+24, 6.378e6),
        MARS    (6.419e+23, 3.393e6),
        JUPITER(1.899e+27, 7.149e7),
        SATURN (5.685e+26, 6.027e7),
        URANUS (8.683e+25, 2.556e7),
        NEPTUNE(1.024e+26, 2.477e7);

        private final double mass;  // In kilograms
        private final double radius;   // In meters
        private final double surfaceGravity; // In m / s^2

        // Universal gravitational constant in m^3 / kg s^2
        private static final double G = 6.67300E-11;

        // Constructor
        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / (radius * radius);
        }

        public double mass()           { return mass; }
        public double radius()         { return radius; }
        public double surfaceGravity() { return surfaceGravity; }

        public double surfaceWeight(double mass) {
            return mass * surfaceGravity; // F = ma
        }
    }
}