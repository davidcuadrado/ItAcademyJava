package s302n1.pizza;


public class Recipe {
    private final PizzaType pizzaType;
    private final String name;
    private final int size;
    private final Dough dough;
    private final Topping topping;

    public Recipe(PizzaType pizzaType, String name, int size, Dough dough, Topping topping) {
        this.pizzaType = pizzaType;
        this.name = name;
        this.size = size;
        this.dough = dough;
        this.topping = topping;
    }

    public String recipePrint() {
        return "Pizza " + name + " [" + pizzaType + "] \n with " + topping.toString() + " on " + size + " centimeter " + dough + " dough. ";


    }
}
