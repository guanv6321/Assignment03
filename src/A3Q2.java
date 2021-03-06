
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guanv6321
 */
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City kw = new City();
        Robot karel = new Robot(kw, 1, 1, Direction.EAST);
        new Wall(kw, 1, 1, Direction.WEST);
        new Wall(kw, 1, 1, Direction.NORTH);
        new Wall(kw, 1, 2, Direction.NORTH);
        new Wall(kw, 1, 3, Direction.NORTH);
        new Wall(kw, 1, 4, Direction.NORTH);
        new Wall(kw, 1, 4, Direction.EAST);
        new Wall(kw, 2, 4, Direction.EAST);
        new Wall(kw, 3, 4, Direction.EAST);
        new Wall(kw, 3, 4, Direction.SOUTH);
        new Wall(kw, 3, 3, Direction.SOUTH);
        new Wall(kw, 3, 2, Direction.SOUTH);
        new Wall(kw, 3, 1, Direction.SOUTH);
        new Wall(kw, 3, 1, Direction.WEST);
        new Wall(kw, 2, 1, Direction.WEST);
        new Thing(kw, 1, 2);
        new Thing(kw, 2, 2);
        new Thing(kw, 2, 3);
        new Thing(kw, 2, 4);
        new Thing(kw, 3, 4);
        new Thing(kw, 3, 1);

        while (true) {
            if (karel.frontIsClear()) {
                karel.move();
                if (karel.getAvenue() == 1 && karel.getStreet() == 2) {
                    karel.turnLeft();
                    karel.turnLeft();
                    karel.turnLeft();

                }
                if (karel.canPickThing()) {
                    karel.pickThing();
                }
                if (!karel.frontIsClear() && karel.countThingsInBackpack() < 6) {
                    karel.turnLeft();
                    karel.turnLeft();
                    karel.turnLeft();

                }
                if (karel.countThingsInBackpack() == 6 && karel.getAvenue() != 1) {
                    karel.turnLeft();
                    karel.move();
                    if (karel.getStreet() == 1 && karel.getDirection() == Direction.NORTH) {
                        karel.turnLeft();

                    }
                    if (karel.frontIsClear()) {
                        karel.move();
                    }

                }

            }
            if (!karel.frontIsClear() && karel.getAvenue() == 1 && karel.getStreet() == 1) {
                break;
            }
        }
        karel.turnLeft();
        karel.turnLeft();
    }
}
