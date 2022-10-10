package com.destinationCity;
import java.util.*;

/*
You are given the array paths, where paths[i] = [cityAi, cityBi] 
means there exists a direct path going from cityAi to cityBi. 
Return the destination city, that is, the city without any path 
outgoing to another city.

It is guaranteed that the graph of paths forms a line without 
any loop, therefore, there will be exactly one destination city.


Example 1:

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo" 
Explanation: Starting at "London" city you will reach "Sao Paulo" city 
which is the destination city. 
Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".

Example 2:

Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are: 
"D" -> "B" -> "C" -> "A". 
"B" -> "C" -> "A". 
"C" -> "A". 
"A". 
Clearly the destination city is "A".

Example 3:

Input: paths = [["A","Z"]]
Output: "Z"
*/

public class E1436_Destination_City {

	public static void main(String[] args) {
		List<List<String>> input = Arrays.asList(Arrays.asList("London","New York"),
                Arrays.asList("New York","Lima"),
                Arrays.asList("Lima","Sao Paulo"));
        String output = destCity(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Obeservation : destination city will always be the right one
	traverse the input for two times
	first time, add all the cities on the right side to a set
	second time, check if the city occurs on the left side, if so, remove it from the set
	result will be the city left in the set
    */
	
	/**
     * @param path: a string array
     * @return: the destination city
     */
	public static String destCity(List<List<String>> paths) {
        Set<String> set= new HashSet<>();
        for (List<String> l: paths) {
            set.add(l.get(1));
        }
        for (List<String> l: paths) {
            set.remove(l.get(0));
        }
        return set.iterator().next();
    }

}
