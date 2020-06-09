package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

public class Player extends Actor {
  private int health;
  private int keys;

  public Player () {
    setColor(null);                                    //necessary attributes?
    health = 3;
    keys = 0;
  }

  public void act () {
    if (getGrid() == null)
        return;
    ArrayList<Actor> enemies = getEnemies();
    if (getHealth() == 0)
      removeSelfFromGrid();
    changeHealth(enemies);  
  }

  public boolean canMove (Location loc) {               //Makes sure there arent walls
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return false;
    if (!gr.isValid(loc))
        return false;
    Actor neighbor = gr.get(loc);
    return !(neighbor == Wall);
  }

  public int getHealth () {                             //self-explanatory
    return health;
  }

  public void setHealth (int num) {
    health = num;
  }

  public ArrayList<Actor> getEnemies() {                //gets enemies in surrounding cells
      return getGrid().getNeighbors(getLocation());
  }

  public void changeHealth(ArrayList<Actor> actors) {
      int temp = getHealth();
      for (Actor a : actors) {
          if (!(a instanceof Wall))
            temp--;
      }
      setHealth(temp);
  }

  public void up () {                                   //moves up
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(NORTH);
    if (canMove(next)) {
      moveTo(next);
    }
  }

  public void down () {                                 //moves down
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(SOUTH);
    if (canMove(next)) {
      moveTo(next);
    }
  }

  public void left () {                                 //moves to the left
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(WEST);
    if (canMove(next)) {
      moveTo(next);
    }
  }

  public void right () {                                //moves to the right
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(EAST);
    if (canMove(next)) {
      moveTo(next);
    }
  }


}
