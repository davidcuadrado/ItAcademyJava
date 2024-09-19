package s302n1;

public class Principal {

    public static void main(String[] args) {

        MaestroPizzero chef = new MaestroPizzero();

        //

        PizzaBuilder builder = new PizzaBuilder();
        chef.cookPrimaveraPizza(builder);

        //

        Pizza readyPizza = builder.getResult();
        System.out.println("Your " + readyPizza.getName() + " " + readyPizza.getPizzaType() + " is ready! ");

        //

        PizzaRecipeBuilder recipeBuilder = new PizzaRecipeBuilder();

        chef.cookPrimaveraPizza(recipeBuilder);
        Recipe pizzaRecipe = recipeBuilder.getResult();
        System.out.println("This is your pizza composition: \n" + pizzaRecipe.recipePrint());

    }
}
