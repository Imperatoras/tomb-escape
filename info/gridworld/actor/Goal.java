package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Goal extends Actor {

  public Goal() {
    setColor(null);
  }

  public void act()
  {
      if (getGrid() == null)
          return;
      ArrayList<Actor> actors = getActors();
      processActors(actors);
  }

  public ArrayList<Actor> getActors()
  {
      return getGrid().getNeighbors(getLocation());
  }

  public void processActors(ArrayList<Actor> actors)
  {
      for (Actor a : actors)
      {
          if (a instanceof Player)
              a.removeSelfFromGrid();
      }
  }

}
