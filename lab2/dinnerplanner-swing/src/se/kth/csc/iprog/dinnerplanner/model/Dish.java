package se.kth.csc.iprog.dinnerplanner.model;

import java.util.HashSet;
import java.util.Set;

public class Dish {
	
	public static final int STARTER = 1;
	public static final int MAIN = 2;
	public static final int DESERT = 3;
	
	String name;
	int type; // starter (1), main (2) or desert (3)  
	String image;
	String description;
    double price;
	
	Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	public Dish(String name, int type, String image, String description) {
		this.name = name;
		this.type = type;
		this.image = image;
		this.description = description;
        price = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

    /**
     * Gives you the type of the dish in text. Used to see what dish it is in an easy way.
     *
     * @return String the type of the dish in text.
     */
    public String getTypeText() {
        String tempString;
        switch (type) {
            case 1: tempString =  "Starter"; break;
            case 2: tempString =  "Main"; break;
            case 3: tempString =  "Dessert"; break;
            default: tempString =  "Unknown type"; break;
        }
        return tempString;
    }

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Ingredient> getIngredients(){
		return ingredients;
	}
	
	public void addIngredient(Ingredient ing){
		ingredients.add(ing);
        calculatePrice();
	}
	
	public void removeIngredient(Ingredient ing){
		ingredients.remove(ing);
        calculatePrice();
	}

    public double getPrice() {
        return price;
    }
	
	public boolean contains(String filter){
		if(name.toLowerCase().contains(filter.toLowerCase())){
			return true;
		}
		for(Ingredient i : ingredients){
			if(i.getName().toLowerCase().contains(filter.toLowerCase())){
				return true;
			}
		}
		return false;
	}

    private void calculatePrice() {
        double sum = 0;
        for(Ingredient i : ingredients){
            sum += i.getPrice();
        }
        price = sum;
    }
}
