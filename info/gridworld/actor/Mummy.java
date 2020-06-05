package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * A Mummy is an actor that can move in one direction
    and turn 180 degrees.
 */
public class Mummy extends Actor
{
    /**
     * Constructs a mummy
     */
    public Mummy()
    {
        setColor(null);
        int dir = (int)(Math.random() * 4) * 90;
        setDirection(dir);
        // set the direction randomly to either north, south, east, or west
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canMove())
            move();
        else
            turn();
    }

    public void turn()
    {
        setDirection(getDirection() + Location.HALF_CIRCLE);
    }

    /**
     * Moves the mummy forward.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }

    /**
     * Tests whether this Mummy can move forward into a location that is empty or
     * contains anything but a Wall.
     * @return true if this Mummy can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || !(neighbor instanceof Wall);
    }
}
