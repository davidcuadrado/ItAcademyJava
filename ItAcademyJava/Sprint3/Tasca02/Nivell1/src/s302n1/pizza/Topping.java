package s302n1.pizza;

import java.util.ArrayList;

public class Topping {

    private ArrayList<Ingredient> toppingList;
    private boolean vegan;

    public Topping(ArrayList<Ingredient> toppingList, boolean vegan) {
        this.toppingList = toppingList;
        this.vegan = vegan;
    }

    public ArrayList<Ingredient> getToppingList(){
        return toppingList;
    }

    public void addTopping(Ingredient ingredient){
        toppingList.add(ingredient);
    }

    public void removeTopping(Ingredient ingredient){
        toppingList.remove(ingredient);
    }

    public void setVegan() {
        vegan = true;
    }

    public void setNotVegan() {
        vegan = false;
    }

    public boolean getVegan(){
        return vegan;
    }

    public static boolean checkVegan(ArrayList<Ingredient> toppingList) {
        for (Ingredient ingredient : toppingList) {
            if (ingredient.toString().equalsIgnoreCase("CHEESE") ||
                    ingredient.toString().equalsIgnoreCase("CHICKEN") ||
                    ingredient.toString().equalsIgnoreCase("MEAT")) {
                return false;
            }
        }
        return true;

    }

    public String toString(){

        if (vegan){
            return toppingList + " [vegan] ";
        } else {
            return toppingList.toString();
        }
    }


}
