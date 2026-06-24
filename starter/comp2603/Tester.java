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

     Sanctuary s1 = new Sanctuary("Caroni","Trinidad",22);

        s1.addAnimal(new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true));
        s1.addAnimal(new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true));
        s1.addAnimal(new Bird("Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true));

        // Add 2 Reptiles
        s1.addAnimal(new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0));
        s1.addAnimal(new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0));

        // Add 1 Marine
        s1.addAnimal(new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000));
System.out.println(s1.getDailyFoodBudget());

 //System.out.println(s1.getMostExpensiveAnimal()); close but not meeting the expected result

        System.out.println(s1.getMostExpensiveAnimal().getNickname() + " (the " + s1.getMostExpensiveAnimal().getType() + ") at $" + s1.getMostExpensiveAnimal().getDailyFoodCostTTD() + "/day");


       }
}



