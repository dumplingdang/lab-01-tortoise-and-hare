package ca.bcit.comp2522.lab01;

import java.util.Objects;
import java.util.Random;

/***
 * This class describes a Race between a Hare and a Tortoise
 *
 * @author Jianfen Deng
 * @version 1.0
 */
public class Race {
    /***
     * The original position of a Hare or Tortoise in a Race is {@value}
     */
    public static final int ORIGINAL_POSITION = 0;

    /***
     * The initial time unit at the beginning of a Race is {@value}
     */
    public static final int INITIAL_TIME_UNIT = 0;

    /***
     * The bound of a boolean to decide which animal moves first is {@value}
     */
    public static final int BOOLEAN_BOUND_TO_DECIDE_FIRST_MOVE = 2;

    /***
     * The boolean number which represents a Hare is {@value}
     */
    public static final int BOOLEAN_NUMBER_OF_HARE = 0;

    private Hare hare;
    private Tortoise tortoise;
    private int distance;

    /***
     * Initializes an object of a Race class
     *
     * @param hare a Hare object as a variable in a Race
     * @param tortoise a Tortoise object as a variable in a Race
     * @param distance the distance variable in a Race
     */
    public Race(Hare hare, Tortoise tortoise, int distance) {
        this.hare = hare;
        this.tortoise = tortoise;
        this.distance = distance;
    }

    /***
     * Returns the Hare variable
     * @return the Hare variable
     */
    public Hare getHare() {
        return hare;
    }

    /***
     * Sets the Hare variable
     * @param hare set the Hare variable
     */
    public void setHare(Hare hare) {
        this.hare = hare;
    }

    /***
     * Returns the Tortoise variable
     * @return the Tortoise variable
     */
    public Tortoise getTortoise() {
        return tortoise;
    }

    /***
     * Sets the Tortoise variable
     * @param tortoise set the Tortoise variable
     */
    public void setTortoise(Tortoise tortoise) {
        this.tortoise = tortoise;
    }

    /***
     * Returns the distance of the Race object
     * @return the distance of the Race object
     */
    public int getDistance() {
        return distance;
    }

    /***
     * Sets the distance of the Race object
     * @param distance set the distance of the Race object
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /***
     * Resets the position of the Hare and Tortoise to the original which is 0
     */
    public void reset() {
        getHare().setPosition(ORIGINAL_POSITION);
        getTortoise().setPosition(ORIGINAL_POSITION);
    }

    /***
     * Returns the winner's type (Hare or Tortoise)
     * @return the winner's type (Hare or Tortoise)
     */
    public String simulateRace() {
        //always reset the animals' positions to the original before simulating a race
        reset();
        return race();
    }

    /*
    Returns the winner (Hare or Tortoise) in a Race
     */
    private String race() {
        Random random = new Random();
        String winner = null;
        int timeUnit = INITIAL_TIME_UNIT;

        while (timeUnit < Integer.MAX_VALUE) {
            if (random.nextInt(BOOLEAN_BOUND_TO_DECIDE_FIRST_MOVE) == BOOLEAN_NUMBER_OF_HARE) {
                //Hare moves first and if its position after a move is over the race distance, it will win and the while loop ends
                if (getHare().move() >= getDistance()) {
                    winner = "Hare";
                    break;
                }

                if (getTortoise().move() >= getDistance()) {
                    winner = "Tortoise";
                    break;
                }
            } else {
                //Tortoise moves first and if its position after a move is over the race distance, it will win and the while loop ends
                if (getTortoise().move() >= getDistance()) {
                    winner = "Tortoise";
                    break;
                }
                if (getHare().move() >= getDistance()) {
                    winner = "Hare";
                    break;
                }
            }
            timeUnit++;
        }
        return winner + ". Race time: " + timeUnit + " clock ticks.";
    }

    /***
     * Overrides equals method to compares whether two Race objects are equal
     * @param o a general object to compare the Race object
     * @return whether two Race objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return distance == race.distance &&
                Objects.equals(hare, race.hare) &&
                Objects.equals(tortoise, race.tortoise);
    }

    /***
     * Overrides hashCode methods to returns a hashcode of the Race object
     * @return a hashcode of the Race object
     */
    @Override
    public int hashCode() {
        return Objects.hash(hare, tortoise, distance);
    }

    /***
     * Overrides toString method and returns the string representation of the Race object
     * @return the string representation of the Race object
     */
    @Override
    public String toString() {
        return "Race{" + "hare=" + hare + ", tortoise=" + tortoise + ", distance=" + distance + '}';
    }
}
