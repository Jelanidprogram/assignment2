package comp2603;
//import javax.management.openmbean.TabularData;
import java.util.ArrayList;

/**
 * Manages a collection of animals at a single location.
 */
public class Sanctuary {
    // TODO M5: Declare private fields: name (String), island (String),
    //          capacity (int), animals (ArrayList<Animal>)
    private String name;
    private String island;
    private int capacity;
    private ArrayList<Animal> animals;

    /**
     * TODO M5: Implement constructor
     */
    public Sanctuary(String name, String island, int capacity) {
        // TODO M5: Initialize all fields, create empty ArrayList
        this.name = name;
        this.island = island;
        this.capacity = capacity;
        this.animals = new ArrayList<>();
    }

    // TODO M5: Write getters for name, island, capacity, and animals
    public String getName() {
        return name;
    }

    public String getIsland() {
        return island;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     * Adds an animal to this sanctuary.
     * Rejects null animals, rejects if at capacity, rejects if animal's island
     * does not match this sanctuary's island.
     * <p>
     * TODO M5: Implement addAnimal
     */
    public boolean addAnimal(Animal a) {
        if (a == null) {
            return false;// TODO M5: Validate and add
        }

        if (animals.size() >= capacity) {
            return false;
        }

        if (!a.getIsland().equals(island)) {
            return false;
        }
        animals.add(a);
        return true;
    }

    /**
     * Removes and returns the animal with the given ID, or null if not found.
     *
     * TODO M5: Implement removeAnimal
     */
    public Animal removeAnimal(int animalId) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getAnimalId() == animalId) {
                return animals.remove(i);
            }
        }
        return null;
    }
    /**
     * TODO M5: Implement getAnimalCount
     */
    public int getAnimalCount() {
        // TODO M5
       return animals.size();
    }

    /**
     * Returns a new ArrayList containing only animals of the given type.
     *
     * TODO M7: Implement getAnimalsOfType
     */
    public ArrayList<Animal> getAnimalsOfType(String type) {
        // TODO M7: Filter by getType()
        ArrayList<Animal> result = new ArrayList<>();
        for(Animal a : animals){
    if(a.getType().equals(type)){
        result.add(a);
    }
        }
        return result;
    }

    /**
     * Returns the total daily food cost for all animals, rounded to 2 decimal places.
     *
     * TODO M7: Implement getDailyFoodBudget
     */
    public double getDailyFoodBudget() {
        // TODO M7: Sum getDailyFoodCostTTD() for all animals
        double total=0;
        for(Animal a: animals){
            total += a.getDailyFoodCostTTD();

        }
        return Math.round(total * 100.0) / 100.0;
    }

    /**
     * Returns all animals that implement the Relocatable interface.
     * Hint: use instanceof.
     *
     * TODO M8: Implement getRelocatableAnimals
     */
    public ArrayList<Animal> getRelocatableAnimals() {
        // TODO M8: Filter using instanceof Relocatable
        ArrayList<Animal> relocate = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Relocatable) {
                relocate.add(a);
            }
        }
        return relocate;
    }

    /**
     * Returns the animal with the highest daily food cost, or null if empty.
     *
     * TODO M7: Implement getMostExpensiveAnimal
     */
    public Animal getMostExpensiveAnimal() {
        // TODO M7: Find max by getDailyFoodCostTTD()
        if(animals.isEmpty()){
            return null ;
        }

        double max = Integer.MIN_VALUE;
        Animal mostExpensive = null;

        for(Animal a : animals){
            double cost = a.getDailyFoodCostTTD();
            if(cost > max){
              max = cost;
              mostExpensive = a;
            }
        }
        return mostExpensive;
    }

    /**
     * Transfers an animal to another sanctuary.
     * If the animal does not implement Relocatable, the transfer fails:
     * re-add the animal to this sanctuary and return false.
     * Otherwise, call relocateTo on the animal, then addAnimal on target.
     *
     * TODO M8: Implement transferAnimal
     */
    public boolean transferAnimal(int animalId, Sanctuary target){
            // TODO M8: Remove animal, check Relocatable, relocate, add to target
          Animal ani  = removeAnimal(animalId);

           if (ani == null){return false;}

         if (!(ani instanceof Relocatable)) {
             animals.add(ani); // adding back the removed animal

             return false;
         }
    Relocatable relocatable = (Relocatable) ani;
    relocatable.relocateTo(target.getIsland());

    if(!target.addAnimal(ani)){
        relocatable.relocateTo(this.getIsland());
        animals.add(ani);
        return false;
    }
    return true;
    }
    /**
     * Prints each animal's toString, indented by 2 spaces.
     *
     * TODO M5: Implement printRoster
     */

    public void printRoster() {
        // TODO M5: Loop and print
        for (Animal a : animals) {
            System.out.println("  " + a.toString());
        }
    }

    /**
     * Format: "Name (Island) [count/capacity animals]"
     * Example: "Caroni Bird Sanctuary (Trinidad) [12/50 animals]"
     *
     * TODO M5: Implement toString
     */
    @Override
        // TODO M5: Return formatted string
    public String toString() {
        return name + " (" + island + ")  [" + animals.size() + "/" +
                capacity + " animals]";
    }
}



