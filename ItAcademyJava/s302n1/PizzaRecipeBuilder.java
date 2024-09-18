package s302n1;


public class PizzaRecipeBuilder implements RecipeBuilder {

    private PizzaType pizzaType;
    private String name;
    private int size;
    private Dough dough;
    private Topping ingredients;

    public PizzaRecipeBuilder(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType){
        this.pizzaType = pizzaType;
    }



    public void setName(String name){
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
    public void setIngredients(Topping ingredients) {
        this.ingredients = ingredients;
    }

    public Recipe getResult() {
        return new Recipe(pizzaType, name, size, dough, ingredients);
    }
}
