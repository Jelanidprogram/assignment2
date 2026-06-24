package comp2603;
/**
 * Bird subclass. Implements Trackable and Relocatable.
 *
 * TODO M2: Make this class extend Animal
 * TODO M3: Make this class implement Trackable and Relocatable
 */
        /* TODO M2: extends Animal */ /* TODO M3: implements Trackable, Relocatable */
public class Bird extends Animal implements Trackable,Relocatable{


        // TODO M2: Declare private fields: wingspanCm (double), canFly (boolean)
        private double wingspanCm;
        private boolean canFly;
        /**
         * Constructor.
         * TODO M2: Implement constructor that calls super() and sets Bird-specific fields
         */
    public Bird(String species, String nickname, String island, double weightKg, String healthStatus,
        double wingspanCm, boolean canFly){
        // TODO M2: Call super constructor
        // TODO M2: Set wingspanCm and canFly
        super(species, nickname, island, weightKg, healthStatus);
        this.wingspanCm = wingspanCm;
        this.canFly = canFly;
    }



    // TODO M2: Write getWingspanCm() and canFly() getters
public double getWingspanCm(){return wingspanCm;}
    public boolean getCanFly(){return canFly;}
    /**
     * TODO M2: Implement getType() - returns "Bird"
     */
    @Override
    public String getType() {
        return "Bird";
    }
/**

     * Daily food cost = 15.0 + weightKg * 50.0
     * TODO M2: Implement getDailyFoodCostTTD()
     */
@Override
    public double getDailyFoodCostTTD(){
    return 15.0 + getWeightKg() * 50.0;
}
    // --- Trackable methods ---
    // TODO M4: Implement logSighting(String date, String location)
    //          Appends "date at location" to the sightings list
@Override
    public  void logSighting(String date, String location) {
getSightings().add (date + " at " + location);
}
    // TODO M4: Implement getSightingCount()
    //          Returns the size of the sightings list
@Override
    public int getSightingCount(){
    return getSightings().size();
}
    // TODO M4: Implement getLastSighting()
    //          Returns the last entry, or "No sightings recorded" if empty
@Override
    public String getLastSighting(){
    if(getSightings().isEmpty()){
        return "No sightings recorded";
    }
    return getSightings().get(getSightings().size() - 1);
}
    // --- Relocatable methods ---
    // TODO M6: Implement canRelocateTo(String targetIsland)
    //          Birds can always be relocated; return true

        public boolean canRelocateTo(String targetIsland){
    return true;
        }

    @Override
    // TODO M6: Implement getRelocationCost()
    //          Returns 500.0 + weightKg * 100.0
    public double getRelocationCost() {
    return 500.0 + getWeightKg() * 100.0 ;
    }

    // TODO M6: Implement relocateTo(String island)
    //          Updates the island using setIsland()

    public void relocateTo(String island){
    setIsland(island);
    }

}
