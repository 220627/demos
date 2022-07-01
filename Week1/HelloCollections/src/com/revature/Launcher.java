package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

import com.revature.models.Pokemon;

//Collection are similar to Arrays, in that they are objects that hold data. BUT there a few key differences
//Collections are DYNAMICALLY SIZED, which means we can change their size, unlike with Arrays.
//Collections can only hold objects (how do we store primitives? wrapper classes!)
public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("===========================================(Lists)");
		
		//ArrayLists are very common implementations of the List Interface
		//QC asked me the difference between Arrays and ArrayLists back in the day
		
		//Make an ArrayList of Pokemon objects
		ArrayList<Pokemon> myPokemonList = new ArrayList(); //This is an empty ArrayList which we'll fill below
		
		//.add() method lets us add elements to our ArrayList
		//I'm going to create new Pokemon objects within the add() method itself. We could created them first and add them too
		myPokemonList.add(new Pokemon("Charmander", "Fire"));
		myPokemonList.add(new Pokemon("Piplup", "Water"));
		myPokemonList.add(new Pokemon("Snorlax", "Normal"));
		myPokemonList.add(new Pokemon("Sableye", "Ghost"));
		myPokemonList.add(new Pokemon("Rattata", "Normal"));
		myPokemonList.add(new Pokemon("Rattata", "Normal")); //Lists can contain duplicates!
		
		//attempt to print myPokemonList
		System.out.println(myPokemonList);
		
		//what is we want each Pokemon printed on a new line? Valid cause it'll look cleaner
		//consider the forEach() method!
		myPokemonList.forEach(pokemon -> System.out.println(pokemon));
		//"FOR EACH object in myPokemonList (which we'll call "pokemon", execute some code".
		//forEach works similarly to an enhanced for loop, but it's made specifically for collections
		//why is pokemon lowercase? that's simply the name we're giving it. It could be "p" for instance.
		
		//.get(index) is how we can retrieve a value from the ArrayList
		System.out.println("The Pokemon at index 3 is: " + myPokemonList.get(3));
		
		//definitely look into other List methods, there are a lot of cool ones, but these are the three we'll use often
		//look into remove() which takes elements out, and size() which returns the length of the ArrayList
		
		System.out.println("===========================================(Sets)");
		
		//Instantiate an empty HashSet of Pokemon objects, which is a general use common Set you may see.
		HashSet<Pokemon> myPokemonSet = new HashSet<>(); //as we saw above the empty <> isn't necessary, but I like to add it
		
		//add some Pokemon into my HashSet
	    Pokemon charmander = new Pokemon("Charmander", "Fire");
		Pokemon rattata = new Pokemon("Rattata", "Normal");

		myPokemonSet.add(charmander);
		myPokemonSet.add(charmander); //SETS DO NOT ALLOW DUPLICATES. Java will let you try though...
		myPokemonSet.add(rattata);
		
		//print out the set, notice the lack of duplicate charmander
		//also notice the lack of any strict order. Rattata prints before Charmander despite Charmander being added first 
		myPokemonSet.forEach(pokemon -> System.out.println(pokemon));
		
		//.contains() returns a boolean of true if the Set contains the specified object
		if(myPokemonSet.contains(charmander)) {
			System.out.println("Charmander exists in the Set and used flamethrower!!");
		}
		
		System.out.println("===========================================(Maps)");
		
		//Instantiate a TreeMap, which is the common general use map
		//This TreeMap takes an Integer for the key, and a Pokemon for the value
		TreeMap<Integer, Pokemon> pokeMap = new TreeMap<>();
		
		//Why are we using Integer, and not int?
		//Maps and Collections can only use Objects! We have to use WRAPPER CLASSES for primitives
		//Basically, every primitive has a Class version for when we need objects. For instance in Collections
		
		//use the .put() method, which is how we insert data into maps
		//I'm using my charmander and rattata objects from the Set section
		pokeMap.put(1, charmander);
		pokeMap.put(2, charmander);
		pokeMap.put(15, charmander);
		pokeMap.put(4, rattata);
		
		//we can put whatever we want for the keys and values! keys don't need to start at zero, or go in order
		
		//print our map out - note that the keys are ordered, but there's no empty keys, it just skips from 4 to 15 for instance
		System.out.println(pokeMap);
		//we have to print maps this way because .forEach() only exists for Collections. Again, maps are not collections
		
		//we can find values in a map by using .get() for a key
		System.out.println(pokeMap.get(4));
		System.out.println(pokeMap.get(15));
		
	}
	
}
