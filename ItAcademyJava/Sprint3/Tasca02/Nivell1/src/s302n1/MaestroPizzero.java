package s302n1;

import s302n1.builders.RecipeBuilder;
import s302n1.pizza.Dough;
import s302n1.pizza.Ingredient;
import s302n1.pizza.PizzaType;

public class MaestroPizzero {

    public void cookPrimaveraPizza(RecipeBuilder recipeBuilder){
        recipeBuilder.setPizzaType(PizzaType.PRIMAVERA);
        recipeBuilder.setName("Vivaldi");
        recipeBuilder.setSize(24);
        recipeBuilder.setDough(Dough.NEAPOLITAN);
        recipeBuilder.setTopping(Ingredient.TOMATO, Ingredient.CHEESE, Ingredient.MUSHROOM);
    }

    public void cookAutunnoPizza(RecipeBuilder recipeBuilder){
        recipeBuilder.setPizzaType(PizzaType.AUTUNNO);
        recipeBuilder.setName("Fogliame");
        recipeBuilder.setSize(42);
        recipeBuilder.setDough(Dough.DETROIT);
        recipeBuilder.setTopping(Ingredient.CHICKEN, Ingredient.PEPPER, Ingredient.ONION);
    }

    public void cookInvernoPizza(RecipeBuilder recipeBuilder){
        recipeBuilder.setPizzaType(PizzaType.INVERNO);
        recipeBuilder.setName("Santa Klaus");
        recipeBuilder.setSize(64);
        recipeBuilder.setDough(Dough.NEAPOLITAN);
        recipeBuilder.setTopping(Ingredient.TOMATO, Ingredient.ONION, Ingredient.OLIVE);
    }
}