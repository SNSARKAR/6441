package lambdasinaction.chap2;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FilteringApplesTry {

	public static void main(String[] args){
		//list of apples
        List<Apple> listOfApples = Arrays.asList(new Apple(80, "green"), new Apple(100, "red"), new Apple(155, "green"), new Apple(120, "red"));
	   List<Apple>  redApples = filter(listOfApples,new ApplePredicateFilterByRed());
	   System.out.println(redApples);
	   
	   List<Apple>  greenApples = filter(listOfApples,new ApplePredicateFilterByGreen());
	   System.out.println(greenApples);
	   
	   List<Apple>  lightApples = filter(listOfApples,new ApplePredicateFilterByWeight());
	   System.out.println(lightApples);
	   
	   List<Apple>  heavyApples = filter(listOfApples,new ApplePredicateFilterByHeavyWeight());
	   System.out.println(heavyApples);
	   
	   List<Apple>  redAndLightApples = filter(listOfApples,new ApplePredicateFilterByRedAndWeight());
	   System.out.println(redAndLightApples);
	   
	}
	
	public static List<Apple> filter(List<Apple> listOfApples, ApplePredicate p){
		 
		List<Apple> result = new ArrayList<>();
		for(Apple a : listOfApples){
			if(p.test(a)){
			result.add(a);	
			}
		}
		
		return result;
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
interface ApplePredicate{
	public boolean test(Apple a);
}

static class ApplePredicateFilterByGreen implements ApplePredicate{
	public boolean test(Apple a){
		return "green".equals(a.getColor());
	}
}

static class ApplePredicateFilterByRed implements ApplePredicate{
	public boolean test(Apple a){
		return "red".equals(a.getColor());
	}
}

static class ApplePredicateFilterByWeight implements ApplePredicate{
	public boolean test(Apple a){
		return a.getWeight() <150 ;
	}
}

static class ApplePredicateFilterByHeavyWeight implements ApplePredicate{
	public boolean test(Apple a){
		return a.getWeight() >150 ;
	}
}

static class ApplePredicateFilterByRedAndWeight implements ApplePredicate{
	public boolean test(Apple a){
		return (a.getWeight() <150 && "red".equals(a.getColor())) ;
	}
}
}