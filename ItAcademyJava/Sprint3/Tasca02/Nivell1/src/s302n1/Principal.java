package s302n1;

import s302n1.builders.PizzaBuilder;
import s302n1.builders.PizzaRecipeBuilder;
import s302n1.pizza.Pizza;
import s302n1.pizza.Recipe;

public class Principal {

    public static void main(String[] args) {

        MaestroPizzero chef = new MaestroPizzero();

        PizzaBuilder builder = new PizzaBuilder();
        chef.cookPrimaveraPizza(builder);

        Pizza readyPizza = builder.getResult();
        System.out.println("Your " + readyPizza.getName() + " " + readyPizza.getPizzaType() + " is ready! \n");

        PizzaRecipeBuilder recipeBuilder = new PizzaRecipeBuilder();

        chef.cookPrimaveraPizza(recipeBuilder);
        Recipe pizzaRecipe = recipeBuilder.getResult();
        System.out.println("This is your pizza details: \n" + pizzaRecipe.recipePrint());

    }
}
