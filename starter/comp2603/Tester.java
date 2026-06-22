package comp2603;

public class Tester {
    public static void main(String[] args) {
        Bird b1 = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        System.out.println(b1.toString());

        b1.logSighting("2026-06-10", "Caroni Swamp");
        System.out.println("Sighting count: " + b1.getSightingCount() + " (Expected: 1) " );


        Marine shelly = new Marine("Hawksbill Turtle", "Shelly", "Jamaica", 80.0, "Injured", 50.0, 3000);
        System.out.println(shelly.canRelocateTo("Jamaica")); // false

        Marine shellyAnn = new Marine("Hawksbill Turtle", "Shelly", "Trinidad", 80.0, "Injured", 50.0, 3000);
        System.out.println(shellyAnn.canRelocateTo("Jamaica")); // true

        Bird ruby = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
System.out.println(ruby.canRelocateTo("Jamaica")); // true
       }
}



