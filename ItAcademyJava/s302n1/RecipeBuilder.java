package s302n1;

import java.util.ArrayList;

public interface RecipeBuilder {

    void setPizzaType(PizzaType pizzaType);

    void setName(String name);

    void setSize(int size);

    void setDough(Dough dough);

    void setIngredients(Topping ingredients);
}


