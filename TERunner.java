/*
  * AP(r) Computer Science GridWorld Case Study:
  * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
  *
  * This code is free software; you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation.
  *
  * This code is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @author Cay Horstmann
  */

 import info.gridworld.actor.ActorWorld;
 import info.gridworld.actor.Wall;
 import info.gridworld.grid.Location;
 import info.gridworld.actor.Mummy;

 /**
  * This class runs a world that contains a bug and a rock, added at random
  * locations. Click on empty locations to add additional actors. Click on
  * populated locations to invoke methods on their occupants. <br />
  * To build your own worlds, define your own actors and a runner class. See the
  * BoxBugRunner (in the boxBug folder) for an example. <br />
  * This class is not tested on the AP CS A and AB exams.
  */
 public class TERunner
 {

     public static void main(String[] args)
     {
         ActorWorld world = new ActorWorld();
         for(int x = 0; x < 10; x++){
           for(int y = 0; y < 10; y++){
             if(x == 0){ //populates the top, leaves exit gate
               if(y < 4 || y > 5){
                 addWall(x,y,world);
               }
             }
             if((y == 0 || y == 9)|| x == 9){ //populates the sides with barriers
               addWall(x,y,world);
             }
             if((y == 2 && x < 5)||(y == 7 && x < 5)){ //creates first 2 partitions around goal
               addWall(x,y,world);
             }
             if((x==4 && (y > 2 && y < 4))||(x==4 && (y>5 && y<7))){ //further delineates goal room
               addWall(x,y,world);
             }
             if(x==6 && y<8){ //splits main hallway from aux hallway
               addWall(x,y,world);
             }
             if(x==7 && (y%4==3 && y<8)){//ziggity zaggity!
               addWall(x,y,world);
             }
             if(x==8 && (y%4==1 && y<8)){ //more zig zag zug
               addWall(x,y,world);
             }
           }
         }
         Mummy agel = new Mummy();
         world.add(new Location(5,5),agel);
         world.show();
     }
     public static void addWall(int x, int y, ActorWorld world){ //cuts out repetitive code in if statements
       Wall a = new Wall(); //abusing a workaround for the "actor already added" error by refreshing
       world.add(new Location(x,y),a);
       a = new Wall();
     }
 }
