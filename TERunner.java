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
 import info.gridworld.actor.*;

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
         System.out.println("\tTOMB ESCAPE - By Helena Williams, Diya Mohan, and Jubayer Ahmed");
         System.out.println("\tSTORY:");
         System.out.println("\nYou\'ve finally done it. After months of searching, you\'ve found the lost tomb of the great pharaoh Akhmenad the Fifth! You carefully pry the slab covering the entrance away with your crowbar and turn on your flashlight. The hallway beyond is long, made of sandstone bricks, and covered in ancient hieroglyphs, which are eroded and illegible. Torches, which have long since burnt out, are mounted every few feet.");
         System.out.println("\nYou carefully enter the tomb and begin to walk down the hallway, only to startle in fright when you see two eyes shimmering in the darkness! Yet when you turn the beam of your flashlight onto it, it\'s only the gemstones embedded into the eye sockets of a sphinx, which are a beautiful blue color. You briefly consider prying the eyes out - after all, they\'d sell for a fortune - but something about it doesn\'t feel right.");
         System.out.println("\nSphinx encounter over, you begin to search the tomb. Its dusty halls are filled with mummies - most likely the servants of the pharaoh, embalmed so that they would serve him in the afterlife. Some of them have fallen from their plinths and lie on the ground in contorted positions. Yet strangely enough, they appear to be wearing the uniforms of British army officers from the 19th century. Why would they be in a tomb like this?");
         System.out.println("\nYou brush aside your concerns and continue deeper into the tomb. And after a little more searching, you find something incredible - a statuette of the god Anubis! The statuette is in pristine condition, and ornamented with gold and jewels. Eagerly, you reach out and delicately lift the statuette from its plinth, excited to present it to the world.");
         System.out.println("\nYet the second you do, a great flash of red light causes you to cover your eyes. The sandstone floor rumbles beneath your feet. And suddenly, the tomb\'s hieroglyphs begin to glow a bright red.");
         System.out.println("\nAnd with that, those mummies are picking themselves off the floor and eyeing you menacingly. The sphinxes rise as well, and you realize that the gemstones in their eyes are now glowing red. One of them opens its mouth, and suddenly the air begins to heat up. A fireball comes roaring out of the sphinx\'s throat, and you fling yourself to the ground as it passes above you.");
         System.out.println("\nIt\'s clear now that you\'re in dire straits. If you don\'t escape from this tomb, and fast, you\'ll be joining the mummies!");
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
               if((y<4 || y>10)||(y>5 && y<9)){
                 addWall(x,y,world);
               }
             }
             if(x==11){//creates player room at bottom
               if(y>2){
                 addWall(x,y,world);
               }
             }
             if(x==8 && y<12){
               addWall(x,y,world);
             }
             //wall of sphinxes at bottom
             if(x==11 && (y%3==0 && y>2)){
               addSphinx(x,y,world);
             }
             //cube filled with MUMMIESSSSS
             if((x>0 && x<4) && (y>0 && y<4)){
               addMummy(x,y,world);
             }

           }
           //mummy generation
           addMummy(12,1,world);
           addMummy(12,2,world);
           addMummy(5,1,world);
           addMummy(7,1,world);
           //sphinx generation
           addSphinx(4,4,world);
           addSphinx(4,10,world);
         }
         //add player last
         Player you = new Player();
         world.add(new Location(13,13),you);
         ActorWorld.selected = you.getLocation();
         world.show();
     }
     public static void addWall(int x, int y, ActorWorld world){ //cuts out repetitive code in if statements
       Wall a = new Wall(); //abusing a workaround for the "actor already added" error by refreshing
       world.add(new Location(x,y),a);
       a = new Wall();
     }

     public static void addMummy(int x, int y, ActorWorld world){
       Mummy a = new Mummy();
       world.add(new Location(x,y),a);
       a = new Mummy();
     }
     public static void addSphinx(int x, int y, ActorWorld world){
       Sphinx a = new Sphinx();
       world.add(new Location(x,y),a);
       a = new Sphinx();
     }
 }
