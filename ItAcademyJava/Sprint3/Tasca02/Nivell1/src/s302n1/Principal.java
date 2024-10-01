package s302n1;

import s302n1.builders.PizzaBuilder;
import s302n1.pizza.Pizza;

public class Principal {

    public static void main(String[] args) {

        MaestroPizzero chef = new MaestroPizzero();

        PizzaBuilder builder = new PizzaBuilder();
        chef.cookPrimaveraPizza(builder);

        Pizza readyPizza = builder.getResult();
        System.out.println("Your " + readyPizza.getName() + " " + readyPizza.getPizzaType() + " is ready! \n");


    }
}
