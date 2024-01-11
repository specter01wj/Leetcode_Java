package com.evaluateDivision;
import java.util.*;

/*
You are given an array of variable pairs equations and an array 
of real numbers values, where equations[i] = [Ai, Bi] and values[i] 
represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string 
that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents 
the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, 
return -1.0.
*/

public class M399_Evaluate_Division {

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>(Arrays.asList(
			    new ArrayList<>(Arrays.asList("a", "b")), 
			    new ArrayList<>(Arrays.asList("b", "c"))
			));
		double[] values = {2.0,3.0};
		List<List<String>> queries = new ArrayList<>(Arrays.asList(
			    new ArrayList<>(Arrays.asList("a", "c")), 
			    new ArrayList<>(Arrays.asList("b", "a")), 
			    new ArrayList<>(Arrays.asList("a", "e")), 
			    new ArrayList<>(Arrays.asList("a", "a")), 
			    new ArrayList<>(Arrays.asList("x", "x"))
			));
		double[] output = calcEquation(equations, values, queries);
        System.out.println("input1: " + (equations) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(src, new HashMap<>());
            graph.get(src).put(dest, value);

            graph.putIfAbsent(dest, new HashMap<>());
            graph.get(dest).put(src, 1 / value);
        }

        double[] result = new double[queries.size()];

        // Process each query
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            result[i] = graph.containsKey(src) && graph.containsKey(dest) 
                ? dfs(graph, src, dest, new HashSet<>()) 
                : -1.0;
        }

        return result;
    }

    private static double dfs(Map<String, Map<String, Double>> graph, String src, String dest, Set<String> visited) {
        if (src.equals(dest)) return 1.0;
        visited.add(src);

        if (!graph.containsKey(src)) return -1.0;

        for (Map.Entry<String, Double> neighbor : graph.get(src).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double product = dfs(graph, neighbor.getKey(), dest, visited);
                if (product != -1.0) {
                    return neighbor.getValue() * product;
                }
            }
        }

        return -1.0;
    }

}
