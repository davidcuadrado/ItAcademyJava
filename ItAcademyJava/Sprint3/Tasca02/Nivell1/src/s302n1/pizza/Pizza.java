package s302n1.pizza;


public class Pizza {
    private final PizzaType pizzaType;
    private final String name;
    private final int size;
    private final Dough dough;
    private final Topping ingredients;

    public Pizza(PizzaType pizzaType, String name, int size, Dough dough, Topping ingredients) {
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
        return name;
    }

    public int getSize() {
        return size;
    }

    public Dough getDough() {
        return dough;
    }

    public Topping getIngredients() {
        return ingredients;
    }
}
