package lambdasinaction.chap2;

import java.util.List;

import java.util.Arrays;



public class Task3 {
	
	public static void main(String[] args){
		List<Apple> listOfApples = Arrays.asList(new Apple(80, "green"), new Apple(100, "red"), new Apple(155, "green"), new Apple(120, "red"),new Apple(220, "red"));
		
		//only weight
		Task3 t = new Task3();
		 prettyPrintApple(listOfApples,t.new PrintWeightFormatter());
		 prettyPrintApple(listOfApples,t.new PrintHeavyOrLightWeightFormatter());
	}
	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter form){
	    for(Apple apple: inventory) {
		String output = form.accept(apple);
		System.out.println(output);
	    }
	}
	

public static class Apple{
	private int weight = 0;
	private String color = "";
	
	public Apple(int weight , String color){
		this.weight = weight;
		this.color = color;
	}
	
	public int getWeight(){
		return weight;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}	
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color = color;
	}	
	public String toString() {
		return "Apple{" +
				"color='" + color + '\'' +
				", weight=" + weight +
				'}';
	}
}
//predicates with variations
interface AppleFormatter{
	public String accept(Apple a);
}

public class PrintWeightFormatter implements AppleFormatter{
	public String accept(Apple a){
		String s = "Weigth of the Apple :" + a.getWeight();
		return s;
	}
}
public class PrintHeavyOrLightWeightFormatter implements AppleFormatter{
	public String accept(Apple a){
		String characteristic = a.getWeight()>150 ?"heavy" : "light" ;
		String s = "An " +characteristic+" Apple of weight : "+ a.getWeight() + " and color :" + a.getColor();
		return s;
	}
}
}
