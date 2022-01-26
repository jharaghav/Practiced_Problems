package designPatterns.Decorator;

/**
 * https://www.youtube.com/watch?v=3rI5n2hwz2o&list=PLJN9ydlFnJsi6-lev2fQ2f1X7YD-VPQVW&index=5
 */
public class CoffeeHouse {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getBeveragePrice());
        beverage = new Milk(beverage);
        System.out.println("after decorating with milk");
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getBeveragePrice());
        beverage = new Caramel(beverage);
        beverage = new Caramel(beverage);
        System.out.println("after decorating with double caramel");
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getBeveragePrice());
    }
}
