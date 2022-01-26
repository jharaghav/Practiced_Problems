package designPatterns.Decorator;

/**
 * Decorator Abstract class for providing the functionality to add the ingredients on run time
 * without effecting the current functionality
 */
public abstract class IngredientDecorator extends Beverage {
    abstract String getBeverageName();
}
