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
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    ArrayList<Actor> enemies = getEnemies();
    if (getHealth() == 0) {
      for(int x = 0; x < 15; x++){
        for(int y = 0; y < 15; y++){
          Location tile = new Location(x,y);
          Skull a = new Skull();
          a.putSelfInGrid(gr, tile);
        }
      }
    }
    for(int a=6; a<9; a++){ //if player in win zone
      Location winLoc = new Location(0,a);
      if(gr.get(winLoc) instanceof Player){
        for(int x = 0; x < 15; x++){
          for(int y = 0; y < 15; y++){
            Location tile = new Location(x,y);
            Anubis anu = new Anubis();
            anu.putSelfInGrid(gr, tile);
          }
        }
      }
    }
    changeHealth(enemies);
  }

  public boolean canMove (Location loc) {               //Makes sure there arent walls
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return false;
    if (!gr.isValid(loc))
        return false;
    Actor neighbor = gr.get(loc);
    return !(neighbor instanceof Wall);
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
          if (a instanceof Mummy)
            temp--;
      }
      setHealth(temp);
      System.out.println("You now have " + temp + " lives left!");
  }

  public void up () {                                   //moves up
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(Location.NORTH);
    if (canMove(next)) {
      moveTo(next);
    }
  }

  public void down () {                                 //moves down
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(Location.SOUTH);
    if (canMove(next)) {
      moveTo(next);
    }
  }

  public void left () {                                 //moves to the left
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(Location.WEST);
    if (canMove(next)) {
      moveTo(next);
    }
  }

  public void right () {                                //moves to the right
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(Location.EAST);
    if (canMove(next)) {
      moveTo(next);
    }
  }


}
