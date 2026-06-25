package comp2603;
import java.util.ArrayList;

/**
 * Console-based demonstration of the Caribbean Wildlife Conservation Tracker.
 * Creates sanctuaries, adds animals, and exercises all major features.
 *
 * TODO M9: Implement the entire Driver class
 *
 * See the README for the complete expected output.
 */
public class Driver {
    public static void main(String[] args) {
        // TODO M9: Create two sanctuaries:
        //   "Caroni Bird Sanctuary", Trinidad, capacity 20
        //   "Blue Lagoon Marine Park", Jamaica, capacity 15
Sanctuary Caroni = new Sanctuary("Caroni Bird Santuary","Trinidad",20);
        Sanctuary blagoon = new Sanctuary("Blue Lagoon Marine Park","Jamaica",15);
        // TODO M9: Create and add animals to Caroni:
        //   Bird: "Scarlet Ibis", "Ruby", Trinidad, 0.35, "Healthy", 60.0, true
        Bird b1 = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        Bird b2 = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
        Bird b3 = new Bird( "Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
        Reptile r1 = new Reptile( "Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
        Reptile r2 = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
        Marine m1 = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000);

        // TODO M9: Create and add animals to Blue Lagoon:
         Bird b4 = new Bird( "Doctor Bird", "Flash", "Jamaica", 0.01, "Healthy", 12.0, true);
         Marine m2 = new Marine( "Hawksbill Turtle", "Shelly", "Jamaica", 80.0, "Injured", 50.0, 3000);
         Marine m3 = new Marine( "Nurse Shark", "Gills", "Jamaica", 110.0, "Healthy", 75.0, 5000);

        // TODO M9: Print "=== Caroni Bird Sanctuary roster ===" then printRoster()
        System.out.println("=== Caroni Bird Santurary roster === ");
        Caroni.printRoster();
        // TODO M9: Print "=== Blue Lagoon Marine Park roster ===" then printRoster()
System.out.println("=== Blue Lagoon Marine Park roster ===");
blagoon.printRoster();
        // TODO M9: Print "=== Daily food budgets ===" then each sanctuary's budget
System.out.println("=== Daily food budgets === ");
System.out.println("Caroni: " + Caroni.getDailyFoodBudget());
System.out.println("Jamaica " + blagoon.getDailyFoodBudget());

        // TODO M9: Print "=== Birds at Caroni ===" then getAnimalsOfType("Bird")
System.out.println("=== Birds at Caroni === ");
for(Animal a : Caroni.getAnimals()){
    System.out.println(a.getNickname());
}
        // TODO M9: Print "=== Relocatable animals at Caroni ===" then getRelocatableAnimals()
System.out.println("=== Relocatable animals at Caroni ===");
for(Animal a : Caroni.getAnimals()){
    if(a instanceof Relocatable){
        System.out.println(a);
    }
}
        // TODO M9: Print "=== Sighting logs ===" then:
        System.out.println("=== Sighting logs ===");
        //   Log Ruby: ("2026-06-10", "Caroni Swamp"), ("2026-06-12", "Nariva Swamp")
        //   Log Atlas: ("2026-06-11", "Matura Beach")
        //   Print counts and last sightings for Ruby, Atlas, and Brutus

        // TODO M9: Print "=== Transfer Atlas to Blue Lagoon ===" then transfer and print result
System.out.println("=== Transfer Atlas to Blue Lagoon ===");
        int atlasId = -1 ;
        Animal atlas =null;
        for(Animal a: Caroni.getAnimals()){
            if(a.getNickname().equals("Atlas")) {
                atlas = a;
                atlasId = a.getAnimalId();
                System.out.println(Caroni.transferAnimal(atlasId,blagoon));
            }
        }
        //bo
        // TODO M9: Print "=== Attempt to transfer Brutus (Reptile) ===" then transfer and print result
System.out.println("=== Attempt to transfer Brutus (Reptile) ===");
        Caroni.transferAnimal(atlasId,blagoon);
        // TODO M9: Print "=== Most expensive animal at each sanctuary ==="
System.out.println("=== Most expensive animal at each santuart ===");

        // TODO M9: Print "=== Updated food budgets ==="
System.out.println("===Updated food budgets===");

    }
}
