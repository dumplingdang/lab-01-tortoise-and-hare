package ca.bcit.comp2522.lab01;

import java.util.Random;

/***
 * This class describe a Tortoise in a race
 *
 * @author Jianfen Deng
 * @version 1.0
 */
public class Tortoise {
    /**
     * The original position of the Tortoise in a race is {@value}
     */
    public static final int ORIGINAL_POSITION = 0;

    /***
     *  The units that the Tortoise moves forward with a fast plod is {@value}
     */
    public static final int FAST_PLOD_UNITS = 4;

    /***
     *  The unit that the Tortoise moves forward with a slow plod is {@value}
     */
    public static final int SLOW_PLOD_UNITS = 1;

    /***
     *  The random bound to determine a chance of a move is {@value}
     */
    public static final int RANDOM_BOUND = 101;

    /***
     *  The chance bound that the Tortoise takes a fast plod is {@value}
     */
    public static final int CHANCE_BOUND_OF_A_FAST_PLOD = 90;

    private int position;

    /***
     * Initializes an object of a Tortoise class
     */
    public Tortoise() {
        this.position = ORIGINAL_POSITION;
    }

    /***
     * Returns the Tortoise's position
     * @return the Tortoise's position
     */
    public int getPosition() {
        return position;
    }

    /***
     * Sets the Tortoise's position
     * @param position the Tortoise's position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /***
     * Returns the Tortoise's position after a move
     * @return the Tortoise's position after a move
     */
    public int move() {
        Random random = new Random();
        int chance = random.nextInt(RANDOM_BOUND);
        int units = SLOW_PLOD_UNITS;

        if (chance < CHANCE_BOUND_OF_A_FAST_PLOD) //90% of chance
        {
            units = FAST_PLOD_UNITS;
        }

        return this.position += units;
    }

    /***
     * Overrides toString method and returns the string representation of the Tortoise object
     * @return the string representation of the Tortoise object
     */
    @Override
    public String toString() {
        return "Tortoise{" +
                "position=" + position +
                '}';
    }

    /***
     * Overrides equals method to compares whether two Tortoise objects are equal
     * @param o a general object to compare the Tortoise object
     * @return whether two Tortoise objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Tortoise))
            return false;

        Tortoise tortoise = (Tortoise) o;

        if (getPosition() != tortoise.getPosition())
            return false;

        return true;
    }

    /***
     *  * Overrides hashCode methods to returns a hashcode of the Tortoise object with a specific position
     * @return a hashcode of the Tortoise object with a specific position
     */
    @Override
    public int hashCode() {
        return getPosition();
    }
}
