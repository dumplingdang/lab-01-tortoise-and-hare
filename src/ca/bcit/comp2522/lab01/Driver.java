package ca.bcit.comp2522.lab01;

/***
 * This class does the following:
 * 1. Runs a race between a Hare and a Tortoise in a length of 100
 * 2. Simulates 100 races of a length of 100 and reports the number of wins for the Hare and Tortoise
 * 3. Simulates 100 races of a length of 1000 and reports the number of wins for the Hare and Tortoise
 * 4. Conclusion: Tortoise wins the most
 *
 * @author Jianfen Deng
 * @version 1.0
 *
 */
public class Driver {
    /***
     * The distance of the 1st race is {@value}
     */
    public static final int DISTANCE_OF_RACE_1 = 100;

    /***
     * The distance of the 2nd race is {@value}
     */
    public static final int DISTANCE_OF_RACE_2 = 100;

    /***
     * The distance of the 3rd race is {@value}
     */
    public static final int DISTANCE_OF_RACE_3 = 1000;

    /***
     * The number of times to simulate the 2nd race is {@value}
     */
    public static final int NUMBER_TO_SIMULATE_RACE_2 = 100;

    /***
     * The number of times to simulate the 3rd race is {@value}
     */
    public static final int NUMBER_TO_SIMULATE_RACE_3 = 100;

    /***
     * The initial number of Hare wins is {@value}
     */
    public static final int INITIAL_NUMBER_OF_HARE_WINS = 0;

    /***
     * The initial number of Tortoise wins is {@value}
     */
    public static final int INITIAL_NUMBER_OF_TORTOISE_WINS = 0;

    /***
     * The initial number of simulated races is {@value}
     */
    public static final int INITIAL_NUMBER_OF_SIMULATED_RACES = 0;

    public static void main(String[] args) {
        Hare hare = new Hare();
        Tortoise tortoise = new Tortoise();
        Race race = new Race(hare, tortoise, DISTANCE_OF_RACE_1);
        System.out.println("Race the Tortoise and Hare a distance of " + DISTANCE_OF_RACE_1 + " units:");
        System.out.println("    Winner: ");
        System.out.println("        " + race.simulateRace());
        System.out.println("    Final position: ");
        System.out.println("        Hare: " + race.getHare().getPosition() + " units; Tortoise: " + race.getTortoise().getPosition() + " units");
        System.out.println("===========================================================");
        System.out.println("Simulate " + NUMBER_TO_SIMULATE_RACE_2 + " races of length " + DISTANCE_OF_RACE_2 + ":");
        System.out.println(simulateRaces(NUMBER_TO_SIMULATE_RACE_2, DISTANCE_OF_RACE_2));
        System.out.println();
        System.out.println("Simulate " + NUMBER_TO_SIMULATE_RACE_3 + " races of length " + DISTANCE_OF_RACE_3 + ":");
        System.out.println(simulateRaces(NUMBER_TO_SIMULATE_RACE_3, DISTANCE_OF_RACE_3));
    }

    /*
    Calculates the number of wins for each competitor based on the number of races and the length of races
     */
    private static String simulateRaces(int numberOfRace, int lengthOfRace) {
        Hare hare = new Hare();
        Tortoise tortoise = new Tortoise();
        Race race = new Race(hare, tortoise, lengthOfRace);
        int numberOfHareWins = INITIAL_NUMBER_OF_HARE_WINS;
        int numberOfTortoiseWins = INITIAL_NUMBER_OF_TORTOISE_WINS;

        for (int i = INITIAL_NUMBER_OF_SIMULATED_RACES; i < numberOfRace; i++) {
            if (race.simulateRace().contains("Hare")) {
                numberOfHareWins++;
            } else {
                numberOfTortoiseWins++;
            }
        }
        return "Number of Hare wins: " + numberOfHareWins + ". Number of Tortoise wins: " + numberOfTortoiseWins;
    }

    /***
     * Override toString method and returns the string representation of the Driver object
     * @return the string representation of the Driver object
     */
    @Override
    public String toString() {
        return "Driver{}";
    }
}
