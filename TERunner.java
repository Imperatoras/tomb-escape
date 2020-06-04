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
         for(int x = 0; x < 15; x++){ //For some reason, the x and y are swapped. DON'T ASK.
           for(int y = 0; y < 15; y++){
             if(x == 0){ //populates the top, leaves exit gate
               if(y < 6 || y > 8){
                 addWall(x,y,world);
               }
             }
             if((y == 0 || y == 14)|| x == 14){ //populates the sides with barriers
               addWall(x,y,world);
             }
             if((y==4||y==10)&&(x<4)){ //makes goal zone vert walls
               addWall(x,y,world);
             }
             if(x==4&&((y>1&&y<7)||(y>7&&y<13))){ //makes goal zone horiz walls
               addWall(x,y,world);
             }
             if(x==6){ //Separates top and bottom zones
               if(y<4 || y>10){
                 addWall(x,y,world);
               }
               if(y>5 && y < 9){
                 addWall(x,y,world);
               }
             }
           }
         }
         Mummy agel = new Mummy();
         world.add(new Location(9,5),agel);
         world.show();
     }
     public static void addWall(int x, int y, ActorWorld world){ //cuts out repetitive code in if statements
       Wall a = new Wall(); //abusing a workaround for the "actor already added" error by refreshing
       world.add(new Location(x,y),a);
       a = new Wall();
     }
 }
