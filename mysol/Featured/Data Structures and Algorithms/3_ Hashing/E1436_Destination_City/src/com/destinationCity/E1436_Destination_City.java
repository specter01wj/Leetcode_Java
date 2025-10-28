package com.destinationCity;
import java.util.*;

/*
You are given the array paths, where paths[i] = [cityAi, cityBi] 
means there exists a direct path going from cityAi to cityBi. 
Return the destination city, that is, the city without any path 
outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, 
therefore, there will be exactly one destination city.
*/

public class E1436_Destination_City {

	public static void main(String[] args) {
		E1436_Destination_City solution = new E1436_Destination_City();
		List<List<String>> input = Arrays.asList(
	            Arrays.asList("London", "New York"),
	            Arrays.asList("New York", "Lima"),
	            Arrays.asList("Lima", "Sao Paulo")
	        );
		String output = solution.destCity(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashSet
    */
	
	/*
     * @param nums: a list of 2D strings
     * @return: the destination city
     */
	public String destCity(List<List<String>> paths) {
        Set<String> startingCities = new HashSet<>();

        // Collect all starting cities
        for (List<String> path : paths) {
            startingCities.add(path.get(0));
        }

        // The destination city is the one that never appears as a starting city
        for (List<String> path : paths) {
            String destination = path.get(1);
            if (!startingCities.contains(destination)) {
                return destination;
            }
        }

        return ""; // fallback (should not occur per problem constraints)
    }

}
