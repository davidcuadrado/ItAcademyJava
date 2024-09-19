package s302n1;


import java.util.ArrayList;

public class PizzaRecipeBuilder implements RecipeBuilder {

    private PizzaType pizzaType;
    private String name;
    private int size;
    private Dough dough;
    private Topping ingredients;


    PizzaRecipeBuilder(){}

    public void PizzaRecipeBuilder(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

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

    @Override
    public void setDough(Dough dough) {
        this.dough = dough;
    }

    @Override
    public void setTopping(Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3) {

        ArrayList<Ingredient> toppingList = new ArrayList<Ingredient>();
        toppingList.add(ingredient1);
        toppingList.add(ingredient2);
        toppingList.add(ingredient3);

        boolean vegan = Topping.checkVegan(toppingList);
        this.ingredients = new Topping(toppingList, vegan);

    }

    public Recipe getResult() {
        return new Recipe(pizzaType, name, size, dough, ingredients);
    }
}
