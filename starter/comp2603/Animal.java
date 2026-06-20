package comp2603;
import java.util.ArrayList;

/**
 * Abstract base class for all animals in the conservation system.
 */
public abstract class Animal {
    // TODO M1: Declare static nextId field, starting at 1

    // TODO M1: Declare private fields:
    //   animalId (int), species (String), nickname (String),
    //   island (String), weightKg (double), healthStatus (String)

    // TODO M4: Declare private ArrayList<String> sightings field

    /**
     * Constructor: assigns auto-incremented ID, validates all parameters.
     * Species, nickname, island must not be null or empty.
     * weightKg must be > 0.
     * healthStatus must be "Healthy", "Injured", or "Critical".
     *
     * TODO M1: Implement constructor with validation
     * TODO M4: Initialize sightings list
     */

    private static int nextId =1;
    private int animalId;
    private String species;
    private String nickname;
    private String island;
    private double weightKg;
    private String healthStatus;
    public Animal(String species, String nickname, String island, double weightKg, String healthStatus) {
        // TODO M1: Validate parameters and assign fields
        // TODO M1: Auto-assign animalId from nextId, then increment nextId
        // TODO M4: Initialize sightings ArrayList
this.species = species;
this.nickname=nickname;
this.island=island;
this.weightKg=weightKg;
this.healthStatus=healthStatus;

if(this.species == null || this.species.equals("")){
    throw new IllegalArgumentException("Species cannot be empty");
}

if(this.nickname == null || this.nickname.equals("")){
    throw new IllegalArgumentException("Nickname cannout be empty");
}

if (this.island == null || this.island.equals("")){
    throw new IllegalArgumentException("Island cannot be empty");
}

if(this.weightKg <=0.0){
    throw new IllegalArgumentException("Please check back the weight of the animal");
}

if (this.healthStatus.equals("Healthy") || this.healthStatus.equals("Injured") || this.healthStatus.equals("Critical")){
    throw new IllegalArgumentException("Health status must either be Healthy , injured or Critical");
}

animalId = nextId;
    }

    // TODO M1: Write getters for all fields (getAnimalId, getSpecies, getNickname,
    //          getIsland, getWeightKg, getHealthStatus)

    // TODO M2: Write setIsland(String island) method
public void setIsland(String island){}
    // TODO M4: Write getSightings() getter that returns the ArrayList<String>

    /**
     * Updates the health status after validation.
     * TODO M1: Implement updateHealth
     */
    public int getAnimalId(){return animalId;}
    public String getSpecies(){return species;}
    public String getNickname(){return nickname;}
    public String getIsland(){return island;}
    public double getWeightKg(){return weightKg;}
    public String getHealthStatus(){return healthStatus;}
    public void updateHealth(String newStatus) {
      if(healthStatus.equals("Healthy")){
          updateHealth("Healthy");// TODO M1: Validate newStatus and update the field
      } else if (healthStatus.equals("Injured"))
        {
          updateHealth("Injured");
        }

      else if (healthStatus.equals("Critical")){
          updateHealth("Critical");
      }
    }

    /**
     * Returns the animal type: "Bird", "Reptile", or "Marine".
     * TODO M2: Declare as abstract
     */
    public abstract String getType();

    /**
     * Returns the daily food cost in TTD. Varies by subclass.
     * TODO M2: Declare as abstract
     */
    public abstract double getDailyFoodCostTTD();

    /**
     * Format: "#%03d %s '%s' (%s) [%s] %.2f kg - %s"
     * Example: "#001 Scarlet Ibis 'Ruby' (Trinidad) [Bird] 0.35 kg - Healthy"
     *
     * TODO M1: Implement toString
     */
    @Override
    public String toString() {
        // TODO M1: Return formatted string
        return
                animalId + " " + species + " ' " + nickname + " ' " + "[ " + island + " ]"
                + weightKg + " " + "kg" + " - " + healthStatus;
    }

    /**
     * Two animals are equal if they have the same animalId.
     *
     * TODO M5: Implement equals
     */
    @Override
    public boolean equals(Object obj) {
        // TODO M5: Implement equality by animalId
        return false;
    }

    /**
     * TODO M5: Implement hashCode based on animalId
     */
    @Override
    public int hashCode() {
        // TODO M5: Return hash based on animalId
        return 0;
    }
}
