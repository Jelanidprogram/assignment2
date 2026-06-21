package comp2603;
/**
 * Trackable interface for animals that can have sighting logs.
 *
 * TODO M3: Define three method signatures:
 *   - void logSighting(String date, String location)
 *   - int getSightingCount()
 *   - String getLastSighting()
 */
public interface Trackable {
  void logSighting(String date, String location);
  int getSightingCount();
  String getLastSighting();
    // TODO M3: Declare logSighting method

    // TODO M3: Declare getSightingCount method

    // TODO M3: Declare getLastSighting method
}
