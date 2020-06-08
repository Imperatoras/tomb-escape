//*************import stuff*******************

public class Player extends Actor {
  private int health;

  public Player () {
    health = 3;                                    //necessary attributes?
  }

  public boolean canMove (Location loc) {
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return false;
    if (!gr.isValid(loc))
        return false;
    Actor neighbor = gr.get(loc);
    return !(neighbor == Wall);
  }

  public int getHealth () {
    return health;
  }

  public void up () {                             //moves up
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(NORTH);
    if (canMove(next)) {
      moveTo(next);
    }
  }

  public void down () {                             //moves down
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(SOUTH);
    if (canMove(next)) {
      moveTo(next);
    }
  }

  public void left () {                             //moves to the left
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(WEST);
    if (canMove(next)) {
      moveTo(next);
    }
  }

  public void right () {                             //moves to the right
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
