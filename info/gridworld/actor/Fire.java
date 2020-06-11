package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * Fire is an actor that moves its original direction until coming
 into contact with another actor or leaving the grid; it then removes itself.
 */
public class Fire extends Actor {

  /* Constructs a Fire object*/
  public Fire(int direction)
  {
    setColor(null);
    setDirection(direction);
  }

  /* moves if can move otherwise removes self from grid */
  public void act()
  {
      if (getGrid() == null)
          return;
      ArrayList<Actor> actors = getActors();
      processActors(actors);
      if (canMove())
          move();
      else
          removeSelfFromGrid();
  }

  public ArrayList<Actor> getActors()
  {
      return getGrid().getNeighbors(getLocation());
  }

  public void processActors(ArrayList<Actor> actors)
  {
      for (Actor a : actors)
      {
          if (!(a instanceof Wall))
              removeSelfFromGrid();
      }
  }

  /**
   * Moves the fire forward.
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
   * Tests whether this Fire can move forward into a location that is empty or
   * contains anything but a Wall.
   * @return true if this Fire can move.
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
