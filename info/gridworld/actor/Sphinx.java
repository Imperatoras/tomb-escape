package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * A Sphinx is an actor that sits in one place and launches Fire.
 */
public class Sphinx extends Actor
{
    private int actCount;
    private int fireSpeed;

    /**
     * Constructs a Sphinx
    */
    public Sphinx()
    {
        setColor(null);
        direct()
        actCount = 0;
        fireSpeed = 10;
    }

    public void direct()
    {
      int dir = (int)(Math.random() * 2) * 180;
      setDirection(dir);
      // set the direction randomly to either east or west

      Grid<Actor> gr = getGrid();
      Location loc = getLocation();
      Location next = loc.getAdjacentLocation(getDirection());
      if (gr.get(next) instanceof Wall) {
        dir = Math.abs(dir - 180);
        setDirection(dir);
      }
      // if the Sphinx is facing a wall, turn it the other way
    }

    public int getFireSpeed()
    {
      return fireSpeed;
    }

    public void setFireSpeed(int speed)
    {
      fireSpeed = speed;
    }

    /**
     * launches fire intermittently: when actCount is a multiple of fireSpeed
     */
    public void act()
    {
      Grid<Actor> gr = getGrid();
      Location loc = getLocation();
      Location next = loc.getAdjacentLocation(getDirection());
      if (actCount % fireSpeed == 0) {
        Fire fire = new Fire(getDirection());
        fire.putSelfInGrid(gr, next);
      }
      actCount++;
    }


}
