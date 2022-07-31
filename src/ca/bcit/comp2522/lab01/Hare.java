package ca.bcit.comp2522.lab01;

import java.util.Objects;
import java.util.Random;

/***
 * This class describes a Hare in a race
 *
 * @author Jianfen Deng
 * @version 1.0
 */
public class Hare {
    /***
     * The original position of a Hare in a race is {@value}
     */
    public static final int ORIGINAL_POSITION = 0;

    /***
     * The move unit representing a Hare doesn't move is {@value}
     */
    public static final int MIN_MOVE_UNIT = 0;

    /***
     * The move units representing a Hare takes a big hop is {@value}
     */
    public static final int BIG_HOP_UNITS = 9;

    /***
     * The move units representing a Hare suffers a big slip is {@value}
     */
    public static final int BIG_SLIP_UNITS = -12;

    /***
     * The move unit representing a Hare takes a small hop is {@value}
     */
    public static final int SMALL_HOP_UNIT = 1;

    /***
     * The move units representing a Hare suffers a small slip is {@value}
     */
    public static final int SMALL_SLIP_UNITS = -2;

    /***
     * The random bound to determine a chance of a move is {@value}
     */
    public static final int RANDOM_BOUND = 101;

    /***
     * The chance bound that the Hare sleep and doesn't move is {@value}
     */
    public static final int CHANCE_BOUND_OF_NO_MOVE = 20;

    /***
     * The chance bound that the Hare take a big hop is {@value}
     */
    public static final int CHANCE_BOUND_OF_BIG_HOP = 50;

    /***
     * The chance bound that the Hare suffers a big slip is {@value}
     */
    public static final int CHANCE_BOUND_OF_BIG_SLIP = 60;

    /***
     * The chance bound that the Hare takes a small hop is {@value}
     */
    public static final int CHANCE_BOUND_OF_SMALL_HOP = 90;
    private int position;

    /***
     * Initializes an object of a Hare class
     */
    public Hare() {
        this.position = ORIGINAL_POSITION;
    }

    /***
     * Returns the Hare's position
     * @return the Hare's position
     */
    public int getPosition() {
        return position;
    }

    /***
     * Sets the Hare's position
     * @param position the hare's position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /***
     * Returns the Hare's position after a move
     * @return the Hare's position after a move
     */
    public int move() {
        Random random = new Random();
        int chance = random.nextInt(RANDOM_BOUND);
        int units = SMALL_SLIP_UNITS;

        if (chance < CHANCE_BOUND_OF_NO_MOVE) { //20% of chance
            units = MIN_MOVE_UNIT;
        } else if (chance < CHANCE_BOUND_OF_BIG_HOP) { //30% of chance
            units = BIG_HOP_UNITS;
        } else if (chance < CHANCE_BOUND_OF_BIG_SLIP) { //10% of chance
            units = BIG_SLIP_UNITS;
        } else if (chance < CHANCE_BOUND_OF_SMALL_HOP) { //30% of chance
            units = SMALL_HOP_UNIT;
        }
        return this.position += units;
    }

    /***
     * Overrides equals method to compare whether two Hare objects are equal
     * @param o a general object to compare to the Hare object
     * @return whether the two Hare objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hare hare = (Hare) o;
        return position == hare.position;
    }

    /***
     * Overrides hashCode method and returns the Hare's hashCode
     * @return a hashcode of a Hare object with a specific position
     */
    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    /***
     * Override toString method and returns a string representation of the Hare object
     * @return a string representation of the Hare object with a specific position
     */
    @Override
    public String toString() {
        return "Hare{" + "position=" + position + '}';
    }
}
