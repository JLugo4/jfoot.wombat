package com.github.curriculeon.jfoot;


import com.github.git_leon.RandomUtils;


import static com.github.curriculeon.jfoot.Direction.*;


/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Herbivore {
    public Wombat() {
        setImage("wombat.png");
    }


    public void act() {
        if (this.foundLeaf()) { // if leaf found eat it.
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move(); // if no leaf found move
        } else {
            if (getDirection() == EAST){
                this.turnLeft(); // if no leaf and can move, turn left.
                this.move();
                this.turnLeft();
            } else {
                if (getDirection() == WEST)
                    turnRight();
                this.move();
                turnRight();
            }
        }
    }


// public void turnRight(){
// turnLeft();
// turnLeft();
// turnLeft();
// }


    private boolean isAtTopLeft() {
        return !canMove(WEST) && !canMove(NORTH);
    }


    private boolean canMove(Direction direction){
        Direction originalDirection = getDirection();
        setDirection(direction);
        boolean canMove = canMove();
        setDirection(originalDirection);
        return canMove;
    }




    public void turnRight() {
        if (this.getDirection() == WEST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == EAST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(EAST);
        } else {
            this.setDirection(WEST);
        }
    }




    public void turnLeft() {
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
    }
}

