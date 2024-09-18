package s302n1;

import java.util.ArrayList;

public class PizzaBuilder implements RecipeBuilder {

    private PizzaType pizzaType;
    private String name;
    private int size;
    private Dough dough;
    private Topping ingredients;


    @Override
    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }


    public void setDough(Dough dough) {
        this.dough = dough;
    }

    @Override
    public void setIngredients(Topping ingredients) {
        this.ingredients = ingredients;
    }

    public Pizza getResult() {
        return new Pizza(pizzaType, name, size, dough, ingredients);
    }
}
