package designPatterns.Facade;

/**
 * https://www.youtube.com/watch?v=sNjk-9FoiaE&list=PLJN9ydlFnJsi6-lev2fQ2f1X7YD-VPQVW&index=7
 */
public class Laptop {
    public static void main(String[] args) {
        LaptopOnSwitch laptopOnSwitch = new LaptopOnSwitch();
        laptopOnSwitch.switchOnLaptop();
    }
}
