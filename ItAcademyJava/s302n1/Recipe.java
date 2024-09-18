package s302n1;


public class Recipe {
    private PizzaType pizzaType;
    private String name;
    private int size;
    private Dough dough;
    private Topping ingredients;

    Recipe(PizzaType pizzaType, String name, int size, Dough dough, Topping ingredients) {
        this.pizzaType = pizzaType;
        this.name = name;
        this.size = size;
        this.dough = dough;
        this.ingredients = ingredients;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public String getName() {
        return this.name;
    }

    public String recipePrint() {
        return "Pizza " + name + "\n with " + ingredients.toString() + " on "+ dough + size + " centimeter dough. ";

    }
}
