package s302n1.builders;

import s302n1.pizza.Dough;
import s302n1.pizza.Ingredient;
import s302n1.pizza.PizzaType;

public interface RecipeBuilder {

    void setPizzaType(PizzaType pizzaType);

    void setName(String name);

    void setSize(int size);

    void setDough(Dough dough);

    void setTopping(Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3);
}


